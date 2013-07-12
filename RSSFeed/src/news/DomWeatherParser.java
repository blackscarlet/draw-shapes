package news;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class DomWeatherParser {
	
	public static void readRSS(String url){
		try{
			URL rssUrl = new URL(url);
		//	InputStream stream = new InputStream(rssUrl.openStream());
		//	String sourceCode =" ";
			
			DocumentBuilderFactory fact1 = DocumentBuilderFactory.newInstance();
			//fact1.setValidating(true);
			fact1.setIgnoringElementContentWhitespace(true);
			DocumentBuilder build1 = fact1.newDocumentBuilder();
			
			Document doc = build1.parse(rssUrl.openStream());
			System.out.println("Get doc type bookDoc: " + doc.getDoctype());
			//Element[] urlElements = ((Document) bookDoc).getRootElements();
//			Element bookEle = bookDoc.getDocumentElement();
//			NodeList nodes = bookEle.getChildNodes();
			
			NodeList nodes = doc.getElementsByTagName("item");
			
			System.out.println("Nodes: " +nodes.getLength());
			
			for(int i=0; i<nodes.getLength(); i++){
				
				if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE){
					Element item = (Element) nodes.item(i);
					System.out.println("Value: " + item.getNodeName() + " ");
				
					NodeList titleList = item.getElementsByTagName("title");
					Text num = (Text) titleList.item(0).getFirstChild();
					System.out.println(num.getData() + " ");
				
					NodeList numberList = item.getElementsByTagName("guid");
					Text number = (Text) numberList.item(0).getFirstChild();
					System.out.println(number.getData() + " ");
				
					NodeList desList = item.getElementsByTagName("description");
					Text title = (Text) desList.item(0).getFirstChild();
					System.out.println(title.getData());
				}
			}
			
		}catch(MalformedURLException ue){
			System.out.println("Malformed URL");
		}catch(IOException ioe){
			System.out.println("Something went wrong reading the contents");
		}catch (Exception error){
		System.out.println("error parsing"+ error.getMessage());
			System.exit(1);
		}
			
	}
	
	
	public static void main(String[] args){
		readRSS("http://rss.theweathernetwork.com/weather/caon0696");
	
	}
}
