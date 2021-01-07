# ☕️ GameOverPage Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai screen yang ditampilkan ketika pemain gagal untuk memenangkan permainan.
Dalam screen ini hanya ada tombol untuk coba lagi dan keluar dari aplikasi.

### 💡Atribut dan Fungsi:
Ada 2 atribut:   
- gameOverText: judul dari screen ini.
- buttons: tombol coba lagi dan keluar.

Ada 2 jenis fungsi:   
- Konstruktor: GameOverPage.
- Update dan render objek: update dan render.

****

```java
public class GameOverPage extends PageState {
	
	private Image gameOverText = Assets.getImageText("gameOver.png", 481, 87);
	protected ArrayList<CommonButton> buttons  = new ArrayList<CommonButton>();

	public GameOverPage(Window window) {
		super(window);
		
		Assets.width = 177;
		Assets.height = 45;
		buttons.add(new CommonButton("coba_lagi_btn", Window.WIDTH/2 - 399, Window.HEIGHT/2 - 45, new ClickListener() {
			@Override
			public void onClick() {
				//Go to Level Page
				PageState.currentState = window.getLevelPage();
			}
		}, 237, 91));
		buttons.add(new CommonButton("keluar_btn", Window.WIDTH/2 + 161, Window.HEIGHT/2 - 45, new ClickListener() {
			@Override
			public void onClick() {
				// Exit game
				System.exit(1);
			}
		}, 237, 91));
	}

	@Override
	public void update() {
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameOverPage, 0, 0, null);
		g.drawImage(gameOverText, 399, 130, null);
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).render(g);
	}
}
```