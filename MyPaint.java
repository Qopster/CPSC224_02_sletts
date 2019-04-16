import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyPaint extends JFrame {

   private int currentX = 0; // Mouse cursor's X position
   private int currentY = 0; // Mouse cursor's Y position
   private boolean mouseClicked = false;
   private boolean mouseDragged = false;
   private boolean mouseMoved   = false;
   private boolean mousePressed = false;
   private boolean mouseReleased = true;
   
   MyPaint()
   {
       //Initializing the window, and the listeners
      setTitle("PaintPal");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      setSize(900,900);
      addMouseListener(new MyMouseListener());
      addMouseMotionListener(new MyMouseMotionListener());
      setVisible(true);
      setResizable(false);
   }
   
   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      //super.paint(g);
      g.fillOval(currentX,currentY,10,10);
   }
   
   private class MyMouseListener implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
      }
      
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

   private class MyMouseMotionListener implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
          currentX = e.getX();
          currentY = e.getY();
          repaint();
      }
      
      public void mouseMoved(MouseEvent e)
      {
      }
   }
    
    public static void main(String[] args) {
        new MyPaint();
    }
    
}
