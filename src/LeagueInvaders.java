//Token: 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

import javax.swing.JFrame;

public class LeagueInvaders {

public static final int WIDTH = 500;
public static final int HEIGHT = 800;

JFrame frame;
GamePanel panel;

final int MENU = 0;
final int GAME = 1;
final int END = 2;

LeagueInvaders() {
	//UI
		frame = new JFrame();
		panel = new GamePanel();
}

void setup() {
	frame.add(panel);
	
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
}
