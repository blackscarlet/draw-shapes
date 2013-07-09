package news;

import java.io.*;
import java.net.*;

public class RSSReader {

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
			while((line=in.readLine())!=null){
				System.out.println("String line start of while: "+line);
				if(line.contains("<title>")){
					System.out.println("String line: "+line);
					int firstPos = line.indexOf("<title>");
					String temp = line.substring(firstPos);
					temp = temp.replace("<title>","");
					int lastPos = temp.indexOf("</title>");
					System.out.println("String temp: "+temp);
					temp = temp.substring(0,lastPos);
					sourceCode +=temp+"\n";
				}
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
