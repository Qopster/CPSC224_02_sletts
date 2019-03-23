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
      int screenCenter = screenSize/2;
      int distanceX = currentX - screenCenter;
      int distanceY = currentY - screenCenter;
      
      //Colors
      Color pale = new Color(250, 250, 250);
      
      //Shape 1 (Background moon)
      double factor1 = 0.02;
      double cordY1 = factor1 * distanceY;
      double cordX1 = factor1 * distanceX;
      int icordX1 = (int) cordX1;
      int icordY1 = (int) cordY1;
      
      //Draw unmoving background (Night sky)
      g.setColor(new Color(10,10,75));
      g.fillRect(0, 0, screenSize, screenSize);
      
      // Draw shape 1 (moon)
      g.setColor(pale);
      g.fillOval(icordX1 + 400, icordY1 + 90, 75, 75);
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
