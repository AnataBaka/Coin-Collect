package game;

import java.awt.Graphics;

public interface ObjectInterface {
	void draw (Graphics brush);
	void rotateObject();
	int GetPoints();
	boolean isCollected();
	void Collect();
}
