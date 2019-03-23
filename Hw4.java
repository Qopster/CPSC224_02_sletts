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
               
   Hw4()
   {
      setTitle("Box Drawer");
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
      double factor = 0.5;
      int distanceX = currentX - screenCenter;
      int distanceY = currentY - screenCenter;
      double cordY = factor * distanceY;
      double cordX = factor * distanceX;
      int icordX = (int) cordX;
      int icordY = (int) cordY;
      
      // Draw a rectangle.
      g.drawRect(icordX + 200, icordY + 200, 200, 200);
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
