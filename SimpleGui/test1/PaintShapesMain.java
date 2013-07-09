package test1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintShapesMain extends JFrame
{
	private PaintShapes panel = new PaintShapes();
	private JPanel BPanel = new JPanel();
	private JFrame window = new JFrame();

	//constructor
	PaintShapesMain(){
		buildGUI(); 
	}

	void buildGUI(){
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());
		window.add(panel, BorderLayout.CENTER);
		window.add(BPanel,BorderLayout.SOUTH);
		BPanel.setBackground(Color.blue);

		ImageIcon rectImage = new ImageIcon("image/rect.jpg");
		ImageIcon ovalImage = new ImageIcon("image/oval.jpg");
		JButton rect = new JButton(rectImage);
		JButton oval = new JButton();
		JButton arc = new JButton("Arc");
		JButton invarc = new JButton("InvertedArc");
		JButton arc2d = new JButton("Arc2D");
		oval.setIcon(ovalImage);
		BPanel.add(rect);
		BPanel.add(oval);
		BPanel.add(arc);
		BPanel.add(invarc);
		BPanel.add(arc2d);
	
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
		
		arc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				panel.setType("Arc");
			}
		}); 
		
		invarc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				panel.setType("InvArc");
			}
		});
		
		arc2d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				panel.setType("Arc2D");
			}
		});
		
		window.setVisible(true);
		window.setSize(600, 600);     
	}

	public static void main(String[] args)
	{
		new PaintShapesMain();
	}

}