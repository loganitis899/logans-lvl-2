import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer = new Timer(1000 / 60, this);

	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	public void startGame() {
		timer.start();

	}

	public void paintComponent(Graphics g) {

		g.fillRect(10, 10, 100, 100);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("yup");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("yeep");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("yucc");

	}
}
