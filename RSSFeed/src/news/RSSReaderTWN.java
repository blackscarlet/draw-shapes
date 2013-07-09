package news;


import java.io.*;
import java.net.*;

public class RSSReaderTWN {

	public static void main (String[] args){
		System.out.println(readRSS("http://rss.theweathernetwork.com/weather/caon0696"));
		// http://rss.theweathernetwork.com/weather/caon0696
		//http://rss.cnn.com/rss/edition.rss
	}
	
	public static String readRSS(String urlAddress){
		try{
			URL rssUrl = new URL(urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
			String sourceCode =" ";
			String line;
			int firstPos, lastPos, flag=0;
			String temp="";
			while((line=in.readLine())!=null){
			// if found start of description
				if(line.contains("<description>")&&(flag==0)){
					firstPos = line.indexOf("<description>");
					temp = line.substring(firstPos);
				//	temp = temp.replace("<description>","");
					flag =1;
					}
			//	if found end of description
				if(line.contains("</description>")&&(flag==1)){
					lastPos = temp.indexOf("</description>");
					temp = temp.substring(0,lastPos+12);
					sourceCode +=temp+"\n";
					flag =0;
				}							
			//	if within description tag (flag=1)
				if(flag==1){
					sourceCode +=line;
				}
						
		/*		int firstPos = line.indexOf("<title>");
					String temp = line.substring(firstPos);
					temp = temp.replace("<title>","");
					int lastPos = temp.indexOf("</title>");
					temp = temp.substring(0,lastPos);
					sourceCode +=temp+"\n";
		*/
			}
			in.close();
			return sourceCode;
		}catch(MalformedURLException ue){
			System.out.println("Malformed URL");
		}catch(IOException ioe){
			System.out.println("Something went wrong reading the contents");
		}
		return null;
	}
	
	
	
}

