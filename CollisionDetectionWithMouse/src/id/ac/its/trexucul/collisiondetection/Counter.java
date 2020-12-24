package id.ac.its.trexucul.collisiondetection;

import java.util.Timer;
import java.util.TimerTask;

public class Counter {
	
	private Counter timer;
	private int DELAY = 1000;
	private int PERIOD = 1000;
	private int interval = 5;
	private int secs = 0;
	
	public Counter() {
		Timer timer = new Timer();
	}
	
	public void runTimer() {
//		timer.scheduleAtFixedRate(new TimerTask() {
//			public void run() {
//				
//			}
//		}, DELAY, PERIOD);
	}
	
	public int getSecs() {
		return secs;
	}
}
