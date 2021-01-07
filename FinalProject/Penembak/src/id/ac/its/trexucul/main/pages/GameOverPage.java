package id.ac.its.trexucul.main.pages;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class GameOverPage extends PageState {
	
	private Image gameOverText = Assets.getImageText("gameOver.png", 481, 87);
	protected ArrayList<CommonButton> buttons  = new ArrayList<CommonButton>();

	public GameOverPage(Window window) {
		super(window);
		
		Assets.width = 177;
		Assets.height = 45;
		buttons.add(new CommonButton("coba_lagi_btn", Window.WIDTH/2 - 399, Window.HEIGHT/2 - 45, new ClickListener() {
			@Override
			public void onClick() {
				//Go to Level Page
				PageState.currentState = window.getLevelPage();
			}
		}, 237, 91));
		buttons.add(new CommonButton("keluar_btn", Window.WIDTH/2 + 161, Window.HEIGHT/2 - 45, new ClickListener() {
			@Override
			public void onClick() {
				// Exit game
				System.exit(1);
			}
		}, 237, 91));
	}

	@Override
	public void update() {
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameOverPage, 0, 0, null);
		g.drawImage(gameOverText, 399, 130, null);
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).render(g);
	}
}
