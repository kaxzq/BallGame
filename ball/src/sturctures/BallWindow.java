package sturctures;

import systemTrack.SystemMetricsTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class BallWindow extends JFrame {
    private final BallPanel ballPanel;

    public BallWindow() {
        ballPanel = new BallPanel();
        add(ballPanel, BorderLayout.CENTER);
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ball Game");
        setLocationRelativeTo(null);

        Map<String, SystemMetricsTracker.ProcessMetrics> processMetricsMap = SystemMetricsTracker.getSystemMetrics();

        processMetricsMap.forEach((pid, metrics) -> {
            ballPanel.addBall(metrics);
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_E) {
                    ballPanel.removeAllBalls();
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    ballPanel.refreshBalls();
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    System.exit(0);
                }
            }
        });


        setVisible(true);

    }
}