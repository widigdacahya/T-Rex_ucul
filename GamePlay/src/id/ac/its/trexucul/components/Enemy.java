package id.ac.its.trexucul.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;

import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.system.Animation;
import id.ac.its.trexucul.util.BulletListener;
import id.ac.its.trexucul.util.BulletTimer;
import id.ac.its.trexucul.util.ImageLoader;

public class Enemy {
	
	private String imgName;
	private int x, y;
	private float velX, velY;
	

	private float gravity = 0.5f;
	private float velSpeed = 4.0f;
	private Rectangle bounds;
	
	protected boolean falling = true;
	protected boolean jumping = false;
	private final int MAX_SPEED = 7;
	
	private Timer timer;
	
	//bt is bullet time which declare interval time between each shoot
	//jt declare interval between each enemy jump
	//rt declare time needed to reload
	private BulletTimer bt, jt, rt; 
	private final int Delay = 200;
	
	private Image playerImg;
	private Image[] playerImgWalk = new Image[6];
	private BufferedImage[] pIWBuffered = new BufferedImage[6];
	private Animation walking;
	
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	private boolean visibility = true;
	
	private Image enemyImg;
	
	public Enemy(String name, int x, int y) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		
		this.bt = new BulletTimer(0.2f);
		this.jt = new BulletTimer(7.5f);
		this.rt = new BulletTimer(2.0f);
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

		jump();
		
		move();
		
		fire();
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).update();
		}
		
		collision(ground);
	}
	
	public void updateVisibility(PlayerBullet bullet) {
		if (getBounds() != null && bullet.getBounds() != null) {
			if( getBounds().intersects(bullet.getBounds()) ) {
				visibility = false;
				bullet.visible = false;
			}
		}

	}
	
	public void jump() {
		
		if(jt.finishCounting())
		{
			velY = -12;
			jumping = true;
			falling = true;
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
	
	public void fire() {
		if(bt.finishCounting() && rt.finishCounting()) {
			
			bullets.add(new EnemyBullet("Bullet", x, y+23, null));
		}
			
	}
	
	public void render(Graphics g) {

		if (visibility) {
			g.drawImage(enemyImg, this.x, this.y, null);
			bounds = new Rectangle(x, y, enemyImg.getWidth(null), enemyImg.getHeight(null));
		
			for(int i = 0; i < bullets.size(); i++) {
				bullets.get(i).render(g);
			}
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
	
	public Rectangle getBoundsTop() {
		return new Rectangle( (int) (x + 4),  (int)y,  24, 65);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle( (int) ((int)x+30), (int)y+2, 3, (int)playerImg.getHeight(null)-4);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+2, 3, (int)playerImg.getHeight(null)-4);
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	
	public boolean isVisible() {
		return visibility;
	}
}
