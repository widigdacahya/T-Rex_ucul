package id.ac.its.trex.shapeapp;

import javax.swing.JFrame;

public class MainApp {
	public static void main(String[] args)
	{
		ContainerGUI panelFrame = new ContainerGUI();
		panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelFrame.setSize(450, 500);
		panelFrame.setVisible(true);
	}
}
