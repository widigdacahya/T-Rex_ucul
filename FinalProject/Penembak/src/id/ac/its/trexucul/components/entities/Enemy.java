package id.ac.its.trexucul.components.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import id.ac.its.trexucul.components.objects.Ground;
import id.ac.its.trexucul.components.objects.PlayerBullet;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.utils.helper.SecondsTimer;

public class Enemy {
	
	private String imgName;
	private int x, y;
	private float velX, velY;
	private int fireDamage;

	private float gravity = 0.5f;
	protected boolean falling = true;
	protected boolean jumping = false;
	private final int MAX_SPEED = 7;
	
	Random rand = new Random(); 
	
	//bt is bullet time which declare interval time between each shoot
	//jt declare interval between each enemy jump
	//rt declare time needed to reload
	private SecondsTimer bt, jt, rt; 
	private Image playerImg;
	
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
		
		this.bt = new SecondsTimer(0.2f);
		this.jt = new SecondsTimer(7.5f);
		this.rt = new SecondsTimer(5.0f);
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
			new Rectangle(x, y, enemyImg.getWidth(null), enemyImg.getHeight(null));
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
		return new Rectangle(x, y, enemyImg.getWidth(null), enemyImg.getHeight(null));
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle(x + 4, y,  24, 65);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle(x+30, y+2, 3, playerImg.getHeight(null)-4);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle(x, y+2, 3, playerImg.getHeight(null)-4);
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
	
	public SecondsTimer getBt() {
		return bt;
	}

	public void setBt(SecondsTimer bt) {
		this.bt = bt;
	}

	public SecondsTimer getJt() {
		return jt;
	}

	public void setJt(SecondsTimer jt) {
		this.jt = jt;
	}

	public SecondsTimer getRt() {
		return rt;
	}

	public void setRt(SecondsTimer rt) {
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
