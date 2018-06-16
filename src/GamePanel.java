import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	 public static BufferedImage alienImg;

     public static BufferedImage rocketImg;

     public static BufferedImage bulletImg;

     public static BufferedImage spaceImg;



	Timer timer = new Timer(1000 / 60, this);

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	public int currentState = 0;
	Font titleFont;
	Font enterFont;
	Font startFont;
	Font diedFont;
	Font scoreFont;
	Font tryAgainFont;
	public String whichArrow;
	Rocketship rocketship = new Rocketship(250, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(rocketship);

	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont = new Font("Arial", Font.PLAIN, 24);
		startFont = new Font("Arial", Font.PLAIN, 24);

		diedFont = new Font("Arial", Font.PLAIN, 70);
		scoreFont = new Font("Arial", Font.PLAIN, 24);
		tryAgainFont = new Font("Arial", Font.PLAIN, 24);
		
		 try {

             alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

             rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

             bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

             spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

     } catch (IOException e) {

             // TODO Auto-generated catch block

             e.printStackTrace();

     }

	}

	void updateMenuState() {
		objectManager.score=0;
		rocketship.isAlive=true;
		objectManager.killAll();
	}

	void updateGameState() {
	
		objectManager.update();

		objectManager.manageEnemies();
		if(rocketship.isAlive==false && currentState==1) {
			currentState+=1;
		}
		
		

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
		
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.frameXSize,  LeagueInvaders.frameYSize, null);
		objectManager.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.frameXSize, LeagueInvaders.frameYSize);

		g.setFont(diedFont);
		g.setColor(Color.BLACK);
		g.drawString("You Died", 100, 200);

		g.setFont(scoreFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed "+String.valueOf(objectManager.getScore())+" aliens!", 135, 300);

		g.setFont(tryAgainFont);
		g.setColor(Color.BLACK);
		g.drawString("press Enter to try again", 120, 500);
	}

	public void actionPerformed(ActionEvent e) {

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
			rocketship.update();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

		repaint();

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

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState += 1;
			if (currentState == 3) {
				currentState = 0;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE && currentState == MENU_STATE) {
			JOptionPane.showMessageDialog(null, "press space to shoot enemies. try not to get hit.");
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.updateLeft();

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.updateRight();
		}
		if(currentState==END_STATE) {
			rocketship.equals(rocketship = new Rocketship(250, 700, 50, 50));
			 objectManager = new ObjectManager(rocketship);
	
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			objectManager.addProjectile(new Projectile(rocketship.x + 20, rocketship.y - 20, 10, 10));
		}

	}
	
}
