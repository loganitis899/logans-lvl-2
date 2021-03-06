package atari_breakout;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	public static BufferedImage deadImg;
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
	int ballX = atariBreakout.frameXSize / 2;
	int ballY = atariBreakout.frameYSize - 400;
	int speedX = 40;
	int speedY = 40;
	int blockX;
	int blockY;
	boolean moveRight = false;
	boolean moveLeft = false;
	Blocks block = new Blocks(blockX, blockY, 100, 100);
	boolean playMusic = false;
	int velocity = 0;
	ObjectManger spawner = new ObjectManger(block);
	AudioClip smash = JApplet.newAudioClip(getClass().getResource("theme.wav"));

	Random randyOne = new Random();

	Random randyTwo = new Random();

	Bouncer bouncer = new Bouncer(atariBreakout.frameXSize / 2, atariBreakout.frameYSize - 260, 200, 10);

	public GamePanel() {

		titleFont = new Font("Arial", Font.PLAIN, 350);
		enterFont = new Font("Arial", Font.BOLD, 100);
		startFont = new Font("Arial", Font.PLAIN, 50);
		breakoutFont = new Font("Impact", Font.BOLD, 150);
		// diedFont = new Font("Papyrus", Font.ITALIC, 70);
		welcomeTo = new Font("Arial", Font.ITALIC, 125);
		// tryAgainFont = new Font("Typewriter", Font.BOLD, 24);

		spawner.setUp();
		try {

			deadImg = ImageIO.read(this.getClass().getResourceAsStream("dead.png"));

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	void updateMenuState() {

		int RandyOne = randyOne.nextInt(2);
		int RandyTwo = randyTwo.nextInt(2);
		ballX = atariBreakout.frameXSize / 2 + 50;
		ballY = atariBreakout.frameYSize - 400;

	}

	void updateGameState() {
		if (ballY >= atariBreakout.frameYSize - 160) {
			currentState = currentState + 1;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

		if (playMusic == false) {
			smash.play();
			playMusic = true;
		}
		velocity = 0;
		speedY = 14;

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, atariBreakout.frameXSize, atariBreakout.frameYSize);

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Atari", 600, 400);

		g.setFont(welcomeTo);
		g.setColor(Color.WHITE);
		g.drawString("Welcome To...", 10, 100);

		g.setFont(breakoutFont);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("breakout", 750, 550);

		if (timerRun % 100 == 0) {

			label = Color.BLACK;

		} else if (timerRun % 50 == 0) {

			label = Color.WHITE;

		}
		g.setFont(enterFont);
		g.setColor(label);
		g.drawString("Press ENTER to start!", atariBreakout.frameXSize / 2 - 500, 800);
		g.setFont(startFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 700, 1000);

	}

	void drawGameState(Graphics g) {

		smash.stop();
		playMusic = false;

		if (spawner.checkRedCollision(ballX+speedX, ballY+speedY) == true) {
			speedY = -speedY;
		}
		if (spawner.checkGreenCollision(ballX+speedX, ballY+speedY) == true) {
			speedY = -speedY;
		}
		if (spawner.checkBlackCollision(ballX+speedX, ballY+speedY) == true) {
			speedY = -speedY;

		}
		if (moveRight) {
			bouncer.updateRight();
		}
		if (moveLeft) {
			bouncer.updateLeft();
		}

		// for (int i = 0; i < 2; i++) {

		// Blocks block = new Blocks(blockX, blockY, 100, 100);
		// blockX = blockX + 100;
		// ObjectManger spawner = new ObjectManger(block);
		// spawner.addBlackBlock(block);
		// spawner.update();
		spawner.drawBlackBlocks(g);
		spawner.drawGreenBlocks(g);
		spawner.drawRedBlocks(g);

		// if (blockX > 1000) {
		// blockX = 0;
		// blockY = blockY + 100;
		//
		// }
		// }
		//
		g.setColor(Color.BLACK);
		g.fillOval(ballX, ballY, 50, 50);

		if (ballY <= 0 || ballY >= atariBreakout.frameYSize - 160) {
			speedY=-speedY;
		}
		if (ballX <= 0 || ballX >= atariBreakout.frameXSize - 50) {

			speedX = -speedX;
		}
		bouncer.x = ballX-100;
		bouncer.update();
		bouncer.draw(g);

		ballX = ballX + speedX;
		ballY = ballY + speedY;

		if (bouncer.collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {
			
		if (spawner.velocity(ballX, ballY, bouncer) <50) {
				
				speedY = speedY + 2;
				speedY=Math.min(speedY, 100);
				
				
				System.out.println(speedY);
			} else if (spawner.velocity(ballX, ballY, bouncer) > 50) {
				
				System.out.println(speedY);
				
				speedY = speedY - 2;
				speedY=Math.max(speedY, 3);
			}
			speedY = -speedY;
		}
		

	}

	// if (spawner.block.collisionBox.intersects(new Rectangle(ballX, ballY, 50,
	// 50))) {
	// speedY = -speedY;
	// }

	 void drawEndState(Graphics g) {
		spawner.reset(ballX, ballY);
		bouncer.reset();
		// g.setColor(Color.LIGHT_GRAY);
		// g.fillRect(0, 0, atariBreakout.frameXSize, atariBreakout.frameYSize);

		/// g.setFont(diedFont);
		// g.setColor(Color.BLACK);
		// g.drawString("You ran out of lives...", 100, 200);

		// g.setFont(tryAgainFont);
		//// (Color.WHITE);
		// g.drawString("press Enter to try again", 250, 500);
		g.drawImage(GamePanel.deadImg, 0, 0, atariBreakout.frameXSize, atariBreakout.frameYSize, null);
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
			// System.out.println("E");

		} else if (currentState == END_STATE) {
			updateEndState();
		}

		timerRun += 1;

		repaint();

	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = true;
			bouncer.collisionBox.setBounds(bouncer.x+20, bouncer.y, 200, 10);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = true;
			bouncer.collisionBox.setBounds(bouncer.x-20, bouncer.y, 200, 10);
			
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = false;
		}
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
