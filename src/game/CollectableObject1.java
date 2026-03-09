package game;

import java.awt.Color;
import java.awt.Graphics;

public class CollectableObject1 extends Polygon implements ObjectInterface {
	private boolean collected = false;
	private int pointVal;
	private Color color;
	
	public CollectableObject1(Point position) {
		super( new Point[] {new Point(10,0), new Point(20,10), new Point(10,20), new Point(0,10)}, position, 0);
		this.collected = false;
		this.pointVal = 10 ;
		this.color = Color.YELLOW;
	}
	
	
	
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
	@Override
	public
	void rotateObject() {
		rotate(3);
	}
	@Override
	public
	int GetPoints() {
		return pointVal;
	}
	@Override
	public
	boolean isCollected() {
		return collected;
	}
	public void Collect() {
		this.collected = true;
	}
}
