package id.ac.its.jalil143.mousetracker;

import javax.swing.JFrame;

public class MainApp {
	public static void main(String[] args)
	{
		MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
		mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseTrackerFrame.setSize(300, 100);
		mouseTrackerFrame.setVisible(true);
	}
}
