package id.ac.its.trexucul.components.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import id.ac.its.trexucul.components.objects.EnemyBullet;
import id.ac.its.trexucul.components.objects.Ground;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.handler.KeyboardHandler;
import id.ac.its.trexucul.utils.helper.Animation;
import id.ac.its.trexucul.utils.helper.AnimationFire;
import id.ac.its.trexucul.utils.helper.BulletTimer;
import id.ac.its.trexucul.utils.helper.Camera;
import id.ac.its.trexucul.utils.helper.ImageLoader;
import id.ac.its.trexucul.utils.listener.BulletListener;
import id.ac.its.trexucul.utils.listener.ClickListener;

public abstract class Player {

	protected String imgName;
	protected int x, y;
	protected float velX, velY;
	protected int fireDamage; //enemy damage to player
	protected int toEnemyDamage;
	
	protected float gravity = 0.5f;
	protected float velSpeed = 4.0f;
	protected Rectangle bounds;
	
	protected boolean falling = true;
	protected boolean jumping = false;
	protected final int MAX_SPEED = 7;
	
	//util
	protected Timer timer;
	protected BulletTimer bt;
	protected final int Delay = 200;
    Random rand = new Random(); 
	
    protected boolean steady = false;
    protected boolean shield = true;
    protected int firingflag = 0;
    protected int firingWalkFlag = 0;
	
    protected BulletListener click;
	
    protected boolean visibility = true;
    protected int health = 100;
	
	public Player(String name, int x, int y, BulletListener click) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		this.click = click;
	}
	
	public void update(Ground ground){		
		if(KeyboardHandler.UP && (!jumping) ) {
			velY = -25;
			jumping = true;
			falling = true;
			shield = false;
		}
		
		if(KeyboardHandler.LEFT) {
			velX = -velSpeed;
			steady = false;
			shield = false;
		}
		
		if(KeyboardHandler.RIGHT) {
			velX = velSpeed;
			steady = false;
			shield = false;
		} 
		
		if(!KeyboardHandler.RIGHT && !KeyboardHandler.LEFT) {
			velX = 0;
		}
		
		if(KeyboardHandler.SPACE) {
			if(bt.finishCounting()) {
				click.onClick(x + 84, y + 23);
				setFiringFlag();
				shield = false;
			}
		}

		move();
		
		collision(ground);
		animating();
	}
	
	public void move() {
		
		x += velX;
		y += velY;
		
		if(falling || jumping) {
			velY += gravity;
			
			if(velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		}
		
		setCam();
	}

	//abstract section
	public abstract void initPlayer();
	public abstract void animating();
	public abstract void setFiringFlag();
	public abstract void render(Graphics g);
	public abstract void setCam();
	public abstract void collision(Ground ground);
	public abstract boolean updateVisibility(EnemyBullet eBullet);
	
	
	//setter getter section
	public boolean isShield() {
		return shield;
	}

	public void setShield(boolean shield) {
		this.shield = shield;
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

	public boolean isVisible() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isSteady() {
		return steady;
	}

	public void setSteady(boolean steady) {
		this.steady = steady;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public int getFireDamage() {
		return fireDamage;
	}

	public void setFireDamage(int fireDamage) {
		this.fireDamage = fireDamage;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public int getToEnemyDamage() {
		return toEnemyDamage;
	}

	public void setToEnemyDamage(int toEnemyDamage) {
		this.toEnemyDamage = toEnemyDamage;
	}

}
