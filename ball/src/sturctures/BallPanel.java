package sturctures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BallPanel extends JPanel implements ActionListener {
    private final List<Ball> balls;

    public BallPanel() {
        balls = new ArrayList<>();
        Timer timer = new Timer(Constants.TIMER_DELAY, this);
        timer.start();
    }

    public void addBall(int x, int y) {
        balls.add(new Ball(x, y));
        repaint();
    }

    public void removeAllBalls() {
        balls.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ball ball : balls) {
            ball.move(getWidth(), getHeight());
        }
        mergeBalls();
        repaint();
    }

    private void mergeBalls() {
        for (int i = 0; i < balls.size(); i++) {
            for (int j = i + 1; j < balls.size(); j++) {
                Ball ball1 = balls.get(i);
                Ball ball2 = balls.get(j);
                if (ball1.intersects(ball2)) {
                    ball1.merge(ball2);
                    balls.remove(j);
                    j--;
                }
            }
        }
    }
}

