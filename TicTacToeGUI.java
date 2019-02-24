//The final GUI which pieces together bottom buttons, player panels,
//and the tic tac toe board, and handles all events.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame
{
    private playerPanels playerPanel;
    private BottomButtons bottomButtons;
    private TicTacToeButtons ticTacToe;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private int pressed = 0;
    
    public TicTacToeGUI()
    {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new GridLayout(4,1));
        setLayout(new BorderLayout());
        
        playerPanel = new playerPanels();
        
        bottomButtons = new BottomButtons();
        bottomButtons.newGame.addActionListener(new ButtonListener());
        bottomButtons.reset.addActionListener(new ButtonListener());
        bottomButtons.newGame.addActionListener(new ButtonListener());
        bottomButtons.exit.addActionListener(new ButtonListener());
        
        ticTacToe = new TicTacToeButtons();
        for (int i = 0; i < 9; i++)
        {
            ticTacToe.tButton[i].addActionListener(new ButtonListener());
        }
        
        add(playerPanel, BorderLayout.NORTH);
        add(ticTacToe, BorderLayout.CENTER);
        add(bottomButtons, BorderLayout.SOUTH);
        
        
        //pack();
        setVisible(true);
    }
    
    private void resetBoard()
    {
        ticTacToe.setTurn(1);
        ticTacToe.clearPanel();
        pressed = 0;
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean exists = ((JButton)e.getSource()).getText().equals("");
            //Determine's the bottom text box based on whose turn it is
            if ((ticTacToe.getTurn() % 2) == 1 && exists)
            {
                String theName = playerPanel.getName_p2();
                bottomButtons.setBotText(theName + "'s turn");
            }
            else if ((ticTacToe.getTurn() % 2) == 0 && exists)
            {
                String theName = playerPanel.getName_p1();
                bottomButtons.setBotText(theName + "'s turn");
            }
            
            //If the user presses new game
            if (e.getSource() == bottomButtons.newGame)
            {
                ticTacToe.enable();
                playerPanel.disableNameText();
                String theName = playerPanel.getName_p1();
                bottomButtons.setBotText(theName + "'s turn");
            }
            //If he pressed reset
            if (e.getSource() == bottomButtons.reset)
            {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "This will end the game "
                        + "and set the W/L stats to 0. Are you sure?", "Are you sure?", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION)
                {
                    ticTacToe.clearPanel();
                    ticTacToe.disable();
                    playerPanel.enableNameText();
                    playerPanel.clearNames();
                    bottomButtons.setBotText("");
                    playerPanel.resetWL();
                    bottomButtons.setBotText("Welcome to Tic Tac Toe!");
                }
            }
            //If user pressed exit
            if (e.getSource() == bottomButtons.exit)
            {
                
                dispose();
            }
            
            //If the user presses a button in the tic tac toe board.
            for (int i = 0; i < 9; i++)
            {
                boolean hasX = ticTacToe.getButtonContent(i) == "X";
                boolean hasO = ticTacToe.getButtonContent(i) == "O";
                boolean hasXO = hasX || hasO;
                if (e.getSource() == ticTacToe.tButton[i] && !hasXO)
                {
                    if ((ticTacToe.getTurn() % 2) == 1)
                    {
                        ticTacToe.setButtonContent(i, "X");
                        ticTacToe.setX(true, i);
                        ticTacToe.iterateTurn();
                        pressed++;
                    }
                    else if ((ticTacToe.getTurn() % 2) == 0)
                    {
                        ticTacToe.setButtonContent(i, "O");
                        ticTacToe.setO(true, i);
                        ticTacToe.iterateTurn();
                        pressed++;
                    }
                    if (pressed == 9)
                    {
                        ticTacToe.clearPanel();
                        pressed = 0;
                    }
                }
            }
            //Xs -----------------------------------------------------------
            if (ticTacToe.getX(0) && ticTacToe.getX(1) && ticTacToe.getX(2))
            {
                playerPanel.iterateWins_p1();
                resetBoard();
            }
            if (ticTacToe.getX(3) && ticTacToe.getX(4) && ticTacToe.getX(5))
            {
                playerPanel.iterateWins_p1();
                resetBoard();
            }
            if (ticTacToe.getX(6) && ticTacToe.getX(7) && ticTacToe.getX(8))
            {
                playerPanel.iterateWins_p1();
                resetBoard();
            }
            if (ticTacToe.getX(0) && ticTacToe.getX(3) && ticTacToe.getX(6))
            {
                playerPanel.iterateWins_p1();
                resetBoard();
            }
            if (ticTacToe.getX(1) && ticTacToe.getX(4) && ticTacToe.getX(7))
            {
                playerPanel.iterateWins_p1();
                resetBoard();
            }
            if (ticTacToe.getX(2) && ticTacToe.getX(5) && ticTacToe.getX(8))
            {
                playerPanel.iterateWins_p1();
                resetBoard();
            }
            if (ticTacToe.getX(0) && ticTacToe.getX(4) && ticTacToe.getX(8))
            {
                playerPanel.iterateWins_p1();
                resetBoard();
            }
            if (ticTacToe.getX(2) && ticTacToe.getX(4) && ticTacToe.getX(6))
            {
                playerPanel.iterateWins_p1();
                resetBoard();
            }
            
            //Os -----------------------------------------------------------
            if (ticTacToe.getO(0) && ticTacToe.getO(1) && ticTacToe.getO(2))
            {
                playerPanel.iterateWins_p2();
                resetBoard();
            }
            if (ticTacToe.getO(3) && ticTacToe.getO(4) && ticTacToe.getO(5))
            {
                playerPanel.iterateWins_p2();
                resetBoard();
            }
            if (ticTacToe.getO(6) && ticTacToe.getO(7) && ticTacToe.getO(8))
            {
                playerPanel.iterateWins_p2();
                resetBoard();
            }
            if (ticTacToe.getO(0) && ticTacToe.getO(3) && ticTacToe.getO(6))
            {
                playerPanel.iterateWins_p2();
                resetBoard();
            }
            if (ticTacToe.getO(1) && ticTacToe.getO(4) && ticTacToe.getO(7))
            {
                playerPanel.iterateWins_p2();
                resetBoard();
            }
            if (ticTacToe.getO(2) && ticTacToe.getO(5) && ticTacToe.getO(8))
            {
                playerPanel.iterateWins_p2();
                resetBoard();
            }
            if (ticTacToe.getO(0) && ticTacToe.getO(4) && ticTacToe.getO(8))
            {
                playerPanel.iterateWins_p2();
                resetBoard();
            }
            if (ticTacToe.getO(2) && ticTacToe.getO(4) && ticTacToe.getO(6))
            {
                playerPanel.iterateWins_p2();
                resetBoard();
            }
        }
    }
}
