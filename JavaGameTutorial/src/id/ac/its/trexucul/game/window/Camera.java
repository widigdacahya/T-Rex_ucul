package id.ac.its.trexucul.game.window;

import id.ac.its.trexucul.game.framework.GameObject;

public class Camera {
	
	private float x,y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
	public void tick(GameObject player) {
		// x--; //biar kamera gerak sendiri
		x = -player.getX() + Game.WIDTH/2;
	}

}
