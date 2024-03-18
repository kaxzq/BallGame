package sturctures;

import systemTrack.SystemMetricsTracker;

import java.awt.*;

public class Ball {
    double x;
    double y;
    double radius;
    double dx = Constants.DEFAULT_DX;
    double dy = Constants.DEFAULT_DY;
    private final Color color;

    public Ball(int x, int y, SystemMetricsTracker.ProcessMetrics metrics) {
        this.x = x;
        this.y = y;

        this.radius = metrics.cpuUsage;
        double speedFactor = calculateSpeedFactor(metrics.cpuUsage);
        this.dx = Constants.DEFAULT_DX * speedFactor;
        this.dy = Constants.DEFAULT_DY * speedFactor;
        this.color = calculateColor(metrics.memorySize);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - radius), (int) (y - radius), (int) radius * 2, (int) radius * 2);
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

    private double calculateSpeedFactor(double cpuUsage) {
        return 1.0 + cpuUsage / 100.0;
    }

    private Color calculateColor(long memorySize) {
        double normalizedMemorySize = Math.max(0, Math.min(1, ((double) memorySize) / Constants.MAX_MEMORY_SIZE));

        int red = (int) (normalizedMemorySize * 255);
        int blue = 255 - red;

        return new Color(red, 0, blue);
    }
}
