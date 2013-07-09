	/*
	* To change this template, choose Tools | Templates
	* and open the template in the editor.
	*/

	/**
	*
	* @author vijay

	*
	*/
	package news;
	import java.net.URL;
import java.util.ArrayList;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;

	import org.w3c.dom.CharacterData;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.Node;
	import org.w3c.dom.NodeList;

	public class RSSReaderDom {

	private static RSSReaderDom instance = null;
	ArrayList<String> arrayTest = new ArrayList<String>();
	private RSSReaderDom() {
	}

	public static RSSReaderDom getInstance() {
	if(instance == null) {
	instance = new RSSReaderDom();
	}
	return instance;
	}


	public ArrayList<String> writeNews() {
	try {

	DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	URL u = new URL("http://rss.theweathernetwork.com/weather/caon0696");		// your feed url

	Document doc = builder.parse(u.openStream());

	NodeList nodes = doc.getElementsByTagName("item");
	
	for(int i=0;i<nodes.getLength();i++) {

	Element element = (Element)nodes.item(i);
	System.out.println(arrayTest.add("Title: " + getElementValue(element,"title")));
	System.out.println(arrayTest.add("Link: " + getElementValue(element,"link")));
	System.out.println(arrayTest.add("Publish Date: " + getElementValue(element,"pubDate")));
	System.out.println(arrayTest.add("author: " + getElementValue(element,"dc:creator")));
	System.out.println(arrayTest.add("comments: " + getElementValue(element,"wfw:comment")));
	System.out.println(arrayTest.add("description: " + getElementValue(element,"description")));
	System.out.println();
	}//for
	}//try
	catch(Exception ex) {
	ex.printStackTrace();
	}
	return arrayTest;
	}

	private String getCharacterDataFromElement(Element e) {
	try {
	Node child = e.getFirstChild();
	if(child instanceof CharacterData) {
	CharacterData cd = (CharacterData) child;
	return cd.getData();
	}
	}
	catch(Exception ex) {

	}
	return "";
	} //private String getCharacterDataFromElement

	protected float getFloat(String value) {
	if(value != null && !value.equals("")) {
	return Float.parseFloat(value);
	}
	return 0;
	}

	protected String getElementValue(Element parent,String label) {
	return getCharacterDataFromElement((Element)parent.getElementsByTagName(label).item(0));
	}

	// public static void main(String[] args) {
	//public void doRead(){
//	RSSReaderDom reader = RSSReaderDom.getInstance();
//	reader.writeNews();
//	}
	}