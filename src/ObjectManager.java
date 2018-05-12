import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	
	Rocketship rocketship;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	ObjectManager(Rocketship rocket){
	this.rocketship=rocket;
	
	

	}

	public void update() {
		rocketship.update();
		for(Projectile s : projectiles) {
			s.update();
		}
	}
	
	void draw(Graphics g) {
		rocketship.draw(g);
		for(Projectile s : projectiles) {
			s.draw(g);
		}
			
	}
	
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
		
	}
}
