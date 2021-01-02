package id.ac.its.trexucul.main.pages;

import java.awt.Color;
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
		//mengubah ukuran tombol main
		Assets.width = 250;
		Assets.height = 80;
		
		btns.add(new CommonButton("main_menu_btn", Window.WIDTH/2 - 125, Window.HEIGHT/2 - 100, new ClickListener() {
			@Override
			public void onClick() {
				
				// Level Page
				PageState.currentState = window.getLevelPage();
				
			}
		}));
		btns.add(new CommonButton("pengaturan_menu_btn", Window.WIDTH/2 - 125, Window.HEIGHT/2 , new ClickListener() {
			@Override
			public void onClick() {
				// pengaturan
			}
		}));
		btns.add(new CommonButton("credit_btn", Window.WIDTH/2 - 125, Window.HEIGHT/2 + 100 , new ClickListener() {
			@Override
			public void onClick() {
				// go to credit screen
				PageState.currentState = window.getCreditPage();
			}
		}));
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
