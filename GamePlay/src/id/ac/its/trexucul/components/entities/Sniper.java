package id.ac.its.trexucul.components.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import id.ac.its.trexucul.components.objects.EnemyBullet;
import id.ac.its.trexucul.components.objects.Ground;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.pages.CharacterPage;
import id.ac.its.trexucul.utils.helper.Animation;
import id.ac.its.trexucul.utils.helper.SecondsTimer;
import id.ac.its.trexucul.utils.helper.Camera;
import id.ac.its.trexucul.utils.helper.ImageLoader;
import id.ac.its.trexucul.utils.listener.BulletListener;

public class Sniper extends Player{

	//idle player
	protected Image playerImg;
	
	//walking player
	protected Image[] playerImgWalk = new Image[17];
	protected BufferedImage[] pIWBuffered = new BufferedImage[17];
	protected Animation walking;
	
	//player firing
	protected Image[] playerImgFire = new Image[15];
	protected BufferedImage[] pIFBuffered = new BufferedImage[15];
	protected Animation firing;
	
	//player firing
	protected Image[] playerImgWalkFire = new Image[15];
	protected BufferedImage[] pIWFBuffered = new BufferedImage[15];
	protected Animation firingWalk;
	
	//player steady
	protected BufferedImage pISBuffered;
	
	public Sniper(String name, int x, int y, BulletListener click) {
		super(name, x, y, click);

		//set damage and reload
		this.bt = new SecondsTimer(1.0f);
		super.setToEnemyDamage(90);		
		initPlayer();
	}
	
	public void initPlayer() {//set animation
		
		
		//walking program
		if(CharacterPage.selectedCharacter == SelectedGamePage.Dua) {
			playerImg = Assets.getImageSniper("shield.png");
			playerImgWalk = Assets.getImageSniperWalk();
			playerImgFire = Assets.getImageSniperFire();
			playerImgWalkFire = Assets.getImageSniperWalkFire();
		}else {
			playerImg = Assets.getImageSniper2("shield.png");
			playerImgWalk = Assets.getImageSniperWalk2();
			playerImgFire = Assets.getImageSniperFire2();
			playerImgWalkFire = Assets.getImageSniperWalkFire2();
		}
		
		for(int i=0; i<playerImgWalk.length; i++)
			pIWBuffered[i] = ImageLoader.toBufferedImage(playerImgWalk[i]);
		walking = new Animation(2, pIWBuffered);
		
		//firing program
		for(int i=0; i<playerImgFire.length; i++)
			pIFBuffered[i] = ImageLoader.toBufferedImage(playerImgFire[i]);
		firing = new Animation(0, pIFBuffered);
		//stead
		pISBuffered = ImageLoader.toBufferedImage(playerImgFire[14]);
		
		//walk fire program
		for(int i=0; i<playerImgFire.length; i++)
			pIWFBuffered[i] = ImageLoader.toBufferedImage(playerImgWalkFire[i]);
		firingWalk = new Animation(2, pIWFBuffered);
	}
	
	public void animating() {
		walking.runAnimation();
		firing.runAnimation();
		firingWalk.runAnimation();
	}
	
	public void setFiringFlag() {
		this.firingflag = 15;
	}
	
	@Override
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
	
	public void setCam() {
		if (x < 0)
			x = 0;
		if (x > Camera.MAX_BG_WIDTH-playerImg.getWidth(null))
			x = Camera.MAX_BG_WIDTH-playerImg.getWidth(null);
	}
	
	public void collision(Ground ground) {
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
				
				health -= fireDamage;

				eBullet.visible = false;
				
				if(health<0) {
					visibility = false;
				}
			}
		}

		return state;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x+12, y, 14, playerImg.getHeight(null));
	}
	
	public Rectangle getWholeBounds() {
		return new Rectangle(x, y, playerImg.getWidth(null), playerImg.getHeight(null));
	}
	
	public Image getPlayerImg() {
		return playerImg;
	}

	public void setPlayerImg(Image playerImg) {
		this.playerImg = playerImg;
	}

	public Image[] getPlayerImgWalk() {
		return playerImgWalk;
	}

	public void setPlayerImgWalk(Image[] playerImgWalk) {
		this.playerImgWalk = playerImgWalk;
	}

	public BufferedImage[] getpIWBuffered() {
		return pIWBuffered;
	}

	public void setpIWBuffered(BufferedImage[] pIWBuffered) {
		this.pIWBuffered = pIWBuffered;
	}

	public Image[] getPlayerImgFire() {
		return playerImgFire;
	}

	public void setPlayerImgFire(Image[] playerImgFire) {
		this.playerImgFire = playerImgFire;
	}

	public BufferedImage[] getpIFBuffered() {
		return pIFBuffered;
	}

	public void setpIFBuffered(BufferedImage[] pIFBuffered) {
		this.pIFBuffered = pIFBuffered;
	}

	public Image[] getPlayerImgWalkFire() {
		return playerImgWalkFire;
	}

	public void setPlayerImgWalkFire(Image[] playerImgWalkFire) {
		this.playerImgWalkFire = playerImgWalkFire;
	}

	public BufferedImage[] getpIWFBuffered() {
		return pIWFBuffered;
	}

	public void setpIWFBuffered(BufferedImage[] pIWFBuffered) {
		this.pIWFBuffered = pIWFBuffered;
	}

	public BufferedImage getpISBuffered() {
		return pISBuffered;
	}

	public void setpISBuffered(BufferedImage pISBuffered) {
		this.pISBuffered = pISBuffered;
	}
}
