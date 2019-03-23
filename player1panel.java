//Panel for the first player in the tic-tac-toe

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class player1panel extends JPanel
{
    private JTextField nameField;
    private JTextField winsField;
    private JTextField lossField;
    private JLabel nameLabel;
    private JLabel winsLabel;
    private JLabel lossLabel;
    private int wins;
    private int losses;
    
    public player1panel()
    {
        setLayout(new GridLayout(3,2)); //3 high, 2 wide
        
        nameLabel = new JLabel("Name:");
        winsLabel = new JLabel("Wins:");
        lossLabel = new JLabel("Losses:");
        
        nameField = new JTextField(10);
        nameField.setEditable(true);
        winsField = new JTextField(3);
        winsField.setEditable(false);
        winsField.setText("0");
        lossField = new JTextField(3);
        lossField.setText("0");
        lossField.setEditable(false);
        
        setBorder(BorderFactory.createTitledBorder("Player 1 (X):"));
        add(nameLabel);
        add(nameField);
        add(winsLabel);
        add(winsField);
        add(lossLabel);
        add(lossField);
    }
    
    public void iterateWins()
    {
        wins++;
        winsField.setText(Integer.toString(wins));
    }
    public int getWins()
    {
        return wins;
    }
    public void iterateLosses()
    {
        losses++;
        lossField.setText(Integer.toString(losses));
    }
    public int getLosses()
    {
        return losses;
    }
    public void resetWL_1()
    {
        wins = 0;
        losses = 0;
        winsField.setText("0");
        lossField.setText("0");
    }
    public void disableText()
    {
        nameField.setEditable(false);
    }
    public void enableText()
    {
        nameField.setEditable(true);
    }
    public void resetName()
    {
        nameField.setText("");
    }
    public String getName()
    {
        return nameField.getText();
    }
}
