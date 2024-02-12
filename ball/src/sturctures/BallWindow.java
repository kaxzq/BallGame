package sturctures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BallWindow extends JFrame {
    private final BallPanel ballPanel;

    public BallWindow() {
        ballPanel = new BallPanel();
        add(ballPanel, BorderLayout.CENTER);
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ball Game");
        setLocationRelativeTo(null);

        ballPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ballPanel.addBall(e.getX(), e.getY());
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    ballPanel.removeAllBalls();
                }
            }
        });

        setVisible(true);
    }
}