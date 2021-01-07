# ☕️ VictoryPage Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai screen yang ditampilkan ketika pemain berhasil memenangkan permainan.
Pada screen ini pemain akan diminta memasukkan namanya sebagai data yang akan disimpan pada capaian permainan.
Setelah pemain memasukkan nama maka akan ada pilihan untuk keluar game atau mencoba lagi permianan.

### 💡Atribut dan Fungsi:
Ada 11 atribut:   
- victoryText: teks utama ketika screen ini ditampilkan.
- buttons : tombol untuk keluar dam coba lagi.
- inputNameButton: tombol untuk memasukkan nama.
- textTyped: teks yang menyimpan input nama dari pemain.
- timer: waktu untuk membatasi penghapusan teks.
- finishInput: status input nama.
- label = label untuk memasukkan nama.
- input, inputLabel: font yang mengatur teks pada screen ini.
- score: data score dari permainan.
- scoreSerial: pembantu input data ke dalam file.

Ada 3 jenis fungsi:   
- Konstruktor: VictoryPage.
- Update dan render objek: update, updateTextTyped, paintInputText, method, dan render.
- Getter dan setter: setLevelType dan setScore.

****

```java
public class VictoryPage extends PageState{
	
	private Image victoryText = Assets.getImageText("victory.png", 721, 87);
	protected ArrayList<CommonButton> buttons  = new ArrayList<CommonButton>();
	private CommonButton inputNameButton;
	
	private String textTyped;
	private SecondsTimer timer;

	private boolean finishInput = false;
	private String label = "Masukkan nama Anda:";
	private Font input = FontLoader.loadFont("res/fonts/Russo_One.ttf", 28);
	private Font inputLabel = FontLoader.loadFont("res/fonts/Russo_One.ttf", 20);
	
	private int score = 0;
	private ScoreSerialIO scoreSerial;

	public VictoryPage(Window window) {
		super(window);

		buttons.add(new CommonButton("coba_lagi_btn", Window.WIDTH/2 - 399, Window.HEIGHT/2 - 45, new ClickListener() {
			@Override
			public void onClick() {
				//Go to Level Page
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getLevelPage();
			}
		}, 237, 91));
		buttons.add(new CommonButton("keluar_btn", Window.WIDTH/2 + 161, Window.HEIGHT/2 - 45, new ClickListener() {
			@Override
			public void onClick() {
				// Exit game
				MouseHandler.leftBtn = false;
				System.exit(1);
			}
		}, 237, 91));
		
		inputNameButton = new CommonButton("submit_name_btn", Window.WIDTH/2 - (185/2), Window.HEIGHT/2 + 20, new ClickListener() {
			@Override
			public void onClick() {
				finishInput = true;
				MouseHandler.leftBtn = false;
				scoreSerial.addRecord(new Score(score, textTyped));
			}
		}, 185, 76);
		
		textTyped = "";
		timer = new SecondsTimer(0.1f);
	}
	
	public void setLevelType(SelectedGamePage type) {
		finishInput = false;
		textTyped = "";
		scoreSerial = new ScoreSerialIO(type);
	}

	@Override
	public void update() {
		if(finishInput) {
			for(int i = 0; i < buttons.size(); i++)
				buttons.get(i).update();
		} else
			inputNameButton.update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameSplashPage, 0, 0, null);
		g.drawImage(victoryText, 280, 130, null);
		if(finishInput) {
			for(int i = 0; i < buttons.size(); i++)
				buttons.get(i).render(g);
		} else {
			inputNameButton.render(g);

			if(KeyboardHandler.BACK_SPACE && timer.finishCounting())
				textTyped = method(textTyped);
			
			paintInputText(g);
		}
	}
	
	public void paintInputText(Graphics g) {
		FontMetrics fm = g.getFontMetrics(input);
		FontMetrics fmL = g.getFontMetrics(inputLabel);
		
		String scoreText = "Skormu: " + this.score;
		
		g.setColor(Color.WHITE);
		g.setFont(inputLabel);
		g.drawString(label, Window.WIDTH/2 - (fmL.stringWidth(label)/2), Window.HEIGHT/2 - 32);
		g.setFont(input);
		g.drawString(scoreText, Window.WIDTH/2 - (fm.stringWidth(scoreText)/2), Window.HEIGHT/2 - 86);
		g.drawString(textTyped, Window.WIDTH/2 - (fm.stringWidth(textTyped)/2), Window.HEIGHT/2 + 4);
	}
	
	public void updateTextTyped(KeyEvent e) {
		if (!KeyboardHandler.BACK_SPACE && !finishInput)
			textTyped += e.getKeyChar();
	}
	
	public String method(String str) {
	    if (str != null && str.length() > 0) {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
```