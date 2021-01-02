package id.ac.its.trexucul.main.pages;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class GameOverPage extends PageState {
	
	private Image gameOverText = Assets.getImageText("gameOver.png");
	protected ArrayList<CommonButton> buttons  = new ArrayList<CommonButton>();

	public GameOverPage(Window window) {
		super(window);
		
		Assets.width = 177;
		Assets.height = 45;
		buttons.add(new CommonButton("coba_lagi_btn", Window.WIDTH/2 - 300, Window.HEIGHT/2, new ClickListener() {
			@Override
			public void onClick() {
				
				//Go to Level Page
				PageState.currentState = window.getLevelPage();
				
			}
		}));
		buttons.add(new CommonButton("keluar_btn", Window.WIDTH/2 + 125, Window.HEIGHT/2, new ClickListener() {
			@Override
			public void onClick() {
				
				// Exit game
				System.exit(1);
			}
		}));
		
	}

	@Override
	public void update() {
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameOverPage, 0, 0, null);
		g.drawImage(gameOverText, 400, 200, null);
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).render(g);
	}

}