package test1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGui2 {

	/** This class shows two buttons that can be clicked	 */
	JFrame frame;
	JButton button1;
	JButton button2;
	
	public static void main(String[] args) {		
	System.out.println("SimpleGui2 is running!");
	SimpleGui2 gui = new SimpleGui2();
	gui.start();
	}

	class Button1action implements ActionListener{
		public void actionPerformed(ActionEvent event){
			button1.setText("Clicked!!!!");
		}
	}
	
	class Button2action implements ActionListener{
			public void actionPerformed(ActionEvent event){
				button2.setText("Clicked Two!");
				button2.setBackground(Color.RED);
				//frame.getContentPane().add(BorderLayout.CENTER, button1);
			}
	}
	public void start(){
		frame = new JFrame();
		button1 = new JButton("One");
		button2 = new JButton("Two");
		button1.addActionListener(new Button1action());
		button2.addActionListener(new Button2action());
		
				
		frame.getContentPane().add(BorderLayout.NORTH, button2);
		frame.getContentPane().add(BorderLayout.SOUTH, button1);
		frame.setVisible(true);
		frame.setSize(350,350);
	
	}
			
		
}

