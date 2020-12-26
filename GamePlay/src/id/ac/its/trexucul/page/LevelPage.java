package id.ac.its.trexucul.page;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.id.SelectedGamePage;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.ClickListener;
import id.ac.its.trexucul.util.PageState;

public class LevelPage extends PageState{
	
	public static SelectedGamePage selectedPage;
	
	private ArrayList<CommonButton> btns  = new ArrayList<CommonButton>();

	public LevelPage(Window window) {
		super(window);
		
		//mengubah ukuran tombol main
		Assets.width = 113;
		Assets.height = 43;
		selectedPage = SelectedGamePage.Satu;
		
		//level 1
		btns.add(new CommonButton("main_menu_btn", 194, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 1
				PageState.currentState = window.getGamePage1();
				selectedPage = SelectedGamePage.Satu;
			}
		}));
		
		//level 2
		btns.add(new CommonButton("main_menu_btn", 581, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 2
				PageState.currentState = window.getGamePage2();
				selectedPage = SelectedGamePage.Dua;
			}
		}));
		
		//level 3
		btns.add(new CommonButton("main_menu_btn", 968, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 3
				PageState.currentState = window.getGamePage3();
				selectedPage = SelectedGamePage.Tiga;
			}
		}));
		
		//kembali
		btns.add(new CommonButton("kembali", 11, 625, new ClickListener() {
			@Override
			public void onClick() {
				PageState.currentState = window.getMenuPage();
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
		g.drawImage(Assets.levelBG, 0, 0, null);
		for(int i = 0; i < btns.size(); i++)
			btns.get(i).render(g);
	}
}
