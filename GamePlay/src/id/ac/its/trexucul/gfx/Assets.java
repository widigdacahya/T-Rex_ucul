package id.ac.its.trexucul.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.ImageLoader;

public class Assets {
	
	public static Image menuBG;
	public static Image levelBG;
	
	public static Image mainMenuBtn;
	public static Image pengaturanMenuBtn;
	public static Image mainMenuBtnHov;
	public static Image pengaturanMenuBtnHov;
	public static Image kembaliBtn;
	public static int width = 250, height = 80;
	public static Image gamepageBG;
	
	public static void init() {
		menuBG = ImageLoader.loadImage("res/menu/menu_bg.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		levelBG = ImageLoader.loadImage("res/menu/LevelPage.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		
//		mainMenuBtn = ImageLoader.loadImage("/menu/main_menu_btn.png");
//		pengaturanMenuBtn = ImageLoader.loadImage("/menu/pengaturan_menu_btn.png");
//		mainMenuBtnHov = ImageLoader.loadImage("/menu/main_menu_btn_hov.png");
//		pengaturanMenuBtnHov = ImageLoader.loadImage("/menu/pengaturan_menu_btn_hov.png");
		
		gamepageBG = ImageLoader.loadImage("res/menu/game_bg.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageBtn(String imgName) {
		return ImageLoader.loadImage("res/button/" + imgName).getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT);
	}
	
	
	public static Image getImagePlayer(String imgObject) {
		return ImageLoader.loadImage("res/asset/" + imgObject).getScaledInstance(121, 130, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageEnemy(String imgObject) {
		return ImageLoader.loadImage("res/asset/" + imgObject).getScaledInstance(94, 132, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageBullet(String imgObject) {
		return ImageLoader.loadImage("res/asset/" + imgObject).getScaledInstance(80, 4, BufferedImage.SCALE_DEFAULT);
	}
	
	
}
