import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		y += 5;
		x += 1;
		x -= 2;
		x += 1;
		super.update();
	}

	void draw(Graphics g) {
        g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}

}
