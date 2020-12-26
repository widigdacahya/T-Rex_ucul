package id.ac.its.trexucul.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import id.ac.its.trexucul.gfx.Assets;

public class Ground {
	
	private String imgName;
	private int x, y;
	private Rectangle bounds;
	
	private Image groundImg;
	
	public Ground(String name, int x, int y) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		initGround();
	}
	
	private void initGround() {
		groundImg = Assets.getGround(imgName + ".png");
	}
	
	public void update(){		
		
	}
	
	public void render(Graphics g) {
		g.drawImage(groundImg, this.x, this.y, null);
		bounds = new Rectangle(x, y, groundImg.getWidth(null), groundImg.getHeight(null));
	}

}
