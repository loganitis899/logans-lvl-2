package atari_breakout;

import java.awt.Dimension;

import javax.swing.JFrame;

public class atariBreakout {
	JFrame frame = new JFrame();
	static final int frameXSize = 800;
	static final int frameYSize = 600;
	GamePanel GamePanel;

	public static void main(String[] args) {
		atariBreakout runMethod = new atariBreakout();
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

	public atariBreakout() {
		GamePanel = new GamePanel();
	}
}
