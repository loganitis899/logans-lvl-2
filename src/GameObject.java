import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	boolean isAlive = true;
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;

	public GameObject(int x, int y, int width, int height) {
		collisionBox = new Rectangle(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void draw(Graphics g) {

	}

	void update() {

		collisionBox.setBounds(x, y, width, height);
	}
	
}
