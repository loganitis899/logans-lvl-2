package atari_breakout;

import java.awt.Graphics;

public class Bouncer extends GameObject {
int speed;
	public Bouncer(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=20;
	}
	
	void draw(Graphics g) {
		g.fillRoundRect(x, y, width, height, 10, 10);
	}

	
	void updateLeft() {
		super.update();
		x-=speed;
		if (x <= 0) {
			x = 0;
		
		}
	}
	void updateRight() {
		super.update();
		x+=speed;
		if (x >= atariBreakout.frameXSize-200) {
			x=atariBreakout.frameXSize-200;
		}
	}
	
	void update() {
		super.update();
		
	}
	void reset() {
		x=atariBreakout.frameXSize/2;
	}
}
