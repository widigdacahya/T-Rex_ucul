package id.ac.its.trexucul.shootingaliens;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class SpaceShip extends Sprite{

	private int dx,dy;
	private List<Missile> missiles;
	
	
	//constructor
	public SpaceShip(int x, int y) {
		super(x,y);
		initSpaceShip();
	}
	
	private void initSpaceShip() {
		missiles = new ArrayList<>();
		
		loadImage("src/resources/spaceship.png");
		getImageDimensions();
	}
	
	
	//biar gerak
	public void move() {
		x = x + dx;
		y = y + dy;
		
		if(x<1) {
			x=1;
		}
		if(y<1) {
			y=1;
		}
	}
	
	public List<Missile> getMissiles() {
		return missiles;
	}
	
	
    
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if (key == KeyEvent.VK_LEFT) {
    		dx = -1;
    	}
    	
    	if (key == KeyEvent.VK_RIGHT) {
    		dx = 1;
    	}
    	
    	if(key == KeyEvent.VK_UP) {
    		dy = -1;
    	}
    	
    	if (key == KeyEvent.VK_DOWN) {
    		dy = 1;
    	}
    	
    	if ( key == KeyEvent.VK_SPACE ) {
    		fire();
    	}
    	
    } // closing bracket keyPressed
    
    
    public void fire() {
    	missiles.add(new Missile(x , y));
    }
    
    //release key, spaceship will stop moving
    public void keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if(key == KeyEvent.VK_LEFT) {
    		dx = 0;
    	}
    	
    	if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    	
    }
    
	
}
