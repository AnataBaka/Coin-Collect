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
/*
 * Main controller of the coin collect game
 * Manages Loops, creation of objects, collision, timer, and interactions between objects
 */
class Coin_Collect extends Game {
	PlayerChar player;
	CollectableObject1 coin;
	EnemyAI enemy;
	int counter = 0;
    
    private long startTime;
    private int gameDuration = 30; 
    private long lastSecondTracked = 0;
	public Coin_Collect() {
		/**
		 * Initalizes window, player, enemy, and coin
		 * Sets up movement for the player 
		 */
		super("Coin Collector!", 800, 600);
        this.startTime = System.currentTimeMillis();
        this.setFocusable(true);
		this.requestFocus();
		Point[] playerPoints = { new Point(0, 0), new Point(20, 0), new Point(20, 20), new Point(0, 20) };
		coin = new CollectableObject1(new Point(200, 200));

		player = new PlayerChar(playerPoints, new Point(400, 300), 0);
		Point[] enemyPoints = { new Point(20, 10), new Point(0, 0), new Point(0, 20) };		
		enemy = new EnemyAI(enemyPoints, new Point(100, 100), (p) -> {
            System.out.println("GAME OVER!");
            this.on = false; 
        });

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
/**
 * Handles rendering of all game elements and updates all the objects
 * Also handles null cases for each element
 * @param brush used for drawing
 */
	public void paint(Graphics brush) {
		
		//clear screen
		brush.setColor(Color.black);
		brush.fillRect(0, 0, width, height);
		//timer logic
		long elapsedMillis = System.currentTimeMillis() - startTime;
        long elapsedSeconds = elapsedMillis / 1000;
        int timeLeft = gameDuration - (int)elapsedSeconds;
        if (elapsedSeconds > lastSecondTracked) {
            lastSecondTracked = elapsedSeconds;
            if (enemy != null && on) {
                enemy.increaseSpeed(0.2); 
            }
        }
        //game ends
        if (timeLeft <= 0) {
            timeLeft = 0;
            this.on = false;
        }

        //clear screen
        brush.setColor(Color.black);
        brush.fillRect(0, 0, width, height);

        // UI Rendering
        brush.setColor(Color.white);
        brush.drawString("Counter is " + counter, 10, 25);
        brush.drawString("Time Left: " + timeLeft + "s", 10, 45);

        if (!on && timeLeft == 0) {
            brush.setFont(new Font("Arial", Font.BOLD, 50));
            brush.drawString("OUT OF TIME!", 200, 300);
            return; 
        }
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
		//player logic
		if(player != null){
		    player.move();
		    player.paint(brush);
		}
		//enemy logic
		if (enemy != null) {
            enemy.update(player); 
            enemy.paint(brush);

        }
		//coin logic
		if (coin != null) {
		    if (!coin.isCollected() && player.collides(coin)) {
		        counter++;
		        coin.position.setX(Math.random() * (width - 40) + 20);
		        coin.position.setY(Math.random() * (height - 40) + 20);
		    }
		    coin.draw(brush);
		}

		coin.draw(brush);

	}
	/**
	 * Starter for the game
	 * @param args
	 */
	public static void main(String[] args) {
		Coin_Collect a = new Coin_Collect();
		a.repaint();
	}
}