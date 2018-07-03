package atari_breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Blocks extends GameObject {
	public Blocks(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}

	void update() {
		super.update();

	}

}
