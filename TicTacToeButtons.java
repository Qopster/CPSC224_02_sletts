//The tic tac toe board GUI

import javax.swing.*; // Needed for Swing classes
import java.awt.event.*;
import java.awt.*;    // Needed for BorderLayout class

public class TicTacToeButtons extends JPanel
{
    private final int WINDOW_WIDTH = 400;   // Window width
    private final int WINDOW_HEIGHT = 300;  // Window height
    
    public JButton[] tButton; // = new JButton[9];
    private boolean[] xArray;
    private boolean[] oArray;
    
    private int turn = 1;
    
    TicTacToeButtons()
    {
        tButton = new JButton[9];
        xArray = new boolean[9];
        oArray = new boolean[9];

	// Set the size of the window.
	//setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	// 3 High, 3 wide
        setLayout(new GridLayout(3,3));
        
        for (int i = 0; i < 9; i++)
        {
            tButton[i] = new JButton("");
	    tButton[i].setPreferredSize(new Dimension(40,40));
            tButton[i].setFont(new Font("Arial", Font.BOLD, 24));
            add(tButton[i]);
            xArray[i] = false;
            oArray[i] = false;
            tButton[i].setEnabled(false);
            
        }
    }
    public void clearPanel()
    {
        for (int i = 0; i < 9; i++)
        {
            xArray[i] = false;
            oArray[i] = false;
            tButton[i].setText("");
        }
        turn = 1;
    }
    
    public int getTurn()
    {
        return turn;
    }
    public void setTurn(int set)
    {
        turn = set;
    }
    public boolean getX(int index)
    {
        return xArray[index];
    }
    public boolean getO(int index)
    {
        return oArray[index];
    }
    public void setX(boolean b, int index)
    {
        xArray[index] = b;
    }
    public void setO(boolean b, int index)
    {
        oArray[index] = b;
    }
    public void disable()
    {
        for (int i = 0; i < 9; i++)
        {
            tButton[i].setEnabled(false);
        }
    }
    public void enable()
    {
        for (int i = 0; i < 9; i++)
        {
            tButton[i].setEnabled(true);
        }
    }
    public String getButtonContent(int index)
    {
        return tButton[index].getText();
    }
    public void setButtonContent(int index ,String x)
    {
        tButton[index].setText(x);
    }
    public void iterateTurn()
    {
        turn++;
    }
}
