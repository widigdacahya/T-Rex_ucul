package id.ac.its.trexucul.utils.helper;

import java.awt.image.BufferedImage;

public class AnimationFire extends Animation{
	
	private SecondsTimer timer = new SecondsTimer(0.3f);

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
