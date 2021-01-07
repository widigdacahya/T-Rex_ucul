# ☕️ ScoreComparator Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai kelas untuk membandingkan score dalam fungsi pengurutan oleh java.

### 💡Atribut dan Fungsi:
Dalam kelas ini hanya ada satu fungsi yaoti compare untuk membantu komparasi dalam pengurutan data 
ketika ingin mendapatkan 5 score tertinggi.

****

```java
public class ScoreComparator implements Comparator<Score> {

	@Override
	public int compare(Score a, Score b) {
		return b.getScore() - a.getScore();
	}
}
```