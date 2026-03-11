package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Consumer;

public class EnemyAI extends Polygon {
    private double moveSpeed = 1.8;
    private Color color = Color.RED;
    private Consumer<PlayerChar> collisionBehavior;

    private class PathFinder {
        public void updatePosition(Point target) {
            double diffX = target.x - position.x;
            double diffY = target.y - position.y;
            double angle = Math.atan2(diffY, diffX);

            position.x += moveSpeed * Math.cos(angle);
            position.y += moveSpeed * Math.sin(angle);
            rotation = Math.toDegrees(angle);
        }
    }

    private PathFinder brain = new PathFinder();

    public EnemyAI(Point[] shape, Point position, Consumer<PlayerChar> onCollision) {
        super(shape, position, 0);
        this.collisionBehavior = onCollision;
    }

    public void update(PlayerChar player) {
        brain.updatePosition(player.position);
        if (this.collides(player)) {
            collisionBehavior.accept(player);
        }
    }

    public void paint(Graphics brush) {
        Point[] points = this.getPoints();
        int[] x = new int[points.length];
        int[] y = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            x[i] = (int) points[i].x;
            y[i] = (int) points[i].y;
        }

        brush.setColor(color);
        brush.fillPolygon(x, y, points.length);
    }
}