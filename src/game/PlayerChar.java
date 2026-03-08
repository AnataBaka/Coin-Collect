package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class PlayerChar extends Polygon implements KeyListener {
	boolean forward = false;
	boolean right = false;
	boolean left = false;
	double moveStep = 5;
	
	public PlayerChar(Point[] shape, Point position, double rotation)
	{
		super(shape,position,rotation);
		
	}
	 public void paint(Graphics brush) {

	        Point[] points = this.getPoints();

	        int[] x = new int[points.length];
	        int[] y = new int[points.length];

	        for(int i = 0; i < points.length; i++) {
	            x[i] = (int) points[i].getX();
	            y[i] = (int) points[i].getY();
	        }

	        brush.drawPolygon(x, y, points.length);
	    }
	    public void move() {
	    	if(forward) {
	    		position.x+=moveStep*Math.cos(Math.toRadians(rotation));
	    		position.y+=moveStep*Math.sin(Math.toRadians(rotation));
	    }
	    	if(left) {
	    		rotation-=5;
	    	}
	    	if(right) {
	    		rotation+=5;
	    	}
	    	
	    }

	    public void keyPressed(KeyEvent e) {

	        if(e.getKeyCode() == KeyEvent.VK_UP) {
	            forward = true;
	        }

	        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
	            left = true;
	        }

	        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
	            right = true;
	        }
	    }

	    public void keyReleased(KeyEvent e) {

	        if(e.getKeyCode() == KeyEvent.VK_UP) {
	            forward = false;
	        }

	        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
	            left = false;
	        }

	        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
	            right = false;
	        }
	    }

	    public void keyTyped(KeyEvent e) { }

}
