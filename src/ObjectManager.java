import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	
	Random random = new Random();
	
	Rocketship rocket;
	
	
	ObjectManager(Rocketship rocket) {
		this.rocket = rocket; 
	}
	
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		//Aliens
			for (int i = 0; i < aliens.size(); i++) {
				aliens.get(i).update();
				
				if(aliens.get(i).y<0 || aliens.get(i).y<LeagueInvaders.HEIGHT) {
					aliens.get(i).isActive = false;
				}
			}
		
		//Projectiles
			for (int i = 0; i < projectiles.size(); i++) {
				projectiles.get(i).update();
				
				if(projectiles.get(i).y<0 || projectiles.get(i).y<LeagueInvaders.HEIGHT) {
					projectiles.get(i).isActive = false;
				}
			}	
			
	}
	
	void draw(Graphics g) {
		//Draw all objects
			rocket.draw(g);
			for (int i = 0; i < projectiles.size(); i++) {
				projectiles.get(i).draw(g);
			}	
			for (int i = 0; i < aliens.size(); i++) {
				aliens.get(i).draw(g);
			}
		
	}
	
	void purgeObjects() { 
		for (int i = 0; i < projectiles.size(); i++) {
			if(!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
		
		for (int i = 0; i < aliens.size(); i++) {
			if(!aliens.get(i).isActive) {
				aliens.remove(i);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();
	}
	
	
}
