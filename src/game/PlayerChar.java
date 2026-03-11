package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * User controlled character which moves forward and rotates
 */
public class PlayerChar extends Polygon implements KeyListener {
	boolean forward = false;
	boolean right = false;
	boolean left = false;
	double moveStep = 5;
	/**
	 * Constructor for Player char contains shape, position, and rotation
	 * @param shape
	 * @param position
	 * @param rotation
	 */
	public PlayerChar(Point[] shape, Point position, double rotation) {
		super(shape, position, rotation);

	} 
	/**
	 * Handles the painting of the layer object
	 * @param brush to draw playerchar
	 */
	public void paint(Graphics brush) {

		Point[] points = this.getPoints();

		int[] x = new int[points.length];
		int[] y = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			x[i] = (int) points[i].getX();
			y[i] = (int) points[i].getY();
		}

		brush.drawPolygon(x, y, points.length);
	}
	/**
	 * Logic for the mocement of the Player Char
	 */
	public void move() {
		if (forward) {
			position.x += moveStep * Math.cos(Math.toRadians(rotation));
			position.y += moveStep * Math.sin(Math.toRadians(rotation));
		}
		if (left) {
			rotation -= 5;
		}
		if (right) {
			rotation += 5;
		}
		if (position.x > 800) position.x = 0; 
		else if (position.x < 0) position.x = 800;

		if (position.y > 600) position.y = 0; 
		else if (position.y < 0) position.y = 600;
	}
	/**
	 * Makes the player char move or rotate
	 */
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			forward = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
	}
	/**
	 * Resets variables associated with player movement and rotation after
	 * release
	 */
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			forward = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
	}
	/**
	 * Nothing happens here it should only be on press
	 * Here to fufill class requirements due to import
	 */
	public void keyTyped(KeyEvent e) {
	}

}
