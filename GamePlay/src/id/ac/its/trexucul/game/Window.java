package id.ac.its.trexucul.game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	public Window(int w, int h, String title, Game g) {
		g.setPreferredSize(new Dimension(w, h));
		g.setMaximumSize(new Dimension(w, h));
		g.setMinimumSize(new Dimension(w, h));
		
		JFrame fr = new JFrame(title);
		fr.add(g);
		fr.pack();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		
		g.start();
	}

	public static void main() {
		
	}
}
