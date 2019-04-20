import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	int score = 0;
	Rocketship rocket;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void update() {
		rocket.update();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).update();

		}
		for (int i = 0; i < alienlist.size(); i++) {
			alienlist.get(i).update();
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).draw(g);

		}
		for (int i = 0; i < alienlist.size(); i++) {
			alienlist.get(i).draw(g);
		}
	}

	ArrayList<Projectile> list = new ArrayList<Projectile>();

	void addProjectile(Projectile projectile) {
		list.add(projectile);
	}

	ArrayList<Alien> alienlist = new ArrayList<Alien>();

	void addAlien(Alien alien) {
		alienlist.add(alien);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < alienlist.size(); i++) {
			if (alienlist.get(i).isAlive == false) {

				alienlist.remove(i);
			}
		}

	}

	public void checkCollision() {
		for (Alien a : alienlist) {

			if (rocket.collisionBox.intersects(a.collisionBox)) {

				rocket.isAlive = false;

			}

		}
		for (Projectile p : list) {

			for (Alien a : alienlist) {
				if (a.collisionBox.intersects(p.collisionBox)) {

					a.isAlive = false;
					score+=1;
				}

			}
		}
	}

	public int getScore() {
		return score;

	}
}
