package id.ac.its.trexucul.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
	
	private boolean[] keys;
	
	public static boolean UP, LEFT, RIGHT, DOWN;
	
	public KeyboardHandler() {
		keys = new boolean[256];
		UP = false;
		DOWN = false;
		RIGHT = false;
		LEFT = false;
	}
	
	public void update() {
		UP = keys[KeyEvent.VK_UP];
		LEFT = keys[KeyEvent.VK_LEFT];
		RIGHT = keys[KeyEvent.VK_RIGHT];
		DOWN = keys[KeyEvent.VK_DOWN];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {	
	}
}
