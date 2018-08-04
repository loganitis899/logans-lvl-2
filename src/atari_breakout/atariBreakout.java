package atari_breakout;

import java.awt.Dimension;

import javax.swing.JFrame;

public class atariBreakout {
	static int widthOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    static int heightOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	JFrame frame = new JFrame();
	static final int frameXSize = widthOfScreen -69;
	static final int frameYSize = heightOfScreen;
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
