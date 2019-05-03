import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static BufferedImage alienImg;

    public static BufferedImage rocketImg;

    public static BufferedImage bulletImg;

    public static BufferedImage spaceImg;
	Timer timer;
	Font titleFont;
	Rocketship rocket= new Rocketship(250,700,50,50);
	ObjectManager objectmanager= new ObjectManager(rocket);

	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	int currentState = MENU_STATE;

	@Override

	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	public GamePanel() {
        try {

            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

    } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

    }
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.CENTER_BASELINE, 35);
	}

	void startGame() {
		timer.start();

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 30, 50);
		g.drawString("Press ENTER to start ", 15, 300);
		g.drawString("Press SPACE for instructions", 0,500);
	}

	void drawGameState(Graphics g) {
        g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
objectmanager.draw(g);
	}

	
	
	
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString("Game Over", 175, 50);
		g.drawString("You killed " + objectmanager.getScore() +" enemies ", 100, 300);
		g.drawString("Press ENTER to restart", 50, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
	}

	private void updateEndState() {
		// TODO Auto-generated method stub

	}

	private void updateGameState() {
		// TODO Auto-generated method stub
objectmanager.update();
objectmanager.manageEnemies();
objectmanager.checkCollision();
objectmanager.purgeObjects();
if(rocket.isAlive==false) {
	currentState=END_STATE;
}
	}

	private void updateMenuState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState==END_STATE) {
				rocket=new Rocketship(250,700,50,50);
				objectmanager=new ObjectManager(rocket);
			}
			currentState++;
			if (currentState > END_STATE) {

				currentState = MENU_STATE;

			}
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			objectmanager.addProjectile(new Projectile(rocket.x+10, rocket.y+10, 10, 10));
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP) {
	rocket.up();
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
rocket.down();
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
rocket.left();
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
rocket.right();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println("hi");
	}

}
