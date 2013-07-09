package news;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;


public class GuiOutput extends JFrame {
	
	private JFrame window = new JFrame();
	
	GuiOutput(){
	buildGui();
	}
	
	public void buildGui(){
	
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JTextArea textArea = new JTextArea(5, 20);
	//JScrollPane scrollPane = new JScrollPane(textArea); 
	textArea.setEditable(false);
	JScrollPane areaScrollPane = new JScrollPane(textArea);
	areaScrollPane.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	areaScrollPane.setPreferredSize(new Dimension(500, 500));
	
	RSSReaderDom reader = RSSReaderDom.getInstance();
	ArrayList<String> arrayResult = new ArrayList<String>();
	arrayResult = reader.writeNews();
	
	for(String ar : arrayResult){
	textArea.append(ar);
	}
	}
	
	
	public static void main(String[] args){
		new GuiOutput();
			
	}
}
