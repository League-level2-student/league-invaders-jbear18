import java.awt.Graphics;

public class GameObject {
	int x;

	int y;

	int width;

	int height;

	int length;

	public GameObject(int x, int y, int width, int length) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;

	}

	void update() {
		x += 10;
		x += y;
		// 12. Add code to your update method to move the object around. Do not move on
		// until this has been completed.
	}

	void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}
}
