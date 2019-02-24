//Bottom buttons for the tic tac toe GUI

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BottomButtons extends JPanel
{
    private final int WINDOW_WIDTH = 200;
    private final int WINDOW_HEIGHT = 50;
    
    public JButton newGame;
    public JButton reset;
    public JButton exit;
    private JTextField bottomText;
    
    public BottomButtons()
    {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new GridLayout(2,3));
        
        bottomText = new JTextField(24);
        bottomText.setEditable(false);
        //bottomText.setPreferredSize(new Dimension(100,10));
        newGame = new JButton("New Game");
        reset = new JButton("Reset");
        exit = new JButton("Exit");
        setBotText("Welcome to Tic-Tac-Toe!");
        
        add(newGame);
        add(reset);
        add(exit);
        add(bottomText);
    }
    
    public void setBotText(String text)
    {
        bottomText.setText(text);
    }
}
