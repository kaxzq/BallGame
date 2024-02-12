package sturctures;

import java.awt.*;

public class Ball {
    int x;
    int y;
    int radius = Constants.BALL_RADIUS;
    int dx = Constants.DEFAULT_DX;
    int dy = Constants.DEFAULT_DY;
    private final Color color;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        color = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public void move(int width, int height) {
        x += dx;
        y += dy;
        if (x - radius < 0 || x + radius > width) {
            dx *= -1;
        }
        if (y - radius < 0 || y + radius > height) {
            dy *= -1;
        }
    }

    public boolean intersects(Ball other) {
        int distanceSquared = (this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y);
        return distanceSquared < (this.radius + other.radius) * (this.radius + other.radius);
    }

    public void merge(Ball other) {
        int totalVolume = (int) (4.0/3 * Math.PI * this.radius * this.radius * this.radius) + (int) (4.0/3 * Math.PI * other.radius * other.radius * other.radius);
        this.radius = (int) Math.cbrt((3 * totalVolume) / (4 * Math.PI));
        this.dx += other.dx / 2;
        this.dy += other.dy / 2;
    }
}
