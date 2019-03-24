import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;

/**
   This applet demonstrates how mouse events and mouse
   motion events can be handled. It lets the user draw
   boxes by dragging the mouse.
*/

public class Hw4 extends JFrame implements ActionListener
{
   //Drawing the parallax
   private int currentX = 0; // Mouse cursor's X position
   private int currentY = 0; // Mouse cursor's Y position
   private int width = 0;    // The rectangle's width
   private int height = 0;   // The rectangle's height
   private int screenSize = 600;
   private boolean mouseExited = false;
   private boolean mouseEntered = true;
   private boolean mouseClicked = false;
   private int msCount = 0;
   private boolean mouseDragged = false;
   
   //Drawing the birds
   private int delay = 30;
   private Timer timer;
   private int birdX = 0;		// x position

   private int dx = 2;		// increment amount (x coord)
   private int dy = 0;		// increment amount (y coord)
	
   private int bird1XValues[] = {-110, -85, -60};
   private int bird1YValues[] = {50, 60, 50};
	
   private int bird2XValues[] = new int[3];
   private int bird2YValues[] = new int[3];
	
   private int bird3XValues[] = new int[3];
   private int bird3YValues[] = new int[3];
	
   private int bird4XValues[] = new int[3];
   private int bird4YValues[] = new int[3];
	
   private int bird5XValues[] = new int[3];
   private int bird5YValues[] = new int[3];
               
   Hw4()
   {
      //Initializing the window, and the listeners
      setTitle("Box Drawer");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      setSize(screenSize,screenSize);
      addMouseListener(new MyMouseListener());
      addMouseMotionListener(new MyMouseMotionListener());
      setVisible(true);
      setResizable(false);
      
      //Initialize timer
      timer = new Timer(delay, (ActionListener) this);
      timer.start();
   }
   
   public void actionPerformed(ActionEvent e)
   {
	repaint();
   }
   
   /**
      paint method
      @param g The applet's Graphics object.
   */
   
   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      super.paint(g);
      
      //Screen center and size
      final int SCREEN_CENTER = screenSize/2;
      int distanceX = currentX - SCREEN_CENTER;
      int distanceY = currentY - SCREEN_CENTER;
      
      //Colors
      Color pale = new Color(250, 250, 250);
      Color nightSky = new Color(10,10,75);
      Color backMtn = new Color(255,0,0);
      
      //Draw unmoving background (Night sky)
      g.setColor(nightSky);
      g.fillRect(0, 0, screenSize, screenSize);
      
      //Draw the shapes
      drawMoon(distanceX, distanceY, g, pale);
      drawBackMtn(distanceX, distanceY, g, Color.gray.darker());
      drawMidMtn(distanceX, distanceY, g, Color.orange.darker());
      drawFrontMtn(distanceX, distanceY, g, Color.red.darker());
      drawForeground(distanceX, distanceY, g);
      
      //Handle the mouse events
      if(mouseClicked){
		g.setColor(Color.white);
		g.fillOval(currentX, currentY, 20, 20);
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
                //Make sure the inside stays for more than 1 frame
                msCount++;
                if (msCount >= 100)
                {
                    mouseEntered = false;
                    msCount = 0;
                }
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
        if (mouseDragged) {
            g.setColor(Color.red);
            g.fillOval(currentX + 5, currentY + 5, 10, 10);
            mouseDragged = false;
        }
        
        //Draw a flock of birds
        g.setColor(Color.red);		
        // check for boundaries for bird 1
        if (bird1XValues[0] < getWidth()){	
        	dx = Math.abs(dx);
        }
        if (bird1XValues[0] > getWidth()){		
            dx = -Math.abs(dx);
            bird1XValues[0] = -110;
            bird1XValues[1] = -85;
            bird1XValues[2] = -60;
        }
        // adjust bird position
        birdX += dx;
	g.drawPolyline(bird1XValues, bird1YValues, 3);
	for(int x = 0; x<3; x++){
            bird1XValues[x] += dx;
	}
	for(int x = 0; x<3; x++){
            bird2XValues[x] = bird1XValues[x] + 20;
	    bird2YValues[x] = bird1YValues[x] + 20;
	}
	for(int x = 0; x<3; x++){
            bird3XValues[x] = bird1XValues[x] + 40;
            bird3YValues[x] = bird1YValues[x] + 40;
	}
	for(int x = 0; x<3; x++){
            bird4XValues[x] = bird1XValues[x] + 20;
            bird4YValues[x] = bird1YValues[x] + 60;
	}
	for(int x = 0; x<3; x++){
            bird5XValues[x] = bird1XValues[x];
            bird5YValues[x] = bird1YValues[x] + 80;
	}
	g.drawPolyline(bird1XValues, bird1YValues, 3);
	g.drawPolyline(bird2XValues, bird2YValues, 3);
	g.drawPolyline(bird3XValues, bird3YValues, 3);
	g.drawPolyline(bird4XValues, bird4YValues, 3);
	g.drawPolyline(bird5XValues, bird5YValues, 3);
   }
   
