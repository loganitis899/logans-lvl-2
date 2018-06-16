import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 500;
	int score =0;
	Rocketship rocketship = new Rocketship(250, 700, 50, 50);

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	ObjectManager(Rocketship rocket) {
		this.rocketship = rocket;

	}
	
	int getScore() {
		return score;
	}
	

	public void update() {
		rocketship.update();
		for (Projectile s : projectiles) {
			s.update();
		}
		for (Alien s : aliens) {
			s.update();
		}
		checkCollision();
		purgeObjects();
		
		
	}

	void draw(Graphics g) {
		rocketship.draw(g);
		for (Projectile s : projectiles) {
			s.draw(g);
		}
		for (Alien s : aliens) {
			s.draw(g);
		}

	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);

	}

	void addAlien(Alien alien) {
		aliens.add(alien);

	}
	
		

	void purgeObjects() {
		
		
		for(int a=0; a< aliens.size();a++){
			if(aliens.get(a).isAlive==false) {
				aliens.remove(a);
				score+=1;
				System.out.println("Alien removed");
			}
			
		}
		for(int p=0; p< projectiles.size();p++){
			if(projectiles.get(p).isAlive==false) {
				projectiles.remove(p);
				System.out.println("Shot removed");
			
		}
		}}
	
	void killAll() {
		for(int a=0; a< aliens.size();a++){
			if(aliens.get(a).isAlive==true) {
				aliens.remove(a);
			
				System.out.println(" all Aliens removed");
			}
			for(int p=0; p< projectiles.size();p++){
				if(projectiles.get(p).isAlive==true) {
					projectiles.remove(p);
					System.out.println("Shot killed");
		}
			}}
		
		
	}

	

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.frameXSize), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		for (Alien a : aliens) {

			if (rocketship.collisionBox.intersects(a.collisionBox)) {

				rocketship.isAlive = false;
				a.isAlive=false;
				System.out.print("dead");
			

			}
			for(Projectile p : projectiles) {
				if(p.collisionBox.intersects(a.collisionBox)) {
					a.isAlive=false;
					System.out.println("shot down");
					
				}
				if(p.y<0){
					p.isAlive=false;
					System.out.println("Too Far!");
				}
			}
		

		}
		
		}
	

}
