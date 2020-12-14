package id.ac.its.trexucul.collisiondetection;

public class Alien extends Sprite {

	private final int INITIAL_X = 1280;
	
	
	public Alien(int x, int y) {
		super(x,y);
		
		initAlien();
	}
	
	private void initAlien() {
		loadImage("src/resources/alien.png");
		getImageDimensions();
	}
	
	public void move() {
		
		if(x<0) {
			x = INITIAL_X;
		}
		
		x -= 1;
		
	}
	
	
}

