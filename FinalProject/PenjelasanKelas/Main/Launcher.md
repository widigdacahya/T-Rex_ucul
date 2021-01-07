# ☕️ Launcher Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai peluncur dari permainan.
Kelas ini akan menginisialisasi kelas window kemudian memulainya dengan memanggil fungsi startnya.

### 💡Atribut dan Fungsi:
Hanya ada satu fungsi, yoitu fungsi main, fungsi yang akan dipanggil ketika program di-run.

****

```java
public class Launcher {
		
	public static void main(String[] args){
		Window game = new Window("New Game!");
		game.start();
	}
}
```