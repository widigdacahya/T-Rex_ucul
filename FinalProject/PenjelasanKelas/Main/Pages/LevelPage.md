# ☕️ LevelPage Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai screen yang berisi pilihan level yang ingin dimainkan.
Terdapat 3 pilihan level, masing-masing level memiliki tingkat kesulitan yang bervariasi dan 
setiap level ketika dipilih akan mengarah pada screen penentuan karakter.

### 💡Atribut dan Fungsi:
Ada 2 atribut:   
- btns: objek tombol untuk setiap pilihan level.
- SelectedGamePage: atribut penanda level yang dipilih.

Ada 2 jenis fungsi:   
- Konstruktor: LevelPage.
- Update dan render objek: update dan render.

****

```java
public class LevelPage extends PageState {
	
	public static SelectedGamePage selectedPage;
	
	private ArrayList<CommonButton> btns  = new ArrayList<CommonButton>();

	public LevelPage(Window window) {
		super(window);
		
		//mengubah ukuran tombol main
		Assets.width = 113;
		Assets.height = 43;
		selectedPage = SelectedGamePage.Satu;
		
		//level 1
		btns.add(new CommonButton("main_btn", 194, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 1
				//window.setGamePage(new GamePage(window, SelectedGamePage.Satu));
				selectedPage = SelectedGamePage.Satu;
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getCharacterPage();
			}
		}));
		
		//level 2
		btns.add(new CommonButton("main_btn", 581, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 2
				//window.setGamePage(new GamePage(window, SelectedGamePage.Dua));
				selectedPage = SelectedGamePage.Dua;
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getCharacterPage();
			}
		}));
		
		//level 3
		btns.add(new CommonButton("main_btn", 968, 525, new ClickListener() {
			@Override
			public void onClick() {
				// Level 3
				//window.setGamePage(new GamePage(window, SelectedGamePage.Tiga));
				selectedPage = SelectedGamePage.Tiga;
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getCharacterPage();
			}
		}));
		
		//kembali
		btns.add(new CommonButton("kembali_btn", 10, 630, new ClickListener() {
			@Override
			public void onClick() {
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getMenuPage();
			}
		}, 239, 52));
	}

	@Override
	public void update() {
		for(int i = 0; i < btns.size(); i++)
			btns.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.levelBG, 0, 0, null);
		for(int i = 0; i < btns.size(); i++)
			btns.get(i).render(g);
	}
}
```