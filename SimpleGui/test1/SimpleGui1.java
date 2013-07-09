package test1;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGui1 implements ActionListener {

	/** This class demonstrates the action of a button click!	 */
	JFrame frame = new JFrame();
	JButton button1 = new JButton("One");
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SimpleGui1 gui = new SimpleGui1();
		gui.start();
	}

	
	public void start(){
	
	frame.getContentPane().add(button1);
	frame.setVisible(true);
	frame.setSize(350,350);
	button1.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent event){
		button1.setText("Clicked One");
		
	}
		
		
}

