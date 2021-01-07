# ☕️ MenuPage Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai screen yang berisi menu utama permainan.
Menu-menu pada kelas ini terdiri dari menu Main, Skor, dan Credit.
Masing-masing menu akan mengarah pada screen yang sesuai.

### 💡Atribut dan Fungsi:
Ada 2 atribut:   
- btns: objek tombol untuk setiap menu.
- titleGameMenu: gambar untuk judul dari permainan yang ada pada tampilan utama.

Ada 2 jenis fungsi:
- Konstruktor: MenuPage.
- Update dan render objek: update dan render.

****

```java
public class MenuPage extends PageState {
	
	private ArrayList<CommonButton> btns  = new ArrayList<CommonButton>();
	private Image titleGameMenu = Assets.getImageAssetGen("titledimenuya.png");

	public MenuPage(Window window) {
		super(window);
		
		btns.add(new CommonButton("main_btn", Window.WIDTH/2 - 136, Window.HEIGHT/2 - 135, new ClickListener() {
			@Override
			public void onClick() {
				// Level Page
				PageState.currentState = window.getLevelPage();
			}
		}, 273, 104));
		btns.add(new CommonButton("skor_btn", Window.WIDTH/2 - 136, Window.HEIGHT/2 - 2, new ClickListener() {
			@Override
			public void onClick() {
				// score
				PageState.currentState = window.getScorePage();
			}
		}, 273, 104));
		btns.add(new CommonButton("credit_btn", Window.WIDTH/2 - 136, Window.HEIGHT/2 + 131 , new ClickListener() {
			@Override
			public void onClick() {
				// go to credit screen
				PageState.currentState = window.getCreditPage();
			}
		}, 273, 104));
	}

	@Override
	public void update() {
		for(int i = 0; i < btns.size(); i++)
			btns.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.menuBG, 0, 0, null);
		for(int i = 0; i < btns.size(); i++)
			btns.get(i).render(g);
		g.drawImage(titleGameMenu, 0, 0, null);
	}
}
```