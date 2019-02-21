import javax.swing.*; // Needed for Swing classes
import java.awt.*;    // Needed for BorderLayout class

/**
   This class demonstrates the BorderLayout manager.
*/

public class TicTacToe extends JFrame
{
	private final int WINDOW_WIDTH = 400;   // Window width
	private final int WINDOW_HEIGHT = 300;  // Window height
	
	private JPanel game;
	private JPanel topRow;
	
	private JPanel NE;
	private JPanel NC;
	private JPanel NW;
	
	private JPanel midRow;
	
	private JPanel CE;
	private JPanel CC;
	private JPanel CW;
	
	private JPanel botRow;
	
	private JPanel SE;
	private JPanel SC;
	private JPanel SW;
	
	private JLabel test;
	
	private JButton button1;    // Button 1
	private JButton button2;    // Button 2
	private JButton button3;    // Button 3
	private JButton button4;    // Button 4
	private JButton button5;    // Button 5
	private JButton button6;    // Button 6
	private JButton button7;    // Button 7
	private JButton button8;    // Button 8
	private JButton button9;    // Button 9

	/**
		Constructor
	*/

	public TicTacToe()
	{
		// Set the title bar text.
		setTitle("Tic Tac Toe Game");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add a BorderLayout manager to the content pane.
		setLayout(new BorderLayout());
	  
		game = new JPanel();
		
		topRow = new JPanel();
		NW = new JPanel();
		NC = new JPanel();
		NE = new JPanel();
		
		midRow = new JPanel();
		CW = new JPanel();
		CC = new JPanel();
		CE = new JPanel();
		
		botRow = new JPanel();
		SW = new JPanel();
		SC = new JPanel();
		SE = new JPanel();
		
		JButton button1 = new JButton("NW");
		button1.setPreferredSize(new Dimension(40,40));
		button1.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton button2 = new JButton("NC");
		button2.setPreferredSize(new Dimension(40,40));
		button2.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton button3 = new JButton("NE");
		button3.setPreferredSize(new Dimension(40,40));
		button3.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton button4 = new JButton("CW");
		button4.setPreferredSize(new Dimension(40,40));
		button4.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton button5 = new JButton("CC");
		button5.setPreferredSize(new Dimension(40,40));
		button5.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton button6 = new JButton("CE");
		button6.setPreferredSize(new Dimension(40,40));
		button6.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton button7 = new JButton("SW");
		button7.setPreferredSize(new Dimension(40,40));
		button7.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton button8 = new JButton("SC");
		button8.setPreferredSize(new Dimension(40,40));
		button8.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton button9= new JButton("SE");
		button9.setPreferredSize(new Dimension(40,40));
		button9.setFont(new Font("Arial", Font.BOLD, 24));
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
		
		setLayout(new GridLayout(3, 3));
		// Display the window.
		//pack();
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
