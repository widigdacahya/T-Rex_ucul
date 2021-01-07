# ☕️ Assets Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai kelas untuk mengambil asset dari folder yang sudah disediakan. 
Kelas ini merupakan sumber dari segala asset yang digunakan dalam permainan. 
Kelas ini akan dipanggil setiap pengamnbilan asset dibutuhkan.

### 💡Atribut dan Fungsi:
Ada 3 atribut:   
- menuBG: gambar latar belakang untuk menu screen.
- levelBG: gambar latar belakang untuk level screen.
- mainMenuBtn: gambar untuk tombol main.
- pengaturanMenuBtn: gambar untuk tombol pengaturan.
- mainMenuBtnHov: gambar untuk tombol main ketika disentuh.
- pengaturanMenuBtnHov: gambar untuk tombol pengaturan ketika disentuh.
- kembaliBtn: gambar untuk tombol kemnbali.
- width, height: ukuran tombol.
- gamepage1BG: gambar latar belakang untuk game screen 1.
- gamepage2BG: gambar latar belakang untuk game screen 2.
- gamepage3BG: gambar latar belakang untuk game screen 3.
- characterBG: gambar latar belakang untuk character screen.
- scoreBG: gambar latar belakang untuk score screen.
- gameOverPage: gambar latar belakang untuk gameover screen.
- gameSplashPage: gambar latar belakang untuk splash screen.
- creditPage: gambar latar belakang untuk splash screen.
- playerWalk: gambar untuk animasi bergerak.
- playerFire: gambar untuk animasi menembak.
- playerWalkFire: gambar untuk animasi bergerak dan menembak.
- sniperWalk: gambar untuk animasi sniper bergerak.
- sniperFire: gambar untuk animasi sniper menembak.
- sniperWalkFire: gambar untuk animasi sniper bergerak dan menembak.

Ada 2 jenis fungsi:   
- Inisiasi gambar: init.
- Getter gambar: getImageBtn, getImageText, getImagePlayer, getImagePlayerWalkFire, getImageSniperFire2, dan lain-lain.

****

```java
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
	public static Image characterBG;
	public static Image scoreBG;
	public static Image gameOverPage;
	public static Image gameSplashPage;
	public static Image creditPage;
	public static Image[] playerWalk = new Image[8];
	public static Image[] playerFire = new Image[5];
	public static Image[] playerWalkFire = new Image[5];
	public static Image[] sniperWalk = new Image[17];
	public static Image[] sniperFire = new Image[15];
	public static Image[] sniperWalkFire = new Image[15];
	
	public static Font fontSplash;
	
	public static void init() {
		menuBG = ImageLoader.loadImage("res/menu/menu_bg.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		levelBG = ImageLoader.loadImage("res/menu/LevelPage.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		
		gamepage1BG = ImageLoader.loadImage("res/menu/map1.png").getScaledInstance(4370, 720, BufferedImage.SCALE_DEFAULT);
		gamepage2BG = ImageLoader.loadImage("res/menu/map2.png").getScaledInstance(4370, 720, BufferedImage.SCALE_DEFAULT);
		gamepage3BG = ImageLoader.loadImage("res/menu/map3.png").getScaledInstance(4370, 720, BufferedImage.SCALE_DEFAULT);
		gameOverPage = ImageLoader.loadImage("res/menu/bggameover.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		gameSplashPage = ImageLoader.loadImage("res/menu/bgsplash.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		creditPage = ImageLoader.loadImage("res/menu/creditbg.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		characterBG = ImageLoader.loadImage("res/menu/CharacterPage.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		scoreBG = ImageLoader.loadImage("res/menu/ScorePage.png").getScaledInstance(Window.WIDTH, Window.HEIGHT, BufferedImage.SCALE_DEFAULT);
		
		fontSplash = FontLoader.loadFont("res/fonts/Russo_One.ttf", 32);
	}
	
	public static Image getImageBtn(String imgName) {
		return ImageLoader.loadImage("res/button/" + imgName).getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageBtn(String imgName, int w, int h) {
		return ImageLoader.loadImage("res/button/" + imgName).getScaledInstance(w, h, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageText(String imgName) {
		return ImageLoader.loadImage("res/asset/" + imgName).getScaledInstance(481, 87, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageText(String imgName, int w, int h) {
		return ImageLoader.loadImage("res/asset/" + imgName).getScaledInstance(w, h, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageAssetGen(String imgName) {
		return ImageLoader.loadImage("res/asset/" + imgName).getScaledInstance(1280, 720, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImagePlayer(String imgObject) {
		return ImageLoader.loadImage("res/asset/" + imgObject).getScaledInstance(60, 130, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image getImageSniper(String imgObject) {
		return ImageLoader.loadImage("res/asset/SniperBlue/" + imgObject);
	}
	
	public static Image getImageSniper2(String imgObject) {
		return ImageLoader.loadImage("res/asset/SniperRed/" + imgObject);
	}
	
	public static Image[] getImagePlayerWalk() {
		
		for(int i = 0; i < 8; i++)
			playerWalk[i] = ImageLoader.loadImage("res/asset/Player/" + "walk/" + "walk " + (i+1) + ".png");
		
		return playerWalk;
	}
	
	public static Image[] getImagePlayerFire() {
		
		for(int i = 0; i < 5; i++)
			playerFire[i] = ImageLoader.loadImage("res/asset/Player/" + "firing/" +"firing" + (i+1) + ".png");
		
		return playerFire;
	}
	
	public static Image[] getImagePlayerWalkFire() {
		
		for(int i = 0; i < 5; i++)
			playerWalkFire[i] = ImageLoader.loadImage("res/asset/Player/" + "walkshoot/" + "walkshooting" + (i+1) + ".png");
		
		return playerFire;
	}
	
	public static Image[] getImageSniperWalk() {
		
		for(int i = 1; i <= 17; i++)
		sniperWalk[i-1] = ImageLoader.loadImage("res/asset/SniperBlue/walking/"+ i +".png");
		
		return sniperWalk;
	}
	
	public static Image[] getImageSniperFire() {
		
		for(int i = 1; i <= 15; i++)
			sniperFire[i-1] = ImageLoader.loadImage("res/asset/SniperBlue/shooting/" + i +".png");
		
		return sniperFire;
	}
	
	public static Image[] getImageSniperWalkFire() {
		
		for(int i = 1; i <= 15; i++)
			sniperWalkFire[i-1] = ImageLoader.loadImage("res/asset/SniperBlue/walking/" + i +".png");
		
		return sniperFire;
	}
	
	public static Image[] getImageSniperWalk2() {
		
		for(int i = 1; i <= 17; i++)
		sniperWalk[i-1] = ImageLoader.loadImage("res/asset/SniperRed/walking/"+ i +".png");
		
		return sniperWalk;
	}
	
	public static Image[] getImageSniperFire2() {
		
		for(int i = 1; i <= 15; i++)
			sniperFire[i-1] = ImageLoader.loadImage("res/asset/SniperRed/shooting/" + i +".png");
		
		return sniperFire;
	}
	
	public static Image[] getImageSniperWalkFire2() {
		
		for(int i = 1; i <= 15; i++)
			sniperWalkFire[i-1] = ImageLoader.loadImage("res/asset/SniperRed/walking/" + i +".png");
		
		return sniperFire;
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
}
```