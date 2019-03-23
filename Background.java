import java.awt.*;
import javax.swing.*;
import javax.swing.*;
public class Background extends JFrame{
	Background()
	{
		setTitle("JavaTutorial.net");	
		
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);		
	}
	
	public void paint(Graphics g){
		Color brown = new Color(90, 39, 41);
		g.setColor(brown);
		
		int xValues[] = {-10, -60, -120, -10};
	    int yValues[] = {150, 50, 150, 150};
		g.fillPolygon(xValues, yValues, 4);
		while(xValues[2] < 600){
			for(int x = 0; x< 4; x++){
				xValues[x] = xValues[x] +30;
				g.fillPolygon(xValues, yValues, 4);
			}
		}
		while(xValues[2] > 600){
			for(int x = 0; x< 4; x++){
				xValues[x] = xValues[x] -30;
				g.fillPolygon(xValues, yValues, 4);
			}
		}
	}
	
	public static void main(String[] args){
		new Background();
	}	
}