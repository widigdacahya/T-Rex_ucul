package id.ac.its.trexucul.utils.handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import id.ac.its.trexucul.pages.PageState;
import id.ac.its.trexucul.pages.VictoryPage;
import id.ac.its.trexucul.utils.listener.KeyTypedListener;

public class KeyboardHandler implements KeyListener {
	
	private boolean[] keys;
	
	public static boolean UP, LEFT, RIGHT, DOWN, SPACE, ENTER;
	
	private KeyTypedListener keyListener;
	
	public KeyboardHandler(KeyTypedListener keyListener) {
		keys = new boolean[256];
		UP = false;
		DOWN = false;
		RIGHT = false;
		LEFT = false;
		SPACE = false;
		ENTER = false;
		
		this.keyListener = keyListener;
	}
	
	public void update() {
		UP = keys[KeyEvent.VK_UP];
		LEFT = keys[KeyEvent.VK_LEFT];
		RIGHT = keys[KeyEvent.VK_RIGHT];
		DOWN = keys[KeyEvent.VK_DOWN];
		SPACE = keys[KeyEvent.VK_SPACE];
		ENTER = keys[KeyEvent.VK_ENTER];
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
	public void keyTyped(KeyEvent e) {
		if (PageState.currentState instanceof VictoryPage) {
			keyListener.keyInput(e);
		}
	}
}
