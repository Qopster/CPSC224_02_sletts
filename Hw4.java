//Maximillian Marciel & Sean Letts
//Hw4
//Hw4.java

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;

/**
   This applet demonstrates how mouse events and mouse
   motion events can be handled. It lets the user draw
   boxes by dragging the mouse.
*/

public class Hw4 extends JFrame
{
	private int currentX = 0; // Mouse cursor's X position
	private int currentY = 0; // Mouse cursor's Y position
	private int width = 0;    // The rectangle's width
	private int height = 0;   // The rectangle's height
   
	private boolean mouseClicked;
	private boolean mouseEntered;
	private boolean mouseExited;
   
	Hw4()
	{
		setTitle("HW4 Sean and Max");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(600,600);
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseMotionListener());
		setVisible(true);
	}
   
	/**
		paint method
		@param g The applet's Graphics object.
	*/
   
	public void paint(Graphics g)
	{
      // Call the superclass's paint method.
    super.paint(g);
      
    int screenCenter = 300;
    double factor = 0.3;
    int distanceX = currentX - screenCenter;
    int distanceY = currentY - screenCenter;
    double cordY = factor * distanceY;
    double cordX = factor * distanceX;
    int icordX = (int) cordX;
    int icordY = (int) cordY;
	
	//makes the grass
	double grassFactor;
	double GrassY;
	double GrassX;
	g.setColor(Color.green.darker());
	g.fillRect(icordX + -200, icordY + 500, 1000, 1000);
	//makes the grass blades
	int startingGrassX = -200;
	while(startingGrassX < 1000){
		g.fillRect(icordX + startingGrassX, icordY + 490, 5, 10);
		startingGrassX = startingGrassX + 10;
	}
	//makes a tree
	Color brown = new Color(165, 113, 78);
	g.setColor(brown.darker());
	g.fillRect(icordX + 533, icordY + 450, 25, 100);
	g.setColor(Color.green.darker().darker());
	g.fillOval(icordX + 500, icordY + 400, 100, 100);
	//makes the tree's apples
	g.setColor(Color.red);
	g.fillOval(icordX + 550, icordY + 450, 10, 10);
	g.fillOval(icordX + 530, icordY + 430, 10, 10);
	g.fillOval(icordX + 530, icordY + 445, 10, 10);
	g.fillOval(icordX + 570, icordY + 465, 10, 10);
	g.fillOval(icordX + 570, icordY + 440, 10, 10);
	//if Statements for if the mouse is messed with
	if(mouseClicked){
		g.setColor(Color.orange);
		g.fillOval(currentX, currentY, 10, 10);
		mouseClicked = false;
	}
	if(mouseEntered){
		//Set the color to red
		g.setColor(Color.red);
		// Draw the rectangle
		g.fillRect(200, 200, 160, 75);
		// Set the drawing color to white. 
		g.setColor(Color.white);
		// Set the font and write inside
		g.setFont(new Font("SansSerif", Font.BOLD, 35)); 
		g.drawString("INSIDE", 225, 250);
		mouseEntered = false;
	}
	if(mouseExited){
		//Set the color to red
		g.setColor(Color.red);
		// Draw the rectangle
		g.fillRect(200, 200, 175, 75);
		// Set the drawing color to white. 
		g.setColor(Color.white);
		// Set the font and write inside
		g.setFont(new Font("SansSerif", Font.BOLD, 35)); 
		g.drawString("EXITED", 225, 250);
		mouseExited = false;
	}
	}
   
   /**
      Mouse listener class
   */

	private class MyMouseListener implements MouseListener
	{
		public void mousePressed(MouseEvent e)
		{
			//was told implimentation not needed
		}
		public void mouseClicked(MouseEvent e)
		{
			mouseClicked = true;
			currentX = e.getX();
			currentY = e.getY();
			repaint();
		}

		public void mouseReleased(MouseEvent e)
		{
			//was told implimentation not needed
		}

		public void mouseEntered(MouseEvent e)
		{
			mouseEntered = true;
			currentX = e.getX();
			currentY = e.getY();
			repaint();
		}

		public void mouseExited(MouseEvent e)
		{
			mouseExited = true;
			currentX = e.getX();
			currentY = e.getY();
			repaint();
		}
	}
   
   /**-----------------------------
      Mouse Motion listener class |
   *///----------------------------

	private class MyMouseMotionListener implements MouseMotionListener
	{
		public void mouseDragged(MouseEvent e)
		{
		}
		public void mouseMoved(MouseEvent e)
		{
			currentX = e.getX();
			currentY = e.getY();
			repaint();
		}
	}
	public static void main(String[] args)
	{
		new Hw4();
	}
}
