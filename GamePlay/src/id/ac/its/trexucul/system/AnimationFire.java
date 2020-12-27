package id.ac.its.trexucul.system;

import java.awt.image.BufferedImage;

import id.ac.its.trexucul.util.BulletTimer;

public class AnimationFire extends Animation{
	
	private BulletTimer timer = new BulletTimer(0.3f);

	public AnimationFire(int speed, BufferedImage[] args) {
		super(speed, args);
	}
	
	@Override
	public void runAnimation() {
		
		if(timer.finishCounting()) {
			nextFrame();
			
		}
		
	}

}
