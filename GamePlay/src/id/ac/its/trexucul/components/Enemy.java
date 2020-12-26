package id.ac.its.trexucul.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import id.ac.its.trexucul.gfx.Assets;

public class Enemy {
	
	private String imgName;
	private int x, y;
	private Rectangle bounds;
	
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
	
	public void update(){		
		
	}
	
	public void render(Graphics g) {
		g.drawImage(enemyImg, this.x, this.y, null);
		bounds = new Rectangle(x, y, enemyImg.getWidth(null), enemyImg.getHeight(null));
	}

}
