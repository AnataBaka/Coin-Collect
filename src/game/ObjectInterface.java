package game;

import java.awt.Graphics;
/**
 * Interface for all interctable objects
 * Ensures they can be collected, rotated, and assigned points
 */
public interface ObjectInterface {
	void draw (Graphics brush);
	void rotateObject();
	int GetPoints();
	boolean isCollected();
	void Collect();
}
