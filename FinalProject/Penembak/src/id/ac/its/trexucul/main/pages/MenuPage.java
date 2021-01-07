package id.ac.its.trexucul.main.pages;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class MenuPage extends PageState {
	
	private ArrayList<CommonButton> btns  = new ArrayList<CommonButton>();
	private Image titleGameMenu = Assets.getImageAssetGen("titledimenuya.png");

	public MenuPage(Window window) {
		super(window);
		
		btns.add(new CommonButton("main_btn", Window.WIDTH/2 - 136, Window.HEIGHT/2 - 135, new ClickListener() {
			@Override
			public void onClick() {
				// Level Page
				PageState.currentState = window.getLevelPage();
			}
		}, 273, 104));
		btns.add(new CommonButton("skor_btn", Window.WIDTH/2 - 136, Window.HEIGHT/2 - 2, new ClickListener() {
			@Override
			public void onClick() {
				// score
				PageState.currentState = window.getScorePage();
			}
		}, 273, 104));
		btns.add(new CommonButton("credit_btn", Window.WIDTH/2 - 136, Window.HEIGHT/2 + 131 , new ClickListener() {
			@Override
			public void onClick() {
				// go to credit screen
				PageState.currentState = window.getCreditPage();
			}
		}, 273, 104));
	}

	@Override
	public void update() {
		for(int i = 0; i < btns.size(); i++)
			btns.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.menuBG, 0, 0, null);
		for(int i = 0; i < btns.size(); i++)
			btns.get(i).render(g);
		g.drawImage(titleGameMenu, 0, 0, null);
	}
}
