package game;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class YourGameName extends Game {
	PlayerChar player;
	static int counter = 0;
	

	public YourGameName() {
		super("YourGameName!", 800, 600);
		this.setFocusable(true);
		this.requestFocus();
		Point[] playerPoints = { new Point(0, 0), new Point(20, 0), new Point(20, 20), new Point(0, 20) };

		player = new PlayerChar(playerPoints, new Point(400, 300), 0);

		this.addKeyListener(player);
		this.requestFocusInWindow();
	}
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	counter++;
    	brush.setColor(Color.white);
    	brush.drawString("Counter is " + counter,10,10);
    	brush.setColor(Color.red);

    	player.move();
    	player.paint(brush);    	
  }
  
	public static void main (String[] args) {
   		YourGameName a = new YourGameName();
		a.repaint();
  }
}