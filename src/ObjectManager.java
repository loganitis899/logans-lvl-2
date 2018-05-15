import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 500;

	Rocketship rocketship;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	ObjectManager(Rocketship rocket) {
		this.rocketship = rocket;

	}

	public void update() {
		rocketship.update();
		for (Projectile s : projectiles) {
			s.update();
		}
		for (Alien s : aliens) {
			s.update();
		}
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

			}

		}

	}

}
