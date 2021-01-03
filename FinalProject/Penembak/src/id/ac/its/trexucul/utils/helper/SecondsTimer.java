package id.ac.its.trexucul.utils.helper;

public class SecondsTimer {
	
	private Long startTime = 0l;
	private Long currentTime = 0l;
	private float timeSec = 0;
	private float counter;
	
	public SecondsTimer(float delay) {
		this.counter = delay;
		startTime = System.currentTimeMillis();
	}
	
	public boolean finishCounting() {
		
		currentTime = System.currentTimeMillis() - startTime;
		timeSec = currentTime.floatValue()/1000;
		
		if (counter - timeSec < 0) {
			startTime = System.currentTimeMillis();
			return true;
		}
		
		return false;
	}
	
}
