package id.ac.its.trexucul.components.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Random;

import id.ac.its.trexucul.components.objects.Ground;
import id.ac.its.trexucul.components.objects.PlayerBullet;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.pages.GamePage;
import id.ac.its.trexucul.utils.helper.Animation;
import id.ac.its.trexucul.utils.helper.BulletTimer;
import id.ac.its.trexucul.utils.helper.ImageLoader;
import id.ac.its.trexucul.utils.listener.BulletListener;

public class Enemy {
	
	private String imgName;
	private int x, y;
	private float velX, velY;
	private int fireDamage;

	private float gravity = 0.5f;
	private float velSpeed = 4.0f;
	private Rectangle bounds;
	
	protected boolean falling = true;
	protected boolean jumping = false;
	private final int MAX_SPEED = 7;
	
	//utility
	private Timer timer;
    Random rand = new Random(); 
	
	//bt is bullet time which declare interval time between each shoot
	//jt declare interval between each enemy jump
	//rt declare time needed to reload
	private BulletTimer bt, jt, rt; 

	private final int Delay = 200;
	
	private Image playerImg;
	private Image[] playerImgWalk = new Image[6];
	private BufferedImage[] pIWBuffered = new BufferedImage[6];
	private Animation walking;
	
	//enemies stats
	private boolean visibility = true;
	private boolean included = false;
	private int health = 100;
	private boolean bullet;	
	private Image enemyImg;
	
	public Enemy(String name, int x, int y) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		
		this.bt = new BulletTimer(0.2f);
		this.jt = new BulletTimer(7.5f);
		this.rt = new BulletTimer(5.0f);
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
		if (included) {
			jump();
			reload();
		}
		
		move();
			
		collision(ground);
	}
	
	public void render(Graphics g) {

		if (visibility) {
			g.drawImage(enemyImg, this.x, this.y, null);
			bounds = new Rectangle(x, y, enemyImg.getWidth(null), enemyImg.getHeight(null));
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
	
	private void collision(Ground ground) {
		if(getBounds().intersects(ground.getBounds())) {
			falling = false;
			jumping = false;
		}
	}
	
	public boolean updateVisibility(PlayerBullet bullet) {
		boolean state = false;
		
		if (getBounds() != null && bullet.getBounds() != null) {
			if(getBounds().intersects(bullet.getBounds())) {
				state = true;

				health -= fireDamage;

				bullet.visible = false;

				if(health < 0) {
					visibility = false;
				}
			}
		}

		return state;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void jump() {
		
		if(jt.finishCounting()) {
			velY = -12;
			jumping = true;
			falling = true;
		}
	}
	
	public void reload() {
		if(rt.finishCounting()) {
			bullet = true;
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

	public boolean isIncluded() {
		return included;
	}

	public void setIncluded(boolean included) {
		this.included = included;
	}
	
	public BulletTimer getBt() {
		return bt;
	}

	public void setBt(BulletTimer bt) {
		this.bt = bt;
	}

	public BulletTimer getJt() {
		return jt;
	}

	public void setJt(BulletTimer jt) {
		this.jt = jt;
	}

	public BulletTimer getRt() {
		return rt;
	}

	public void setRt(BulletTimer rt) {
		this.rt = rt;
	}

	public boolean getBullet() {
		return bullet;
	}

	public void setBullet(boolean bullet) {
		this.bullet = bullet;
	}

	public int getFireDamage() {
		return fireDamage;
	}

	public void setFireDamage(int fireDamage) {
		this.fireDamage = fireDamage;
	}
}
