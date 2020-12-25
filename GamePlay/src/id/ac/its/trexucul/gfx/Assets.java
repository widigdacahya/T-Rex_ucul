package id.ac.its.trexucul.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;

import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.ImageLoader;

public class Assets {
	
	public static Image menuBG;
	public static Image mainMenuBtn;
	public static Image pengaturanMenuBtn;
	public static Image mainMenuBtnHov;
	public static Image pengaturanMenuBtnHov;
	
	public static void init() {
		menuBG = ImageLoader.loadImage("/menu/menu_bg.png").getScaledInstance(Window.HEIGHT, Window.WIDTH, BufferedImage.SCALE_DEFAULT);
		mainMenuBtn = ImageLoader.loadImage("/menu/main_menu_btn.png");
		pengaturanMenuBtn = ImageLoader.loadImage("/menu/pengaturan_menu_btn.png");
		mainMenuBtnHov = ImageLoader.loadImage("/menu/main_menu_btn_hov.png");
		pengaturanMenuBtnHov = ImageLoader.loadImage("/menu/pengaturan_menu_btn_hov.png");
	}
	
	public static Image getImageBtn(String imgName) {
		return ImageLoader.loadImage("/button/" + imgName);
	}
}
