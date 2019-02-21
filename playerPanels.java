import javax.swing.*;
import java.awt.*;

public class playerPanels extends JPanel
{
    private player1panel p1;
    private player2panel p2;
    
    public playerPanels()
    {
        setLayout(new GridLayout(1,2));
        p1 = new player1panel();
        p2 = new player2panel();
        add(p1);
        add(p2);
    }
    
    public void iterateWins_p1()
    {
        p1.iterateWins();
    }
    public void iterateLosses_p1()
    {
        p1.iterateWins();
    }
    public void iterateWins_p2()
    {
        p2.iterateWins();
    }
    public void iterateLosses_p2()
    {
        p2.iterateLosses();
    }
    public int getWins_p1()
    {
        return p1.getWins();
    }
    public int getLosses_p1()
    {
        return p1.getLosses();
    }
    public int getWins_p2()
    {
        return p2.getWins();
    }
    public int getLosses_p2()
    {
        return p2.getLosses();
    }
}