   //Draws the foreground
   private void drawForeground(int distanceX, int distanceY, Graphics g)
   {
        double factor = 0.3;
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
   }
   
   //Draw the moon at the top right
   private void drawMoon(int distanceX, int distanceY, Graphics g, Color c)
   {
      //Calculating mouse distance based on the factor
      double factor = 0.02;
      double cordY = factor * distanceY;
      double cordX = factor * distanceX;
      int icordX = (int) cordX;
      int icordY = (int) cordY;
      
      //Set the color
      g.setColor(c);
      
      // Draw shape 1 (moon)
      g.fillOval(icordX + 400, icordY + 90, 75, 75);
   }
   
   //Draw the furthest back mountain
   private void drawBackMtn(int distanceX, int distanceY, Graphics g, Color c)
   {
      //Calculating mouse distance based on the factor
      double factor = 0.1;
      double cordY = factor * distanceY;
      double cordX = factor * distanceX;
      int icordX = (int) cordX;
      int icordY = (int) cordY;
      
      //Set the color
      g.setColor(c);
      
      //Draw the shape
      int xValues[] = {icordX + 250, icordX + 500, icordX - 500};
      int yValues[] = {icordY + 150, icordY + 900, icordY + 900};
      g.fillPolygon(xValues, yValues, 3);
   }
   
   //Draw the middle mountain
   private void drawMidMtn(int distanceX, int distanceY, Graphics g, Color c)
   {
       //Calculating mouse distance based on the factor
      double factor = 0.15;
      double cordY = factor * distanceY;
      double cordX = factor * distanceX;
      
      int icordX = (int) cordX;
      int icordY = (int) cordY;
      
      //Set the color
      g.setColor(c);
      
      //Draw the shape
      int xValues[] = {icordX + 455, icordX + 855, icordX - 155};
      int yValues[] = {icordY + 200, icordY + 800, icordY + 800};
      g.fillPolygon(xValues, yValues, 3);
   }
   
   //Draw the front mountain (Hill?)
   private void drawFrontMtn(int distanceX, int distanceY, Graphics g, Color c)
   {
      //Calculating mouse distance based on the factor
      double factor = 0.20;
      double cordY = factor * distanceY;
      double cordX = factor * distanceX;
      int icordX = (int) cordX;
      int icordY = (int) cordY;
      
      //Set the color
      g.setColor(c);
      
      //Draw the shape
      int xValues[] = {icordX + 275, icordX + 800, icordX - 300};
      int yValues[] = {icordY + 350, icordY + 800, icordY + 800};
      g.fillPolygon(xValues, yValues, 3);
   }
   
   /**
      Mouse listener class
   */

   private class MyMouseListener implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
         
      }
      public void mouseClicked(MouseEvent e)
      {
          if (!mouseClicked)
              mouseClicked = true;
          else
              mouseClicked = false;
	  currentX = e.getX();
	  currentY = e.getY();
	  repaint();
      }

      public void mouseReleased(MouseEvent e)
      {
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

   private class MyMouseMotionListener
                   implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
          mouseDragged = true;
          currentX = e.getX();
          currentY = e.getY();
          repaint();
      }
      public void mouseMoved(MouseEvent e)
      {
          //Get the mouse coordinates
          currentX = e.getX();
          currentY = e.getY();
          //Repaint every time the mouse moves
          repaint();
      }
   }
   public static void main(String[] args)
   {
      new Hw4();
   }
}
