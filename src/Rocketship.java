import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {
		 g.drawImage(GamePanel.rocketImg, x, y, width, height, null);


	}

	void up() {
		y -= speed;
	}

	void down() {
		y += speed;
	}

	void left() {
		x -= speed;
	}

	void right() {
		x += speed;
	}
}
