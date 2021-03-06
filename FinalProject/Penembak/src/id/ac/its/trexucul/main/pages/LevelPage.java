package id.ac.its.trexucul.main.pages;

import java.awt.Graphics;
import java.util.ArrayList;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.handler.MouseHandler;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class LevelPage extends PageState {
	
	public static SelectedGamePage selectedPage;
	
	private ArrayList<CommonButton> btns  = new ArrayList<CommonButton>();

	public LevelPage(Window window) {
		super(window);
		
		//mengubah ukuran tombol main
		Assets.width = 113;
		Assets.height = 43;
		selectedPage = SelectedGamePage.Satu;
		
		//level 1
		btns.add(new CommonButton("main_btn", 194, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 1
				//window.setGamePage(new GamePage(window, SelectedGamePage.Satu));
				selectedPage = SelectedGamePage.Satu;
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getCharacterPage();
			}
		}));
		
		//level 2
		btns.add(new CommonButton("main_btn", 581, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 2
				//window.setGamePage(new GamePage(window, SelectedGamePage.Dua));
				selectedPage = SelectedGamePage.Dua;
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getCharacterPage();
			}
		}));
		
		//level 3
		btns.add(new CommonButton("main_btn", 968, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 3
				//window.setGamePage(new GamePage(window, SelectedGamePage.Tiga));
				selectedPage = SelectedGamePage.Tiga;
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getCharacterPage();
			}
		}));
		
		//kembali
		btns.add(new CommonButton("kembali_btn", 10, 630, new ClickListener() {
			@Override
			public void onClick() {
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getMenuPage();
			}
		}, 193, 42));
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
