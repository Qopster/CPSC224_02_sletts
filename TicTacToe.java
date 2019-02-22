import javax.swing.*; // Needed for Swing classes
import java.awt.event.*;
import java.awt.*;    // Needed for BorderLayout class

/**
   This class demonstrates the BorderLayout manager.
*/

public class TicTacToe extends JFrame
{
	private final int WINDOW_WIDTH = 400;   // Window width
	private final int WINDOW_HEIGHT = 300;  // Window height
	
	private JButton button1;    // Button 1
	private JButton button2;    // Button 2
	private JButton button3;    // Button 3
	private JButton button4;    // Button 4
	private JButton button5;    // Button 5
	private JButton button6;    // Button 6
	private JButton button7;    // Button 7
	private JButton button8;    // Button 8
	private JButton button9;    // Button 9
	
	public int turn = 1;

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
		
		JButton button1 = new JButton("");
		button1.setPreferredSize(new Dimension(40,40));
		button1.setFont(new Font("Arial", Font.BOLD, 24));
		button1.addActionListener(new ButtonListener());
		
		JButton button2 = new JButton("");
		button2.setPreferredSize(new Dimension(40,40));
		button2.setFont(new Font("Arial", Font.BOLD, 24));
		button2.addActionListener(new ButtonListener());
		
		JButton button3 = new JButton("");
		button3.setPreferredSize(new Dimension(40,40));
		button3.setFont(new Font("Arial", Font.BOLD, 24));
		button3.addActionListener(new ButtonListener());
		
		JButton button4 = new JButton("");
		button4.setPreferredSize(new Dimension(40,40));
		button4.setFont(new Font("Arial", Font.BOLD, 24));
		button4.addActionListener(new ButtonListener());
		
		JButton button5 = new JButton("");
		button5.setPreferredSize(new Dimension(40,40));
		button5.setFont(new Font("Arial", Font.BOLD, 24));
		button5.addActionListener(new ButtonListener());
		
		JButton button6 = new JButton("");
		button6.setPreferredSize(new Dimension(40,40));
		button6.setFont(new Font("Arial", Font.BOLD, 24));
		button6.addActionListener(new ButtonListener());
		
		JButton button7 = new JButton("");
		button7.setPreferredSize(new Dimension(40,40));
		button7.setFont(new Font("Arial", Font.BOLD, 24));
		button7.addActionListener(new ButtonListener());
		
		JButton button8 = new JButton("");
		button8.setPreferredSize(new Dimension(40,40));
		button8.setFont(new Font("Arial", Font.BOLD, 24));
		button8.addActionListener(new ButtonListener());
		
		JButton button9= new JButton("");
		button9.setPreferredSize(new Dimension(40,40));
		button9.setFont(new Font("Arial", Font.BOLD, 24));
		button9.addActionListener(new ButtonListener());
		
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
		setVisible(true);
	}

	public void checkForWinner(){
		//For all possible wins in rows
		if(button1.getText().equals(button2.getText()) &&  button2.getText().equals(button3.getText())){
			
		}
		else if(button4.getText().equals(button5.getText()) &&  button5.getText().equals(button6.getText())){
			
		}
		else if(button7.getText().equals(button8.getText()) &&  button8.getText().equals(button9.getText())){
			
		}
		//For al possible wins in collumns 
		else if(button1.getText().equals(button4.getText()) &&  button4.getText().equals(button7.getText())){
			
		}
		else if(button2.getText().equals(button5.getText()) &&  button5.getText().equals(button8.getText())){
			
		}
		else if(button3.getText().equals(button6.getText()) &&  button6.getText().equals(button9.getText())){
			
		}
		//For all possible wins across at diagonals
		else if(button1.getText().equals(button5.getText()) &&  button5.getText().equals(button9.getText())){
			
		}
		else if(button3.getText().equals(button5.getText()) &&  button5.getText().equals(button7.getText())){
			
		}
		//if the board is full and there is no winner
		//else if(!button1.getText().equals("") && !button2.getText().equals("") && !button3.getText().equals("") && 
		//		!button4.getText().equals("") && !button5.getText().equals("") && !button6.getText().equals("") && 
		//		!button7.getText().equals("") && !button8.getText().equals("") && !button9.getText().equals("")){
		//		JOptionPane.showMessageDialog(null, "Sorry no winners. New game!");
		//clearPannel(); 
		//	}
	}
	public void clearPannel(){
		button1.setText("");
		button2.setText("");
		button3.setText("");
		button4.setText("");
		button5.setText("");
		button6.setText("");
		button7.setText("");
		button8.setText("");
		button9.setText("");
	}
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String selected = ((JButton)e.getSource()).getText();
			JButton Bselect = (JButton)e.getSource();
			if( turn % 2 == 1 && selected == ""){
				Bselect.setText("X");
			}
			else if( turn % 2 == 0 && selected == ""){
				Bselect.setText("O");
			}
			else{
				turn--;
			}
			turn++;
		}
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
