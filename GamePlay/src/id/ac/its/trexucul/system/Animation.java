package id.ac.its.trexucul.system;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {
	protected int speed;
	protected int frames;
	
	protected int index = 0;
	protected int count = 0;
	
	protected BufferedImage[] images;
	protected BufferedImage currentImg;
	
	public Animation(int speed, BufferedImage... args) {
		this.speed = speed;
		images = new BufferedImage[args.length];
		 
		for(int i = 0; i < args.length; i++) {
			images[i] = args[i];
		}
		frames = args.length;
	}
	
	public void runAnimation() {
		index++;
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	}
	
	protected void nextFrame() {
		for (int i = 0; i < frames; i++) {
			if (count == i) {
				currentImg = images[i];
			}
		}
		
		count++;
		
		if (count > frames) 
			count = 0;
	}
	
	public void drawAnimation(Graphics g, int x, int y) {
		g.drawImage(currentImg, x, y, null);
	}
	
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
		g.drawImage(currentImg, x, y, scaleX, scaleY, null);
	}
}
