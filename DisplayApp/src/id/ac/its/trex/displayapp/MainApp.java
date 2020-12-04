package id.ac.its.trex.displayapp;

import javax.swing.JFrame;

import id.ac.its.trex.displayapp.gui.LabelFrame;


public class MainApp {

	public static void main(String[] args) {
		LabelFrame labelFrame = new LabelFrame();
		labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrame.setResizable(true);
		labelFrame.setSize(450, 700);
		labelFrame.setVisible(true);
	}
}
