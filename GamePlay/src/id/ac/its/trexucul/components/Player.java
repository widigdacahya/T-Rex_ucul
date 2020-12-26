package id.ac.its.trexucul.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.main.Camera;
import id.ac.its.trexucul.util.BulletListener;
import id.ac.its.trexucul.util.ClickListener;
import id.ac.its.trexucul.util.KeyboardHandler;

public class Player {

	
	private String imgName;
	private int x, y;
	private float velX, velY;
	
	private float gravity = 0.5f;
	private float velSpeed = 4.0f;
	private Rectangle bounds;
	
	protected boolean falling = true;
	protected boolean jumping = false;
	private final int MAX_SPEED = 7; 
	
	private Image playerImg;
	private BulletListener click;
	
	public Player(String name, int x, int y, BulletListener click) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		this.click = click;
		initPlayer();
	}

	private void initPlayer() {
		playerImg = Assets.getImagePlayer(imgName + ".png");
	}
	
	public void update(Ground ground){		
		if(KeyboardHandler.UP && (!jumping) ) {
			velY = -10;
			jumping = true;
			falling = true;
		}
		
		if(KeyboardHandler.LEFT) {
			velX = -velSpeed;
		}
		
		if(KeyboardHandler.RIGHT) {
			velX = velSpeed;
		}

		if(KeyboardHandler.SPACE) {
			click.onClick(x + 84, y + 23);
		}

		move();
		
		Collision(ground);
	}
	
	public void render(Graphics g) {
		g.drawImage(playerImg, this.x, this.y, null);
		bounds = new Rectangle(x, y, playerImg.getWidth(null), playerImg.getHeight(null));
		
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.red);
//		g2d.draw(getBounds());
//		g2d.draw(getBoundsTop());
//		g2d.draw(getBoundsRight());
//		g2d.draw(getBoundsLeft());
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
		
		if (x < 0)
			x = 0;
		if (x > Camera.MAX_BG_WIDTH-playerImg.getWidth(null))
			x = Camera.MAX_BG_WIDTH-playerImg.getWidth(null);
	}
	
	private void Collision(Ground ground) {
		if(getBounds().intersects(ground.getBounds())) {
			velY = 0;
			falling = false;
			jumping = false;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle( (int) (x + 4), (int) ((int)y+(playerImg.getHeight(null)/2)), 24, 65);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle( (int) (x + 4),  (int)y,  24, 65);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle( (int) ((int)x+30), (int)y+2, 3, (int)playerImg.getHeight(null)-4);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+2, 3, (int)playerImg.getHeight(null)-4);
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
}
