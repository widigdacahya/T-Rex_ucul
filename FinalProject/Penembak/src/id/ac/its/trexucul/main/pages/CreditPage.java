package id.ac.its.trexucul.main.pages;

import java.awt.Graphics;
import java.awt.Image;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class CreditPage extends PageState{
	
	private Image titleCredit = Assets.getImageAssetGen("penembak_credit.png");
	private CommonButton backButton;
	
	public CreditPage(Window window) {
		super(window);
		
		
		Assets.width = 177;
		Assets.height = 45;
		backButton = new CommonButton("kembali_black_btn", 50, 620, new ClickListener() {
			@Override
			public void onClick() {
				//Go to menu
				PageState.currentState = window.getMenuPage();
			}
		}, 239, 52);
		
		
	}

	@Override
	public void update() {
		backButton.update();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.creditPage, 0, 0, null);
		g.drawImage(titleCredit, 0, 0, null);
		backButton.render(g);
		
	}

}
