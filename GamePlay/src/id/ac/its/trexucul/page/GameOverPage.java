package id.ac.its.trexucul.page;

import java.awt.Graphics;
import java.awt.Image;

import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.PageState;

public class GameOverPage extends PageState {
	
	private Image gameOverText = Assets.getImageText("gameOver.png");

	public GameOverPage(Window window) {
		super(window);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameOverPage, 0, 0, null);
		g.drawImage(gameOverText, 400, 200, null);
		
	}

}
