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
//		btns.add(new CommonButton("main_menu", Window.WIDTH/2, Window.HEIGHT/2 - 25, new ClickListener() {
//			@Override
//			public void onClick() {
//				// Level
//			}
//		}));
//		btns.add(new CommonButton("pengaturan_menu", Window.WIDTH/2, Window.HEIGHT/2 - 25, new ClickListener() {
//			@Override
//			public void onClick() {
//				// pengaturan
//			}
//		}));
	}

	@Override
	public void update() {
//		for(int i = 0; i < btns.size(); i++)
//			btns.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.menuBG, 0, 0, null);
//		for(int i = 0; i < btns.size(); i++)
//			btns.get(i).render(g);
	}
}
