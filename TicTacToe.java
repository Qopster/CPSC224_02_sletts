import javax.swing.*; // Needed for Swing classes
import java.awt.*;    // Needed for BorderLayout class

/**
   This class demonstrates the BorderLayout manager.
*/

public class TicTacToe extends JFrame
{
   private final int WINDOW_WIDTH = 400;   // Window width
   private final int WINDOW_HEIGHT = 300;  // Window height

   /**
      Constructor
   */

   public TicTacToe()
   {
      // Set the title bar text.
      setTitle("Border Layout");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Add a BorderLayout manager to the content pane.
      setLayout(new BorderLayout());

      // Create five buttons.
      JButton button1 = new JButton("NW");
      JButton button2 = new JButton("NC");
      JButton button3 = new JButton("NE");
      JButton button4 = new JButton("WC");
      JButton button5 = new JButton("CC");
	  JButton button6 = new JButton("CE");
      JButton button7 = new JButton("SW");
      JButton button8 = new JButton("SC");
      JButton button9 = new JButton("SE");

      // Add the five buttons to the content pane.
      add(button1, BorderLayout.NORTH);
      add(button2, BorderLayout.NORTH);
      add(button3, BorderLayout.NORTH);
      add(button4, BorderLayout.WEST);
      add(button5, BorderLayout.CENTER);

      // Display the window.
      setVisible(true);
   }

   /**
      The main method creates an instance of the TicTacToe
      class, causing it to display its window.
   */
   
   public static void main(String[] args)
   {
      new TicTacToe();
   }
}
