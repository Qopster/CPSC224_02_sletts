import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame
{
    private playerPanels playerPanel;
    
    public TicTacToeGUI()
    {
        setTitle("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        playerPanel = new playerPanels();
        
        add(playerPanel, BorderLayout.NORTH);
        
        pack();
        setVisible(true);
    }
}
