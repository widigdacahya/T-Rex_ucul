package id.ac.its.trexucul.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import id.ac.its.trexucul.gfx.Assets;

public class Bullet {
	
	private String imgName;
	private int x, y;
	private float velX = 50.0f;
	private Rectangle bounds;
	
	private Image bulletImg;
	
	public Bullet(String name, int x, int y) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		initBullet();
	}
	
	private void initBullet() {
		bulletImg = Assets.getImageBullet(imgName + ".png");
	}
	
	public void update(){
		x += velX;
	}
	
	public void render(Graphics g) {
		g.drawImage(bulletImg, this.x, this.y, null);
		bounds = new Rectangle(x, y, bulletImg.getWidth(null), bulletImg.getHeight(null));
	}
}
