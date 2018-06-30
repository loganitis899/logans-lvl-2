package atari_breakout;

import java.awt.Graphics;

public class Blocks extends GameObject{
	public Blocks(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}

	void update() {
		super.update();
			
		}

	}


