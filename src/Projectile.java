import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed = 10;

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		y -= speed;
		if (y < 0) {
			isAlive = false;
		
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
// START AT LEAGUE INVADERS PART 10 STEP 7 NEXT TIME
// PT. 10
// STEP 7