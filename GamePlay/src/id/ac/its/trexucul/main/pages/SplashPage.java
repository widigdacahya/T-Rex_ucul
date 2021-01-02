package id.ac.its.trexucul.main.pages;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.gfx.Text;

public class SplashPage extends PageState{
	
	private final String NAMA_KELOMPOK = "kelompok T-Rex Ucul ";
	private String text = "";
	private int index = 0;
	private long time, lastTime;
	private Image titleGame = Assets.getImageAssetGen("titlegameya.png");
		
	public SplashPage(Window window){
		super(window);
		time = 0;
		lastTime = System.currentTimeMillis();
	}

	@Override
	public void update() {
		
		time += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(time > 150) {
			
			text = NAMA_KELOMPOK.substring(0, index);
			if(index < NAMA_KELOMPOK.length()) {
				index ++;
			} else {
				try {
					Thread.sleep(1150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				PageState.currentState = window.getMenuPage();
			}
			time = 0;
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameSplashPage, 0, 0, null);
		g.setFont(Assets.fontSplash);
		Text.drawString(g, text, Window.WIDTH/2, (Window.HEIGHT/2)+64, true, Color.WHITE);
		g.drawImage(titleGame, 0, 0, null);
		
	}

}
