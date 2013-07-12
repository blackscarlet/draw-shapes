package test1;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import javax.swing.*;

class PaintShapes extends JPanel{
	public int x1,x2,y1,y2,sizeX,sizeY;
	public int rect_sizeX, rect_sizeY, oval_sizeX, oval_sizeY;
	public String type;
	ArrayList<Shapes> arrayOfShapes = new ArrayList<Shapes>();
//-------------------

// ------------------
	public PaintShapes(){
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);

	}

	private class MouseHandler extends MouseAdapter implements MouseMotionListener {

		public void mousePressed(MouseEvent m){
			x1 = m.getX();
			y1 = m.getY();
		}

		public void mouseReleased(MouseEvent m){
			x2 = m.getX();
			sizeX = m.getX() - x1;
			y2 = m.getY();
			sizeY = m.getY() - y1;
			saveShapes();
			repaint();
		}

		public void mouseDragged(MouseEvent m){
			x2 = m.getX();
			sizeX = m.getX() - x1;
			y2 = m.getY();
			sizeY = m.getY() - y1;
			repaint();
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int diameter = (int) Math.round(new Point(x1,y1).distance(new Point(x2,y2)));
        
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
			else if (shapes.type=="Angle"){
				System.out.println("Drwaing Angle");
			}
		}
		g.drawString("("+ String.valueOf(x1)+":"+String.valueOf(y1)+")", x1, y1);
		g.drawString("("+ String.valueOf(sizeX)+":"+String.valueOf(sizeY)+")", x2, y2);
		if (this.type=="Rectangle"){
			g2.drawRect(x1,y1,sizeX,sizeY);
			}
		else if(this.type=="Oval"){
			g.drawOval(x1, y1, sizeX, sizeY);
			}
		if(this.type=="Arc"){
			g.drawArc(x1, y1, sizeX, sizeY, 0, 180);
		}
		if(this.type=="InvArc"){
			g.drawArc(x1, y1, sizeX, sizeY, 0, -180);
		}
		if(this.type=="Arc2D"){
			g2.draw(new Arc2D.Double(x1, y1, sizeX, sizeY, 0, -180, Arc2D.CHORD));
		}
		if(this.type=="Angle"){
			g.setColor(Color.BLUE);
	//	g.fillRect(x1-1, y1-1, 3, 3); // g.drawString("p1", x1, y1);   
    //  g.fillRect(x2-1, y2-1, 3, 3); // g.drawString("p2", x2, y2);
//      Graphics2D g2d = (Graphics2D) g;
        g2.translate(x1, y1);
        g2.rotate(angle);
        g2.drawArc(0, -diameter/2, diameter, diameter, 0, 180);
       // Draws an arrow at initial point of arc
      //  g2d.fill(new Polygon(new int[] {0,10,-10}, new int[] {0,-10,-10}, 3));
		}
	}
	

	public void saveShapes(){
		arrayOfShapes.add(new Shapes(type,x1,y1,sizeX,sizeY));
		System.out.println("Size of " + type + ":" + x1 +"," +y1+ ":" + sizeX + "," + sizeY);
	}
} 

