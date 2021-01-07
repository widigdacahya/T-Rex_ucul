# ☕️ CreditPage Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai screen untuk menampilkan profil dari pembuat permainan ini.
Dalam profil tersebut terdapat data nama, NRP, dan username github masing-masing kreator.

### 💡Atribut dan Fungsi:
Ada 2 atribut:   
- titleCredit: judul dari screen ini.
- backButton: tombol kembali.

Ada 2 jenis fungsi:   
- Konstruktor: CreditPage.
- Update dan render objek: update dan render.

****

```java
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
```