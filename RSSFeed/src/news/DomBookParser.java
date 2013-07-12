package news;

import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.*;

public class DomBookParser {

	public static void main(String[] args){
		try{
			DocumentBuilderFactory fact1 = DocumentBuilderFactory.newInstance();
			fact1.setValidating(true);
			fact1.setIgnoringElementContentWhitespace(true);
			DocumentBuilder build1 = fact1.newDocumentBuilder();
			String book1 = "src/news/book.xml";
			Document bookDoc = build1.parse(new File(book1));
			Element bookEle = bookDoc.getDocumentElement();
			NodeList chapterNodes = bookEle.getChildNodes();
			
			for(int i=0; i<chapterNodes.getLength(); i++){
				Element chapter = (Element) chapterNodes.item(i);
				System.out.print("Value: " + chapter.getNodeName() + " ");
				NodeList numberList = chapter.getElementsByTagName("chapNum");
				Text number = (Text) numberList.item(0).getFirstChild();
				System.out.print(number.getData() + " ");
				NodeList titleList = chapter.getElementsByTagName("chapTitle");
				Text title = (Text) titleList.item(0).getFirstChild();
				System.out.println(title.getData());		
			}
		}catch (Exception error){
			System.out.println("error parsing"+ error.getMessage());
			System.exit(1);
			}
	}
}
