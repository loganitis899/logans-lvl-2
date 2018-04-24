import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	static final int frameXSize = 500;
	static final int frameYSize = 800;
	GamePanel GamePanel;

	public static void main(String[] args) {
		LeagueInvaders runMethod = new LeagueInvaders();
		runMethod.setup();

	}

	public void setup() {
		frame.add(GamePanel);
		frame.addKeyListener(GamePanel);
		frame.getContentPane().setPreferredSize(new Dimension(frameXSize, frameYSize));
		frame.pack();
		frame.setVisible(true);
		frame.setSize(frameXSize, frameYSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel.startGame();
	}

	public LeagueInvaders() {
		GamePanel = new GamePanel();

	}
}