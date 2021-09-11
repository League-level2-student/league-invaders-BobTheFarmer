import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel 
implements ActionListener, KeyListener {
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	
	Timer frameDraw;
	
	Font titleFont;
	Font subTitleFont;
	
	
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	
	GamePanel() {
	//Set Variables
		titleFont = new Font("Oxygen", Font.PLAIN, 48);
		subTitleFont = new Font("Oxygen", Font.PLAIN, 28);
		 
		frameDraw = new Timer(1000/60,this);
		 
	//Other
		 frameDraw.start();
		 
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	//Run Methods
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	//Draw things
		repaint();
		
	}
	
	
	void updateMenuState() {  
		
	}
	void updateGameState() {
		
	}
	void updateEndState()  {  
		
	}
	
	void drawMenuState(Graphics g) {
		//Background
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		//Text
			g.setFont(titleFont);
			g.setColor(Color.YELLOW);
			g.drawString("League Invaders", 50, 300);
			g.setFont(subTitleFont);
			g.drawString("Press ENTER to Start", 100, 500);
			g.drawString("Press SPACE for Instructions", 70, 540);
		
	}
	void drawGameState(Graphics g) {
		//Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		
		//Draw Rocket
			rocket.draw(g);
	}
	void drawEndState(Graphics g)  {  
		//Background
			g.setColor(Color.RED);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		//Text
			g.setFont(titleFont);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", 50, 300);
		
	 }

	
	


	@Override
	public void keyPressed(KeyEvent e) {
	
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		
		    if (currentState == END) {
		    
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		} 
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    rocket.up();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		   rocket.down();
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			rocket.right();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocket.left();
		}
		
		
		
	}
	
//Useless methods
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}


	
}
