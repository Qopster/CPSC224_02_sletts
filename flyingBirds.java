//Sean Letts and Max Marciel
//3/24/19
//Part of HW4, moving bird stuff

import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class flyingBirds
{
   // execute application
   public static void main( String args[] )
   {
      JFrame frame = new JFrame( "Flying Bird HW4" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      birdsHW4 bp = new birdsHW4(); 
      frame.add( bp );
      frame.setSize( 600, 600 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
}

class birdsHW4 extends JPanel implements ActionListener
{
	private int delay = 30;
	protected Timer timer;
	private int birdX = 0;		// x position

	private int dx = 2;		// increment amount (x coord)
	private int dy = 0;		// increment amount (y coord)
	
	private int bird1XValues[] = {-110, -85, -60};
	private int bird1YValues[] = {50, 60, 50};
	
	private int bird2XValues[] = new int[3];
	private int bird2YValues[] = new int[3];
	
	private int bird3XValues[] = new int[3];
	private int bird3YValues[] = new int[3];
	
	private int bird4XValues[] = new int[3];
	private int bird4YValues[] = new int[3];
	
	private int bird5XValues[] = new int[3];
	private int bird5YValues[] = new int[3];

	public birdsHW4(){
		timer = new Timer(delay, this);
		timer.start();		// start the timer
	}

	public void actionPerformed(ActionEvent e)
	// will run when the timer fires
	{
		repaint();
	}

	// draw rectangles and arcs
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g ); // call superclass's paintComponent 
		g.setColor(Color.black);		
		// check for boundaries for bird 1
		if (bird1XValues[0] < getWidth()){	
			dx = Math.abs(dx);
		}
		if (bird1XValues[0] > getWidth()){		
			dx = -Math.abs(dx);
			bird1XValues[0] = -110;
			bird1XValues[1] = -85;
			bird1XValues[2] = -60;
		}
		// adjust bird position
		birdX += dx;
		g.drawPolyline(bird1XValues, bird1YValues, 3);
		for(int x = 0; x<3; x++){
			bird1XValues[x] += dx;
		}
		for(int x = 0; x<3; x++){
			bird2XValues[x] = bird1XValues[x] + 20;
			bird2YValues[x] = bird1YValues[x] + 20;
		}
		for(int x = 0; x<3; x++){
			bird3XValues[x] = bird1XValues[x] + 40;
			bird3YValues[x] = bird1YValues[x] + 40;
		}
		for(int x = 0; x<3; x++){
			bird4XValues[x] = bird1XValues[x] + 20;
			bird4YValues[x] = bird1YValues[x] + 60;
		}
		for(int x = 0; x<3; x++){
			bird5XValues[x] = bird1XValues[x];
			bird5YValues[x] = bird1YValues[x] + 80;
		}
		g.drawPolyline(bird1XValues, bird1YValues, 3);
		g.drawPolyline(bird2XValues, bird2YValues, 3);
		g.drawPolyline(bird3XValues, bird3YValues, 3);
		g.drawPolyline(bird4XValues, bird4YValues, 3);
		g.drawPolyline(bird5XValues, bird5YValues, 3);
	}
}