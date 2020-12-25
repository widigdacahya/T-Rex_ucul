package id.ac.its.trexucul.page;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.ClickListener;
import id.ac.its.trexucul.util.PageState;

public class MenuPage extends PageState {
	
	private ArrayList<CommonButton> btns  = new ArrayList<CommonButton>();

	public MenuPage(Window window) {
		
		super(window);
		
		//mengubah ukuran tombol main
		Assets.width = 250;
		Assets.height = 80;
		
		btns.add(new CommonButton("main_menu_btn", Window.WIDTH/2 - 125, Window.HEIGHT/2 - 50, new ClickListener() {
			@Override
			public void onClick() {
				
				// Level Page
				PageState.currentState = window.getLevelPage();
				
			}
		}));
		
		btns.add(new CommonButton("pengaturan_menu_btn", Window.WIDTH/2 - 125, Window.HEIGHT/2 + 50, new ClickListener() {
			@Override
			public void onClick() {
				// pengaturan
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
	}
}