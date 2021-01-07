# ☕️ Score Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai kelas pembantu penyusunan data dalam penulisan data terkait score ke dalam file.
Dalam kelas ini hanay berisi variabel dari setiap data.

### 💡Atribut dan Fungsi:
Ada 2 atribut:   
- score: skor.
- playerName: nama pemain.

Ada 2 jenis fungsi:   
- Konstruktor: Score.
- Getter dan setter: getScore, setScore, getPlayerName dan setPlayerName.

****

```java
public class Score implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int score;
	private String playerName;
	
	public Score() {
		this(0, "");
	}
	
	public Score(int score, String playerName) {
		this.score = score;
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}	
}
```