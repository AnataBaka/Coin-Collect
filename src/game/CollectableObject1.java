package game;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Makes a collectable coin which the player must collect
 * Implements Object Interface and extends Polygon
 */
public class CollectableObject1 extends Polygon implements ObjectInterface {
	private boolean collected = false;
	private int pointVal;
	private Color color;
	/**
	 * constructs the collectible at a certain position
	 * @param position
	 */
	public CollectableObject1(Point position) {
		super( new Point[] {new Point(10,0), new Point(20,10), 
				new Point(10,20), new Point(0,10)}, position, 0);
		this.collected = false;
		this.pointVal = 10 ;
		this.color = Color.YELLOW;
	}
	
	
	/**
	 * Renders coins as a yellow rectangle
	 * @param brush which is used to draw it
	 */
	@Override
	public void draw (Graphics brush) {
		if(collected) {
			return;
		}
		Point[] points = getPoints();
		int[] xPoints = new int[points.length];
		int[] yPoints = new int[points.length];
		for(int i = 0; i < points.length; i++) {
			xPoints[i] = (int) points[i].x;
			yPoints[i] = (int) points[i].y;
		}
		brush.setColor(color);
		brush.fillPolygon(xPoints, yPoints, points.length);

	}
	/**
	 * Spins the coin around
	 */
    private class SpinBehavior {
        public void spin() {
            rotate(3);
        }
    }

    private SpinBehavior spinner = new SpinBehavior();
    @Override
    /**
     * Handles rotation of the coin
     */
    public void rotateObject() {
        spinner.spin();
    }
	@Override
	/**
	 * getter for points
	 */
	public
	int GetPoints() {
		return pointVal;
	}
	@Override
	/**
	 * Returns a boolean representing whether the coin has been collected yet
	 */
	public boolean isCollected() {
		return collected;
	}
	/**
	 * void which sets collected to true
	 */
	public void Collect() {
		this.collected = true;
	}
}
