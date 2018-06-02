import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 25;

	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
	

	void updateLeft() {
		super.update();

		x -= speed;

		if (x <= 0) {
			x = 0;
		} else if (x >= 450) {
			x = 450;
		}

	}

	void updateRight() {
		super.update();

		x += speed;

		if (x <= 0) {
			x = 0;
		} else if (x >= 450) {
			x = 450;
		}

	}

}
