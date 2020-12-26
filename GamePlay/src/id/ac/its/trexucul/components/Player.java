package id.ac.its.trexucul.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.util.KeyboardHandler;

public class Player {

	
	private String imgName;
	private int x, y;
	private int velX, velY;
	private Rectangle bounds;
	
	private Image playerImg;
	
	public Player(String name, int x, int y) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		initPlayer();
	}
	
	private void initPlayer() {
		playerImg = Assets.getImagePlayer(imgName + ".png");
	}
	
	public void update(){		
		if(KeyboardHandler.UP) {
			velY = -1;
		}
		if(KeyboardHandler.LEFT) {
			velX = -1;
		}
		if(KeyboardHandler.DOWN) {
			velY = 1;
		}
		if(KeyboardHandler.RIGHT) {
			velX = 1;
		}
		move();
	}
	
	public void render(Graphics g) {
		g.drawImage(playerImg, this.x, this.y, null);
		bounds = new Rectangle(x, y, playerImg.getWidth(null), playerImg.getHeight(null));
	}
	
	private void move() {
		this.x += velX;
		this.y += velY;
		
		velX = velY = 0;
	}
	
}
