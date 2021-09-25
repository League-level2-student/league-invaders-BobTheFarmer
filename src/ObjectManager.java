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
	
	int score = 0;
	

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket; 
	}
	
	int getScore() {
		return score;
	}
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	
	void addAlien() {
		//System.out.println("Alien Spawned");
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		
		for (int i = 0; i < projectiles.size(); i++) {
			//System.out.println("Projectile " + i + " is active: " + projectiles.get(i).isActive);
			
		}
		
		
		//Aliens
			for (int i = 0; i < aliens.size(); i++) {
				aliens.get(i).update();
				
				if(aliens.get(i).y<0 || aliens.get(i).y>LeagueInvaders.HEIGHT) {
					aliens.get(i).isActive = false;
				}
			}
		
		//Projectiles
			for (int i = 0; i < projectiles.size(); i++) {
				projectiles.get(i).update();
				
				if(projectiles.get(i).y<0 || projectiles.get(i).y>LeagueInvaders.HEIGHT) {
					projectiles.get(i).isActive = false;
				}
			}	
			rocket.update();
			checkCollision();
			purgeObjects();
	}
	
	void checkCollision() {
		//Check if aliens are colliding with other game objects, and disable
		for(int i = 0; i < aliens.size(); i++) {
			//Check for Rocket Ship
				if(rocket.collisionBox.intersects(aliens.get(i).collisionBox)) {
					rocket.isActive = false;
					aliens.get(i).isActive = false;
					return;
				}
			
			//Projectiles
				for(int e = 0; e < projectiles.size(); e++) {
					System.out.println();
					if(projectiles.get(e).collisionBox.intersects(aliens.get(i).collisionBox)) {
						System.out.println("Collide");
						projectiles.get(e).isActive = false;
						aliens.get(i).isActive = false;
						
						score++;
					}
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
				//System.out.println("Removed projectile");
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
