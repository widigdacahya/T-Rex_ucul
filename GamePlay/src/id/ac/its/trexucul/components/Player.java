package id.ac.its.trexucul.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.util.KeyboardHandler;

public class Player {

	
	private String imgName;
	private int x, y;
	private float velX, velY;
	private float gravity = 0.5f;
	private Rectangle bounds;
	protected boolean falling = false;
	protected boolean jumping = false;
	private final int MAX_SPEED = 7; 
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	protected boolean isFalling() {
		return falling;
	}

	protected void setFalling(boolean falling) {
		this.falling = falling;
	}

	protected boolean isJumping() {
		return jumping;
	}

	protected void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
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
		
		if(falling || jumping) {
			velY += gravity;
			
			if(velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
			
			this.x += velX;
			this.y += velY;
			
		}else {

			this.x += velX;
			this.y += velY;
			
			velX = velY = 0;
		}
		
	}
	
}
