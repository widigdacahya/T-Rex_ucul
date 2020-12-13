package id.ac.its.trex.collisiondetection;

public class Missile extends Sprite{
	
	private final int BOARD_WIDTH = 1280;
	private final int MISSILE_SPEED = 2;
	
	public Missile(int x, int y) {
		super(x,y);
		initMissile();
	}
	
	private void initMissile() {
		loadImage("src/resources/missile.png");
		getImageDimensions();
	}
	
	
	//The missile moves at constant speed. 
	//When it hits the right border of the Board, 
	//it becomes invisible. 
	//It is then removed from the list of missiles.
	public void move() {
		x = x + MISSILE_SPEED;
		
		if (x > BOARD_WIDTH) {
			visible = false;
		}
	}

}
