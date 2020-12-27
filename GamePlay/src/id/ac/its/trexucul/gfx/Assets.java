package id.ac.its.trexucul.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
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
	public static Image gamepage1BG;
	public static Image gamepage2BG;
	public static Image gamepage3BG;
	public static Image gameOverPage;
	public static Image gameSplashPage;
	public static Image[] playerWalk = new Image[8];
	public static Image[] playerFire = new Image[5];
	public static Image[] playerWalkFire = new Image[5];
	
	public static Font fontSplash;
	
	public static void init() {
		menuBG = ImageLoader.loadImage("res/menu/menu_bg.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		levelBG = ImageLoader.loadImage("res/menu/LevelPage.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		
//		mainMenuBtn = ImageLoader.loadImage("/menu/main_menu_btn.png");
//		pengaturanMenuBtn = ImageLoader.loadImage("/menu/pengaturan_menu_btn.png");
//		mainMenuBtnHov = ImageLoader.loadImage("/menu/main_menu_btn_hov.png");
//		pengaturanMenuBtnHov = ImageLoader.loadImage("/menu/pengaturan_menu_btn_hov.png");
		
		gamepage1BG = ImageLoader.loadImage("res/menu/map1.png").getScaledInstance(4370, 720, BufferedImage.SCALE_DEFAULT);
		gamepage2BG = ImageLoader.loadImage("res/menu/map2.png").getScaledInstance(4370, 720, BufferedImage.SCALE_DEFAULT);
		gamepage3BG = ImageLoader.loadImage("res/menu/map3.png").getScaledInstance(4370, 720, BufferedImage.SCALE_DEFAULT);
		gameOverPage = ImageLoader.loadImage("res/menu/bggameover.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		gameSplashPage = ImageLoader.loadImage("res/menu/bgsplash.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		
		fontSplash = loadFont("res/fonts/Russo_One.ttf", 32);
	}
	
	public static Image getImageBtn(String imgName) {
		return ImageLoader.loadImage("res/button/" + imgName).getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageText(String imgName) {
		return ImageLoader.loadImage("res/asset/" + imgName).getScaledInstance(481, 87, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageAssetGen(String imgName) {
		return ImageLoader.loadImage("res/asset/" + imgName).getScaledInstance(1280, 720, BufferedImage.SCALE_DEFAULT);
	}
	
	
	public static Image getImagePlayer(String imgObject) {
		return ImageLoader.loadImage("res/asset/" + imgObject).getScaledInstance(60, 130, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image[] getImagePlayerWalk() {
		
		playerWalk[0] = ImageLoader.loadImage("res/asset/Player/" + "walk 1.png");
		playerWalk[1] = ImageLoader.loadImage("res/asset/Player/" + "walk 2.png");
		playerWalk[2] = ImageLoader.loadImage("res/asset/Player/" + "walk 3.png");
		playerWalk[3] = ImageLoader.loadImage("res/asset/Player/" + "walk 4.png");
		playerWalk[4] = ImageLoader.loadImage("res/asset/Player/" + "walk 5.png");
		playerWalk[5] = ImageLoader.loadImage("res/asset/Player/" + "walk 6.png");
		playerWalk[6] = ImageLoader.loadImage("res/asset/Player/" + "walk 7.png");
		playerWalk[7] = ImageLoader.loadImage("res/asset/Player/" + "walk 8.png");

		
		return playerWalk;
	}
	
	public static Image[] getImagePlayerFire() {
		
		playerFire[0] = ImageLoader.loadImage("res/asset/Player/" + "firing1.png");
		playerFire[1] = ImageLoader.loadImage("res/asset/Player/" + "firing2.png");
		playerFire[2] = ImageLoader.loadImage("res/asset/Player/" + "firing3.png");
		playerFire[3] = ImageLoader.loadImage("res/asset/Player/" + "firing4.png");
		playerFire[4] = ImageLoader.loadImage("res/asset/Player/" + "firing5.png");
		
		return playerFire;
	}
	
	public static Image[] getImagePlayerWalkFire() {
		
		playerFire[0] = ImageLoader.loadImage("res/asset/Player/" + "walk shooting 1.png");
		playerFire[1] = ImageLoader.loadImage("res/asset/Player/" + "walk shooting 2.png");
		playerFire[2] = ImageLoader.loadImage("res/asset/Player/" + "walk shooting 3.png");
		playerFire[3] = ImageLoader.loadImage("res/asset/Player/" + "walk shooting 4.png");
		playerFire[4] = ImageLoader.loadImage("res/asset/Player/" + "walk shooting 5.png");
		
		return playerFire;
	}
	
	
	
	public static Image getImageEnemy(String imgObject) {
		return ImageLoader.loadImage("res/asset/" + imgObject).getScaledInstance(94, 132, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageBullet(String imgObject) {
		return ImageLoader.loadImage("res/asset/" + imgObject).getScaledInstance(80, 4, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getGround(String imgObject) {
		return ImageLoader.loadImage("res/menu/" + imgObject).getScaledInstance(4370, 56, BufferedImage.SCALE_DEFAULT);
	}
		
	public static Font loadFont(String path, int size){
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
