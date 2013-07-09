package test1;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	int x =70;
	int y = 70;
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
	}
}
