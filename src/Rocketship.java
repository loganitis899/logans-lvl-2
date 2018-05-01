import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=1;
		
	}

	void draw(Graphics g) {
g.setColor(Color.BLUE);
g.fillRect(x, y, width, height);
		
	}

	void updateLeft() {
		
		x-=speed;
		
		if(x<=0) {
			x=0;
		} else if(x>=500) {
			x=500;
		}
		
	}
	
	void updateRight() {
		
        x+=speed;
		
		if(x<=0) {
			x=0;
		} else if(x>=500) {
			x=500;
		}
		
	
		
		
	}
	
	
	
}
