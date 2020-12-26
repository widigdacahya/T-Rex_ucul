package id.ac.its.trexucul.main;

import id.ac.its.trexucul.components.Player;

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
	
	
	public void tick(Player player) {
		//x--; //biar kamera gerak sendiri
		//x = -player.getX() + Window.WIDTH/2;
	}

}
