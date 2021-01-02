package id.ac.its.trexucul.main.pages;

import java.awt.Graphics;
import java.util.ArrayList;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class CharacterPage extends PageState{
	
	public static SelectedGamePage selectedCharacter;
	public static SelectedGamePage level;
	
	private ArrayList<CommonButton> btns  = new ArrayList<CommonButton>();

	public CharacterPage(Window window) {
		super(window);
		
		//mengubah ukuran tombol main
		Assets.width = 113;
		Assets.height = 43;
		selectedCharacter = SelectedGamePage.Satu;
		
		//level 1
		btns.add(new CommonButton("main_menu_btn", 194, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 1
				selectedCharacter = SelectedGamePage.Satu;
				window.setGamePage(new GamePage(window, LevelPage.selectedPage,  selectedCharacter));
				window.getGamePage().setCharacter(SelectedGamePage.Satu);
				window.getGamePage().getPlayer().setFireDamage(LevelPage.selectedPage);
				//GamePage.character = SelectedGamePage.Satu;
				PageState.currentState = window.getGamePage();
				
			}
		}));
		
		//level 2
		btns.add(new CommonButton("main_menu_btn", 581, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 2
				selectedCharacter = SelectedGamePage.Dua;
				window.setGamePage(new GamePage(window, LevelPage.selectedPage,  selectedCharacter));
				window.getGamePage().setCharacter(SelectedGamePage.Dua);
				window.getGamePage().getPlayer().setFireDamage(LevelPage.selectedPage);
				PageState.currentState = window.getGamePage();
				
			}
		}));
		
		//level 3
		btns.add(new CommonButton("main_menu_btn", 968, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 3
				selectedCharacter = SelectedGamePage.Tiga;
				window.setGamePage(new GamePage(window, LevelPage.selectedPage,  selectedCharacter));
				window.getGamePage().setCharacter(SelectedGamePage.Tiga);
				window.getGamePage().getPlayer().setFireDamage(LevelPage.selectedPage);
				PageState.currentState = window.getGamePage();
				
			}
		}));
		
		//kembali
		btns.add(new CommonButton("kembali", 11, 625, new ClickListener() {
			@Override
			public void onClick() {
				PageState.currentState = window.getLevelPage();
			}
		}));
	}
	
	public void setLevel(SelectedGamePage level) { 
		CharacterPage.level = level;
	}
	
	@Override
	public void update() {
		for(int i = 0; i < btns.size(); i++)
			btns.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.characterBG, 0, 0, null);
		for(int i = 0; i < btns.size(); i++)
			btns.get(i).render(g);
	}

}
