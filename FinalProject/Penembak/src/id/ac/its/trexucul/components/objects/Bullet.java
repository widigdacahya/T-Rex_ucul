package id.ac.its.trexucul.components.objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import id.ac.its.trexucul.model.gfx.Assets;

public class Bullet {
	
	protected String imgName;
	protected int x, y;
	protected float velX;
	protected Rectangle bounds;
	public boolean visible;
	protected Image bulletImg;
	
	public Bullet(String name, int x, int y, float velX) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.visible = true;
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

	public Rectangle getBounds() {
		return bounds;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
