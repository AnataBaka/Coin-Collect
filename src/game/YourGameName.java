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
	CollectableObject1 coin;
	int counter = 0;

	public YourGameName() {
		super("YourGameName!", 800, 600);
		this.setFocusable(true);
		this.requestFocus();
		Point[] playerPoints = { new Point(0, 0), new Point(20, 0), new Point(20, 20), new Point(0, 20) };
		coin = new CollectableObject1(new Point(200, 200));

		player = new PlayerChar(playerPoints, new Point(400, 300), 0);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					player.forward = true;
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					player.left = true;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					player.right = true;
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					player.forward = false;
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					player.left = false;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					player.right = false;
			}
		});
		this.requestFocusInWindow();
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0, 0, width, height);

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		brush.setColor(Color.white);
		brush.setColor(Color.red);

		if (!coin.isCollected() && player.collides(coin)) {
			coin.Collect();
			counter++;
			System.out.println("Player has collected a coin!!");
		}
		brush.drawString("Counter is " + counter, 10, 25);

		if(player != null){
		    player.move();
		    player.paint(brush);
		}
		coin.draw(brush);

	}

	public static void main(String[] args) {
		YourGameName a = new YourGameName();
		a.repaint();
	}
}