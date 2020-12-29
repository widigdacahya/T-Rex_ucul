package id.ac.its.trexucul.utils.helper;

import id.ac.its.trexucul.components.entities.Player;
import id.ac.its.trexucul.components.entities.Sniper;
import id.ac.its.trexucul.main.Window;

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
	
	
	public void update(Sniper sniper) {
		if (sniper.getX() > Window.WIDTH/2 && sniper.getX() < MAX_BG_WIDTH-Window.WIDTH/2)
			x = -sniper.getX() + Window.WIDTH/2;
	}

}
