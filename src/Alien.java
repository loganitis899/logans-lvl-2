import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	void update() {
		y+=5;
		
	}
	
	void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}

}
