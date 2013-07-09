package test1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

class DrawObjects extends JPanel
{
public int x1,x2,y1,y2;
public int rect_sizeX, rect_sizeY, oval_sizeX, oval_sizeY;
public String type;//default draw type


public DrawObjects(){
      setBackground(Color.WHITE);

    //  this.setBackground(Color.WHITE);
    //  this.setBounds(0, 100, 300, 300);
     // this.setSize(400, 400);
      MouseHandler handler = new MouseHandler();
      this.addMouseListener(handler);
      this.addMouseMotionListener(handler);

}
      private class MouseHandler extends MouseAdapter implements
      MouseMotionListener {
      //addMouseListener(new MouseAdapter()
       //{
          public void mousePressed(MouseEvent m)
          {
               x1 = m.getX();
               y1 = m.getY();
              // repaint();
          }
          public void mouseReleased(MouseEvent m)
          {
               x2 = m.getX() - x1;
               y2 = m.getY() - y1;
               saveShapes();
               repaint();
               
          }
       // });

   //   addMouseMotionListener(new MouseMotionAdapter()
     //   {
           public void mouseDragged(MouseEvent m)
              {
                 x2 = m.getX() - x1;
                 y2 = m.getY() - y1;
                 repaint();
              }
       //   }); 
}

public void setType(String type){
  /*  if(arg == 1){
        type = 1;
    }else if(arg == 2){
        type = 2;
    } */
	this.type = type;
}

  public void paintComponent(Graphics g)
  { 
      super.paintComponent(g);
      if(type=="Rectangle")
      {
          g.drawRect(x1,y1,x2,y2);
      }
      else if (type=="Oval")
      {
          g.drawOval(x1,y1,x2,y2);
      }
  }
  
  public void saveShapes(){
	  ArrayList<Shapes> arrayOfShapes = new ArrayList<Shapes>();
     // if(type==1){
   	 //  	rect_sizeX = x2;
     // 	   rect_sizeY = y2;
     // 	   System.out.println("Size of rectangle: " + x2 + "," + y2);
     	   arrayOfShapes.add(new Shapes(type,x1, y1, x2,y2));
     // if(type==2){
   	 //  oval_sizeX = x2;
   	 //  oval_sizeY = y2;
   	  System.out.println("Size of " + type + ":" + x2 + "," + y2);
   	 }
  } 
  
