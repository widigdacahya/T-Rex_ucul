package id.ac.its.trexucul.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import id.ac.its.trexucul.gfx.Assets;

public class Player {

	
	private String imgName;
	private int x, y;
	private Rectangle bounds;
	
	private Image playerImg;
	
	public Player(String name, int x, int y) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		initPlayer();
	}
	
	private void initPlayer() {
		playerImg = Assets.getImagePlayer(imgName + ".png");
	}
	
	public void update(){		
		
	}
	
	public void render(Graphics g) {
		g.drawImage(playerImg, this.x, this.y, null);
		bounds = new Rectangle(x, y, playerImg.getWidth(null), playerImg.getHeight(null));
	}
	
}
