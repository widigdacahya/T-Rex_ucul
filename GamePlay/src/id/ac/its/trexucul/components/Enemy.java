package id.ac.its.trexucul.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import id.ac.its.trexucul.gfx.Assets;

public class Enemy {
	
	private String imgName;
	private int x, y;
	private float velX, velY;
	
	private final int MAX_SPEED = 7;
	private Rectangle bounds;
	private float gravity = 0.5f;
	
	protected boolean falling = true;
	protected boolean jumping = false;
	
	private boolean visibility = true;
	
	private Image enemyImg;
	
	public Enemy(String name, int x, int y) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		initEnemy();
	}
	
	private void initEnemy() {
		enemyImg = Assets.getImageEnemy(imgName + ".png");
	}
	
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
	
	
	public void update(Ground ground){
		move();
		
		collision(ground);
	}
	
	public void updateVisibility(PlayerBullet bullet) {
		if (getBounds() != null && bullet.getBounds() != null) {
			if( getBounds().intersects(bullet.getBounds()) ) {
				visibility = false;
			}
		}
	}
	
	private void move() {
		
		x += velX;
		y += velY;
		
		if(falling || jumping) {
			velY += gravity;
			
			if(velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		} else {
			velX = velY= 0;
		}
		
	}
	
	public void render(Graphics g) {
		if (visibility) {
			g.drawImage(enemyImg, this.x, this.y, null);
			bounds = new Rectangle(x, y, enemyImg.getWidth(null), enemyImg.getHeight(null));
		}
	}
	
	private void collision(Ground ground) {
		if( getBounds().intersects( ground.getBounds() ) ) {
			falling = false;
			jumping = false;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x+68, y, 14, enemyImg.getHeight(null));
	}
	
	public Rectangle getWholeBounds() {
		return new Rectangle( x, y, enemyImg.getWidth(null), enemyImg.getHeight(null));
	}

	public boolean isVisible() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
}
