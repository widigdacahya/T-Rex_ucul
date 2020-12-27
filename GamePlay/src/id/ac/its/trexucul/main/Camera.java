package id.ac.its.trexucul.main;

import id.ac.its.trexucul.components.Player;

public class Camera {
	
	public float x,y;

	public static int MAX_BG_WIDTH = 4370;
	
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
	
	
	public void update(Player player) {
		if (player.getX() > Window.WIDTH/2 && player.getX() < MAX_BG_WIDTH-Window.WIDTH/2)
			x = -player.getX() + Window.WIDTH/2;
	}

}
