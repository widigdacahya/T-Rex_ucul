package id.ac.its.trexucul.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.id.SelectedGamePage;
import id.ac.its.trexucul.main.Camera;
import id.ac.its.trexucul.system.Animation;
import id.ac.its.trexucul.system.AnimationFire;
import id.ac.its.trexucul.util.BulletListener;
import id.ac.its.trexucul.util.BulletTimer;
import id.ac.its.trexucul.util.ClickListener;
import id.ac.its.trexucul.util.ImageLoader;
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
	
	//util
	private Timer timer;
	private BulletTimer bt;
	private final int Delay = 200;
    Random rand = new Random(); 
	
	//idle player
	private Image playerImg;
	
	//walking player
	private Image[] playerImgWalk = new Image[8];
	private BufferedImage[] pIWBuffered = new BufferedImage[8];
	private Animation walking;
	
	//player firing
	private Image[] playerImgFire = new Image[5];
	private BufferedImage[] pIFBuffered = new BufferedImage[5];
	private Animation firing;
	private int firingflag = 0;
	
	//player firing
	private Image[] playerImgWalkFire = new Image[5];
	private BufferedImage[] pIWFBuffered = new BufferedImage[5];
	private Animation firingWalk;
	private int firingWalkFlag = 0;
	
	//player steady
	private boolean steady = false;
	private BufferedImage pISBuffered;
	private boolean shield = true;
	
	private BulletListener click;
	
	private boolean visibility = true;
	private int health = 100;
	
	public Player(String name, int x, int y, BulletListener click) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		this.click = click;
		
		this.bt = new BulletTimer(0.2f);
		initPlayer();
	}

	private void initPlayer() {
		playerImg = Assets.getImagePlayer(imgName + ".png");
		
		//walking program
		playerImgWalk = Assets.getImagePlayerWalk();
		for(int i=0; i<playerImgWalk.length; i++)
			pIWBuffered[i] = ImageLoader.toBufferedImage(playerImgWalk[i]);
		walking = new Animation(2, pIWBuffered);
		
		//firing program
		playerImgFire = Assets.getImagePlayerFire();
		for(int i=0; i<playerImgFire.length; i++)
			pIFBuffered[i] = ImageLoader.toBufferedImage(playerImgFire[i]);
		firing = new Animation(1, pIFBuffered);
		//stead
		pISBuffered = ImageLoader.toBufferedImage(playerImgFire[4]);
		
		//walk fire program
		playerImgWalkFire = Assets.getImagePlayerWalkFire();
		for(int i=0; i<playerImgFire.length; i++)
			pIWFBuffered[i] = ImageLoader.toBufferedImage(playerImgWalkFire[i]);
		firingWalk = new Animation(1, pIWFBuffered);
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
				this.firingflag = 5;
				shield = false;
			}
		}

		move();
		
		collision(ground);
		
		walking.runAnimation();
		firing.runAnimation();
		firingWalk.runAnimation();
	}
	
	public void render(Graphics g) {
		
		//jika menembak ga perlu render yang walking
		if (visibility) {
			if(firingflag>0) {
				if(velX != 0) {
					firingWalk.drawAnimation(g, (int)x, (int)y);
				} else {
					firing.drawAnimation(g, (int)x, (int)y);
				}
				
				firingflag--;
				steady = true;
				shield = false;
				
			} else {
				if(steady) {
					g.drawImage(pISBuffered, this.x, this.y, null);
				} else {		
					bounds = new Rectangle(x, y, playerImg.getWidth(null), playerImg.getHeight(null));
			
					//walking animation
					if(velX != 0) {
						walking.drawAnimation(g, (int)x, (int)y);
						steady = false;
						shield = true;
					} else {
						g.drawImage(playerImg, this.x, this.y, null);
					}
				}
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
		}
		
		if (x < 0)
			x = 0;
		if (x > Camera.MAX_BG_WIDTH-playerImg.getWidth(null))
			x = Camera.MAX_BG_WIDTH-playerImg.getWidth(null);
	}
	
	private void collision(Ground ground) {
		if(getBounds().intersects(ground.getBounds())) {
			velY = 0;
			falling = false;
			jumping = false;
		}
	}
	
	public boolean updateVisibility(EnemyBullet eBullet) {
		boolean state = false;
		
		if (getBounds() != null && eBullet.getBounds() != null) {
			if(getBounds().intersects(eBullet.getBounds()) && !shield) {
				state = true;
				
//				if (type == SelectedGamePage.Satu)
//				else if (type == SelectedGamePage.Dua)
//				else if (type == SelectedGamePage.Tiga)
				health -= 1;

				eBullet.visible = false;
				
				if(health<0) {
					visibility = false;
				}
			}
		}

		return state;
	}
	
	public boolean isShield() {
		return shield;
	}

	public void setShield(boolean shield) {
		this.shield = shield;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x+12, y, 14, playerImg.getHeight(null));
	}
	
	public Rectangle getWholeBounds() {
		return new Rectangle(x, y, playerImg.getWidth(null), playerImg.getHeight(null));
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
}
