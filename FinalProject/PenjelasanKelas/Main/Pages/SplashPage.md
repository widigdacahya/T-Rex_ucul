# ☕️ SplashPage Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai screen yang berisi tampilan pembuka permainan.
Pada kelas ini hanya terdapat keterangan kelompok penyusun permainan ini.

### 💡Atribut dan Fungsi:
Ada 2 atribut:   
- NAMA_KELOMPOK: nama kelompok.
- text: teks yang di-render ke screen.
- index: pembantu penentu teks yang di-render.
- time, lastTime: waktu penentu render teks.
- titleGame: gambar utama dari game yang ditampilkan di permainan.

Ada 2 jenis fungsi:   
- Konstruktor: SplashPage.
- Update dan render objek: update dan render.

****

```java
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
```