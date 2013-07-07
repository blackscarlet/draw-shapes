package test1;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import javax.swing.*;

class PaintShapes extends JPanel{
	public int x1,x2,y1,y2;
	public int rect_sizeX, rect_sizeY, oval_sizeX, oval_sizeY;
	public String type;
	ArrayList<Shapes> arrayOfShapes = new ArrayList<Shapes>();

	public PaintShapes(){
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);

	}

	private class MouseHandler extends MouseAdapter implements	MouseMotionListener {

		public void mousePressed(MouseEvent m){
			x1 = m.getX();
			y1 = m.getY();
		}

		public void mouseReleased(MouseEvent m){
			x2 = m.getX() - x1;
			y2 = m.getY() - y1;
			saveShapes();
			repaint();
		}

		public void mouseDragged(MouseEvent m){
			x2 = m.getX() - x1;
			y2 = m.getY() - y1;
			repaint();
		}
	}

	public void setType(String type){
		this.type = type;
	}

	public void paintComponent(Graphics g){ 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Shapes shapes: arrayOfShapes){
			if(shapes.type=="Rectangle"){
				g.drawRect(shapes.posX,shapes.posY,shapes.sizeX,shapes.sizeY);}
			else if (shapes.type=="Oval"){
				g.drawOval(shapes.posX,shapes.posY,shapes.sizeX,shapes.sizeY);}
			else if (shapes.type=="Arc"){
				g.drawArc(shapes.posX,shapes.posY,shapes.sizeX,shapes.sizeY, 0, 180);}
			else if (shapes.type=="InvArc"){
				g.drawArc(shapes.posX,shapes.posY,shapes.sizeX,shapes.sizeY, 0, -180);}
			else if (shapes.type=="Arc2D"){
				g2.draw(new Arc2D.Double(shapes.posX,shapes.posY,shapes.sizeX,shapes.sizeY, 0, -180, Arc2D.CHORD));}
		}
		
		if (this.type=="Rectangle"){
			g.drawRect(x1,y1,x2,y2);}
		else if(this.type=="Oval"){
			g.drawOval(x1, y1, x2, y2);
			}
		if(this.type=="Arc"){
			g.drawArc(x1, y1, x2, y2, 0, 180);
		}
		if(this.type=="InvArc"){
			g.drawArc(x1, y1, x2, y2, 0, -180);
		}
		if(this.type=="Arc2D"){
			g2.draw(new Arc2D.Double(x1, y1, x2, y2, 0, -180, Arc2D.CHORD));
		}
		}
	

	public void saveShapes(){
		arrayOfShapes.add(new Shapes(type,x1,y1,x2,y2));
		System.out.println("Size of " + type + ":" + x1 +"," +y1+ ":" + x2 + "," + y2);
	}
} 

