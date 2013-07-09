package test1;
import javax.swing.*;

import java.awt.*;
//import java.awt.Graphics2D;
import java.awt.event.*;

public class AnimationBall1 implements ActionListener{
	int x =70;
	int y = 70;
	JFrame frame;
	JButton button;
	public static void main(String[] args){
		AnimationBall1 an = new AnimationBall1();
		an.go();
	}
	
	public class MyPanel1 extends JPanel{
	
		public void paintComponent(Graphics g){
			
			int red = (int) (Math.random()*255);
			int blue = (int) (Math.random()*255);
			int green  = (int) (Math.random()*255);
			Graphics2D g2d = (Graphics2D) g;
			Color startColor = new Color(red, blue, green);
			red = (int) (Math.random()*255);
			blue = (int) (Math.random()*255);
			green  = (int) (Math.random()*255);
			Color endColor = new Color(red, blue, green);
			GradientPaint gradient = new GradientPaint(70,70, startColor, 150, 150, endColor);
			g2d.setPaint(gradient);
			g2d.fillOval(x++, y++, 100, 100);
			//x+=50;
			//y+=50;
		}
	}
	public void go(){
		MyPanel1 panel = new MyPanel1();
		frame = new JFrame();
		button = new JButton("click me");
		button.addActionListener(this);
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.EAST, button);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
	}
	
	public void actionPerformed(ActionEvent event){
		for(int i=0; i<100; i++){
			//MyPanel1 panel = new MyPanel1();
			frame.repaint();
		button.setText("Clicked!"+i);
			try {
				Thread.sleep(50);
			}catch (Exception ex){}
		}
	}
	
}		

