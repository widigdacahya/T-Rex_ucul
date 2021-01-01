package id.ac.its.jalil143.keyboardhandling;

import javax.swing.JFrame;

public class MainApp {
	public static void main(String[] args) {
		KeyDemoFrame keyDemoFrame = new KeyDemoFrame();
		keyDemoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keyDemoFrame.setSize(350, 100);
		keyDemoFrame.setVisible(true);
	}
}
