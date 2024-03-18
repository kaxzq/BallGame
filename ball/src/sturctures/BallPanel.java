package sturctures;

import systemTrack.SystemMetricsTracker;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BallPanel extends JPanel implements ActionListener {
    private final Map<String, Ball> balls;

    public BallPanel() {
        balls = new HashMap<>();
        Timer timer = new Timer(Constants.TIMER_DELAY, this);
        timer.start();
    }

    public void addBall(SystemMetricsTracker.ProcessMetrics metrics) {
        Random rand = new Random();
        int x = rand.nextInt(Constants.WINDOW_WIDTH - 20) + 10;
        int y = rand.nextInt(Constants.WINDOW_HEIGHT - 20) + 10;
        balls.put(metrics.pid, new Ball(x, y, metrics));
        repaint();
    }

    public void removeAllBalls() {
        balls.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls.values()) {
            ball.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ball ball : balls.values()) {
            ball.move(getWidth(), getHeight());
        }
        repaint();
    }

    public void refreshBalls() {
        removeAllBalls();
        Map<String, SystemMetricsTracker.ProcessMetrics> metricsMap = SystemMetricsTracker.getSystemMetrics();
        metricsMap.forEach((pid, metrics) -> {
            addBall(metrics);
        });

    }
}

