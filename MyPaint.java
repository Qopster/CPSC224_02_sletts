import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyPaint extends JFrame {

   //Mouse values
   private int currentX = 0; // Mouse cursor's X position
   private int currentY = 0; // Mouse cursor's Y position
   private int shapeX   = 0; //Beginning corner of a shape's drawing (X)
   private int shapeY   = 0; //Beginning corner of a shape's drawing (Y)
   
   //Size values
   private int brushSize = 100; //Size of the brush, to be changed by buttons
   
   //Color value
   private Color currentColor = Color.BLUE;
   
   //Current drawing mode (default is brushing)
   private boolean dragBrush    = false;
   private boolean drawingShape = true;
   private boolean drawingRect  = false;
   private boolean fillMode     = true;
   private boolean drawingOval  = true;
   
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
   
   private void switchToBrushMode()
   {
       resetAllSettings();
       dragBrush = true;
   }
   
   private void switchToFillMode()
   {
       resetAllSettings();
       drawingShape = true;
       fillMode     = true;
   }
   
   private void switchToOutlineMode()
   {
       resetAllSettings();
       drawingShape = true;
   }
   
   private void resetCurrentShape()
   {
       drawingRect = false;
       //More shapes to be added
   }
   
   private void resetAllSettings()
   {
       dragBrush    = false;
       drawingShape = false;
       drawingRect  = false;
       fillMode     = false;
   }
   
   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      //super.paint(g);
       
       //Set the current color
       g.setColor(currentColor);
       
       // ----------------------------------------------------------------------------------
       
      //Will only draw a brush if we set drawing a brush to be true and we are not
      //Currently drawing a shape.
      if (dragBrush && (!drawingShape))
      {
        g.fillOval(currentX - brushSize/2, currentY - brushSize/2, brushSize, brushSize);
      }
      
      // ----------------------------------------------------------------------------------
      
      //Will only draw a rectangle if drawing a shape is true.
      if (drawingRect && (drawingShape))
      {
          //If we are in fill mode then we fill the rectangle
          if (fillMode)
          {
              g.fillRect(shapeX, shapeY, currentX - shapeX, currentY - shapeY);
          }
          else //If we do not fill we merely draw the lines
          {
              g.drawRect(shapeX, shapeY, currentX - shapeX, currentY - shapeY);
          }
      }
      
      // ----------------------------------------------------------------------------------
      
      //Drawing oval
      if (drawingOval && (drawingShape))
      {
          //If we are in fill mode then we fill the rectangle
          if (fillMode)
          {
              g.fillOval(shapeX, shapeY, currentX - shapeX, currentY - shapeY);
          }
          else //If we do not fill we merely draw the lines
          {
              g.drawOval(shapeX, shapeY, currentX - shapeX, currentY - shapeY);
          }
      }
      
      // ----------------------------------------------------------------------------------
      
      
   }
   
   private class MyMouseListener implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
          if (drawingShape)
          {
            shapeX = e.getX();
            shapeY = e.getY();
          }
      }
      
      public void mouseClicked(MouseEvent e)
      {
      }

      public void mouseReleased(MouseEvent e)
      {
          if (drawingShape)
          {
            currentX = e.getX();
            currentY = e.getY();
            repaint();
          }
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
          if (dragBrush)
          {
            currentX = e.getX();
            currentY = e.getY();
            repaint();
          }
      }
      
      public void mouseMoved(MouseEvent e)
      {
      }
   }
    
    public static void main(String[] args) {
        new MyPaint();
    }
    
}
