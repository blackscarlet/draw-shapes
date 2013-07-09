package test1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawPanel extends JFrame
{
 private DrawObjects panel = new DrawObjects();
 private JPanel BPanel = new JPanel();
 private JFrame window = new JFrame();

 //constructor
 DrawPanel(){
    buildGUI(); 
 }

 void buildGUI(){
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.setLayout(new BorderLayout());
     window.add(panel, BorderLayout.CENTER);
     window.add(BPanel,BorderLayout.SOUTH);
     BPanel.setBackground(Color.blue);

      //define buttons and add to panel
      JButton rect = new JButton("Rect");
      JButton oval = new JButton("Oval");
      BPanel.add(rect);
      BPanel.add(oval);

      rect.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
              {
                  panel.setType("Rectangle");
              }
      });

      oval.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
              {
              panel.setType("Oval");
              }
          }); 

      window.setVisible(true);
      window.setSize(600, 600);     
}

 public static void main(String[] args)
  {
     //create this object
     new DrawPanel();
  }

  }//end class