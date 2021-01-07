# ☕️ ScorePage Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai screen yang berisi data capaian permainan berupa score setiap level.
Dalam representasinya, screen ini menampilkan data capaian dalam 5 tertinggi pada masing-masing level.
Setiap data akan dilengakpi dengan nama dan score yang dicapai.

### 💡Atribut dan Fungsi:
Ada 3 atribut:   
- scoreList: list yang berisi data yang akan ditampilkan.
- level1IO: data yang ada pada level 1.
- level2IO: data yang ada pada level 2.
- level3IO: data yang ada pada level 3.
- backBtn: tombol kembali.
- font: tipe font teks.
- textPos: posis dari data score yang akan ditampilkan.

Ada 3 jenis fungsi:   
- Konstruktor: ScorePage.
- Inisiasi objek: initList.
- Update dan render objek: update, painScore, dan render.

****

```java
public class ScorePage extends PageState {
	
	private ArrayList<ArrayList<Score>> scoreList = new ArrayList<ArrayList<Score>>();

	private ScoreSerialIO level1IO;
	private ScoreSerialIO level2IO;
	private ScoreSerialIO level3IO;
	private CommonButton backBtn;
	
	private Font font = FontLoader.loadFont("res/fonts/Russo_One.ttf", 18);
	private int[][] textPos = {
			{149, 310}, {538, 310}, {931, 310}
	};

	public ScorePage(Window window) {
		super(window);
		
		//mengubah ukuran tombol main
		Assets.width = 113;
		Assets.height = 43;
		
		//kembali
		backBtn = new CommonButton("kembali_btn", 10, 630, new ClickListener() {
			@Override
			public void onClick() {
				PageState.currentState = window.getMenuPage();
			}
		}, 239, 52);
		
		level1IO = new ScoreSerialIO(SelectedGamePage.Satu);
		level2IO = new ScoreSerialIO(SelectedGamePage.Dua);
		level3IO = new ScoreSerialIO(SelectedGamePage.Tiga);
	}

	@Override
	public void update() {
		backBtn.update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.scoreBG, 0, 0, null);
		backBtn.render(g);
		paintScore(g);
	}
	
	public void initList() {
		if (scoreList.size() > 0)
			scoreList.clear();
		scoreList.add(level1IO.getRecords());
		scoreList.add(level2IO.getRecords());
		scoreList.add(level3IO.getRecords());
	}
	
	private void paintScore(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(font);
		
		int index = 0;
		for(ArrayList<Score> scoreL : scoreList) {
			int posAdd = 0;
			
			String text = String.format("%-20s", "Nama");
			g.drawString(text, textPos[index][0], textPos[index][1]+posAdd);
			for(int i = 0; i < scoreL.size(); i++) {
				posAdd += 40;
				text = String.format("%-20s", scoreL.get(i).getPlayerName());
				g.drawString(text, textPos[index][0], textPos[index][1]+posAdd);
			}
			
			posAdd = 0;
			text = String.format("%s", "Score");
			g.drawString(text, textPos[index][0]+127, textPos[index][1]+posAdd);
			for(int i = 0; i < scoreL.size(); i++) {
				posAdd += 40;
				text = String.format("%s", scoreL.get(i).getScore());
				g.drawString(text, textPos[index][0]+127, textPos[index][1]+posAdd);
			}
			
			index++;
		}
	}
}
```