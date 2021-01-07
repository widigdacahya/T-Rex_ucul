# ☕️ ScoreSerialIO Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai kelas untuk membantu penulisan data score pada file secara serial.
Kelas ini akan digunakan oleh setiap screen yang membutuhkan penulisan dan pembacaan data pada sebuah file serial.

### 💡Atribut dan Fungsi:
Ada 3 atribut:   
- fileName: nama dari serial file atau file penyimpan jumlah data.
- numData: jumlah data yang telah tertuliskan pada masing-masing level.
- indexNum: penanda file yang ingin diakses.

Ada 2 jenis fungsi:   
- Konstruktor: ScoreSerialIO.
- Operasi IO: addRecords dan getRecords.

****

```java
public class ScoreSerialIO {
	
	private String fileName;
	private int[] numData;
	private int indexNum;
	
	public ScoreSerialIO(SelectedGamePage type) {
		String fileName = null;
		if (type == SelectedGamePage.Satu) {
			fileName = "score_data_level_1.txt";
			indexNum = 0;
		} else if (type == SelectedGamePage.Dua) {
			fileName = "score_data_level_2.txt";
			indexNum = 1;
		} else if (type == SelectedGamePage.Tiga) {
			fileName = "score_data_level_3.txt";
			indexNum = 2;
		}
		
		this.fileName = fileName;
		this.numData = ReadIO.readNumData();
	}
	
	public void addRecord(Score data) {
		if (numData[indexNum] > 0) {
			ArrayList<Score> scoreList = ReadSerial.readRecords(fileName);
			
			if (scoreList != null) {
				if (scoreList.size() >= 5) {
					scoreList.add(data);
					Collections.sort(scoreList, new ScoreComparator());
					scoreList.remove(5);
				} else {
					scoreList.add(data);
					Collections.sort(scoreList, new ScoreComparator());
				}
			} else
				scoreList.add(data);
			
			WriteSerial.addRecords(scoreList, fileName);
			numData[indexNum] = scoreList.size();
		} else {
			ArrayList<Score> scoreList = new ArrayList<Score>();
			scoreList.add(data);
			WriteSerial.addRecords(scoreList, fileName);
			numData[indexNum]++;
		}
		
		WriteIO.writeNumData(numData);
	}
	
	public ArrayList<Score> getRecords() {
		ArrayList<Score> scoreList = new ArrayList<Score>();
		this.numData = ReadIO.readNumData();
		
		if (numData[indexNum] > 0) {
			scoreList = ReadSerial.readRecords(fileName);
		} else
			scoreList.add(new Score(0, ""));
		
		return scoreList;
	}
}
```