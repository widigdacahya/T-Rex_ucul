package id.ac.its.trexucul.collisiondetection;



import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class SpaceShip extends Sprite{

	private int dx,dy;
	private List<Missile> missiles;
	
	public SpaceShip(int x, int y) {
		super(x,y);
		initSpaceShip();
	}
	
	private void initSpaceShip() {
		missiles = new ArrayList<>();
		
		loadImage("src/resources/spaceship.png");
		getImageDimensions();
	}
	
	public void move() {
		x = dx;
		y = dy;
		
//		if(x<1) {
//			x=dx;
//		}
//		if(y<1) {
//			y=dy;
//		}
	}
	
	public List<Missile> getMissiles() {
		return missiles;
	}
	
	public void cursorEnter(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void cursorExit(int dx, int dy) {
	}
	
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	
//    	if (key == KeyEvent.VK_LEFT) {
//    		dx = -1;
//    	}
//    	
//    	if (key == KeyEvent.VK_RIGHT) {
//    		dx = 1;
//    	}
//    	
//    	if(key == KeyEvent.VK_UP) {
//    		dy = -1;
//    	}
//    	
//    	if (key == KeyEvent.VK_DOWN) {
//    		dy = 1;
//    	}
    	
    	if ( key == KeyEvent.VK_SPACE ) {
    		fire();
    	}
    }
    
    
    public void fire() {
    	missiles.add(new Missile(x , y));
    }
    
//    public void keyReleased(KeyEvent e) {
//    	int key = e.getKeyCode();
//    	
//    	if(key == KeyEvent.VK_LEFT) {
//    		dx = 0;
//    	}
//    	
//    	if (key == KeyEvent.VK_RIGHT) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_UP) {
//            dy = 0;
//        }
//
//        if (key == KeyEvent.VK_DOWN) {
//            dy = 0;
//        }
//    }
}
