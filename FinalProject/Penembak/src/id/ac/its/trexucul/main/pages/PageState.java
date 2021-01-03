package id.ac.its.trexucul.main.pages;

import java.awt.Graphics;

import id.ac.its.trexucul.main.Window;

public abstract class PageState {
	
	public static PageState currentState = null;
	
	protected Window window;
	
	public PageState(Window window){
		this.window = window;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
}
