import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final static int WIDTH = 500;
	final static int HEIGHT = 800;
	GamePanel gamepanel;

	public static void main(String[] args) {
		LeagueInvaders leagueinvaders = new LeagueInvaders();

		leagueinvaders.setup();

	}

	public LeagueInvaders() {
		frame = new JFrame();
		gamepanel = new GamePanel();
	}

	void setup() {
		frame.add(gamepanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.setPreferredSize(new Dimension(500, 800));
		frame.pack();

		gamepanel.startGame();
		frame.addKeyListener(gamepanel);

		frame.setTitle("LEAGUE INVADERS");

	}

}
