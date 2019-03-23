//Maximillian Marciel
//In-class assignment #6
//DrawBoxes.java

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
   private int screenSize = 600;
               
   Hw4()
   {
      setTitle("Box Drawer");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      setSize(screenSize,screenSize);
      addMouseListener(new MyMouseListener());
      addMouseMotionListener(new MyMouseMotionListener());
      setVisible(true);
      setResizable(false);
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
      
      
   }
   
   private void drawMoon(int distanceX, int distanceY, Graphics g, Color c)
   {
      double factor = 0.02;
      double cordY = factor * distanceY;
      double cordX = factor * distanceX;
      int icordX = (int) cordX;
      int icordY = (int) cordY;
      // Draw shape 1 (moon)
      g.setColor(c);
      g.fillOval(icordX + 400, icordY + 90, 75, 75);
   }
   
   private void drawBackMtn(int distanceX, int distanceY, Graphics g, Color c)
   {
      double factor = 0.1;
      double cordY = factor * distanceY;
      double cordX = factor * distanceX;
      int icordX = (int) cordX;
      int icordY = (int) cordY;
      g.setColor(c);
      int xValues[] = {icordX + 250, icordX + 500, icordX - 500};
      int yValues[] = {icordY + 150, icordY + 900, icordY + 900};
      g.fillPolygon(xValues, yValues, 3);
   }
   
   private void drawMidMtn(int distanceX, int distanceY, Graphics g, Color c)
   {
      double factor = 0.15;
      double cordY = factor * distanceY;
      double cordX = factor * distanceX;
      int icordX = (int) cordX;
      int icordY = (int) cordY;
      g.setColor(c);
      int xValues[] = {icordX + 455, icordX + 855, icordX - 155};
      int yValues[] = {icordY + 200, icordY + 800, icordY + 800};
      g.fillPolygon(xValues, yValues, 3);
   }
   
   private void drawFrontMtn(int distanceX, int distanceY, Graphics g, Color c)
   {
      double factor = 0.20;
      double cordY = factor * distanceY;
      double cordX = factor * distanceX;
      int icordX = (int) cordX;
      int icordY = (int) cordY;
      g.setColor(c);
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
         // Get the mouse cursor coordinates.
         //currentX = e.getX();
         //currentY = e.getY();
         //repaint();
      }

      //
      // The following methods are unused, but still
      // required by the MouseListener interface.
      //

      public void mouseClicked(MouseEvent e)
      {
      }

      public void mouseReleased(MouseEvent e)
      {
      }

      public void mouseEntered(MouseEvent e)
      {
      }

      public void mouseExited(MouseEvent e)
      {
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
