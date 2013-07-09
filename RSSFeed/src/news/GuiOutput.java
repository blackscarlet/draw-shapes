package news;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;


public class GuiOutput extends JFrame {
	
	private JTextArea textArea = new JTextArea();
	private JFrame window = new JFrame();
	//Where the member variables are defined:
//	private Ruler columnView;
//	private Ruler rowView;
	
	GuiOutput(){
	setUpFrame();
	}
	
	public void setUpFrame(){
	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea.setEditable(false);
		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(500, 500));
			
/*		//Create the row and column headers.
		columnView = new Ruler(Ruler.HORIZONTAL, true);
		rowView = new Ruler(Ruler.VERTICAL, true);		
		areaScrollPane.setColumnHeaderView(columnView);
		areaScrollPane.setRowHeaderView(rowView);
*/		
		window.setVisible(true);
		window.setSize(600,600);
		window.add(areaScrollPane);		
	}

	public void displayResult(RSSReaderDom reader){

		ArrayList<String> arrayResult = new ArrayList<String>();
		arrayResult = reader.writeNews();	
			for(String ar : arrayResult){
				textArea.append(ar +"\n");
			}
	}
	
	
	public static void main(String[] args){
		GuiOutput gui1 = new GuiOutput();
		RSSReaderDom reader = RSSReaderDom.getInstance();
		gui1.displayResult(reader);	
	}
}
