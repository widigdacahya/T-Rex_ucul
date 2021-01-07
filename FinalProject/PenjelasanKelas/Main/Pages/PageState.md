# ☕️ PageState Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai pembantu jendela untuk menentukan screen yang akan ditampilkan.
Kelas ini merupakan abstract class yang nantinya akan diturunkan menjadi beberapa kelas screen.
Jadi, kelas ini akan menjadi pembantu navigasi utama antar screen dalam permainan.

### 💡Atribut dan Fungsi:
Terdapat 1 atribut static, currentState, untuk menyimpan screen yang akan ditampilkan, dan satu atribut protected, 
window, atribut yang nantinya digunakan screen untuk menaruh komponennya pada jendela.
Kemudian untuk fungsinya ada 3, konstruktor PageState, 2 lainnya merupakan fungsi abstract, update dan render, 
yang merupakan fungsi utama dalam update dan menggambar komponen screen ke dalam jendela.

****

```java
public abstract class PageState {
	
	public static PageState currentState = null;
	
	protected Window window;
	
	public PageState(Window window){
		this.window = window;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
}
```