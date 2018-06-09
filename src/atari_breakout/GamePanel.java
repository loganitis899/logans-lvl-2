package atari_breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	Timer timer = new Timer(1000 / 60, this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	public int currentState = 0;
	Font titleFont;
	Font enterFont;
	Font startFont;
	Font diedFont;
	Font welcomeTo;
	Font tryAgainFont;
	Font breakoutFont;
	int timerRun;
Color label = Color.BLACK;
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 170);
		enterFont = new Font("Arial", Font.BOLD, 24);
		startFont = new Font("Arial", Font.PLAIN, 24);
		breakoutFont = new Font("Impact", Font.BOLD, 30);
		diedFont = new Font("Papyrus", Font.ITALIC, 70);
		welcomeTo = new Font("Arial", Font.ITALIC, 50);
		tryAgainFont = new Font("Typewriter", Font.BOLD, 24);
	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, atariBreakout.frameXSize, atariBreakout.frameYSize);

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Atari", 150, 200);

		g.setFont(welcomeTo);
		g.setColor(Color.WHITE);
		g.drawString("Welcome To...", 10, 50);

		g.setFont(breakoutFont);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("breakout", 360, 230);

		if (timerRun % 100 == 0) {
			
		label=Color.BLACK;
		    
		    
		} else if(timerRun%50==0){
			
			label=Color.WHITE;
			
		}
		g.setFont(enterFont);
		g.setColor(label);
		g.drawString("Press ENTER to start!", 240, 400);
		g.setFont(startFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 200, 500);

	}

	void drawGameState(Graphics g) {

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, atariBreakout.frameXSize, atariBreakout.frameYSize);

		g.setFont(diedFont);
		g.setColor(Color.BLACK);
		g.drawString("You ran out of lives...", 100, 200);

		g.setFont(tryAgainFont);
		g.setColor(Color.WHITE);
		g.drawString("press Enter to try again", 250, 500);
	}

	public void startGame() {
		timer.start();

	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);

		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();

		} else if (currentState == END_STATE) {
			updateEndState();
		}

		timerRun += 1;

		repaint();

	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState += 1;
			if (currentState == 3) {
				currentState = 0;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE && currentState == MENU_STATE) {
			JOptionPane.showMessageDialog(null,
					"use the arrow keys to bounce the ball off the platform into the blocks. "
							+ "destroy all the blocks to win!");
		}

	}

}
