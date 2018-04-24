import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer = new Timer(1000 / 60, this);
	final int MENU_STATE=0;
	final int GAME_STATE=1;
	final int END_STATE=2;
	int currentState=0;
	Font titleFont;
	Font enterFont;
	Font startFont;
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont = new Font("Arial", Font.PLAIN, 24);
		startFont = new Font("Arial", Font.PLAIN, 24);
	
	}
 void updateMenuState(){
	 
 }
 
 void updateGameState() {
	 
 }
 
 void updateEndState() {
	 
 }
 
 void drawMenuState(Graphics g) {
	 g.setColor(Color.BLUE);
	 g.fillRect(0, 0, LeagueInvaders.frameXSize, LeagueInvaders.frameYSize);
	 
	 g.setFont(titleFont);
	 g.setColor(Color.YELLOW);
	 g.drawString("League Invaders", 75, 100);
	 
	 g.setFont(enterFont);
	 g.setColor(Color.YELLOW);
	 g.drawString("Press ENTER to start!", 125, 300);
	 
	 g.setFont(startFont);
	 g.setColor(Color.YELLOW);
	 g.drawString("Press SPACE for instructions", 100, 500);
	 
 }
 
 void drawGameState(Graphics g) {
	 g.setColor(Color.BLACK);
	 g.fillRect(0,0,LeagueInvaders.frameXSize, LeagueInvaders.frameYSize);
	
 }
 
 void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.frameXSize, LeagueInvaders.frameYSize);
 }
 
	public void actionPerformed(ActionEvent e) {
		
		if(currentState==MENU_STATE) {
			updateMenuState();
		} else if(currentState==GAME_STATE) {
			updateGameState();
		} else if(currentState==END_STATE) {
			updateEndState();
		}
		
		repaint();
		

	}

	public void startGame() {
		timer.start();

	}

	public void paintComponent(Graphics g) {
	
		if(currentState==MENU_STATE) {
			drawMenuState(g);
		} else if(currentState==GAME_STATE) {
			drawGameState(g);
		} else if(currentState==END_STATE) {
			drawEndState(g);
		}

		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			currentState+=1;
			if(currentState>2) {
				currentState=MENU_STATE;
			}
		}
	

	}

	@Override
	public void keyReleased(KeyEvent e) {
		

	}
}
