# ☕️ Ground Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai objek permainan untuk menampilkan lantai dari permainan.
Kelas ini digunakan dalam Game Screen, objek ini tidak bergerak dan hanya menetap pada suatu posisi.

### 💡Atribut dan Fungsi:
Ada 7 atribut:   
- imgName: nama gambar objek.
- x, y; posisi objek.
- groundImg: gambar objek.

Ada 4 jenis fungsi:
- Konstruktor: Ground.
- Inisiasi gambar objek: initGround.
- Update dan render objek: render.
- Getter dan Setter: getBounds.

****

```java
public class Ground {
	
	private String imgName;
	private int x, y;
	
	protected static Image groundImg;
	
	public Ground(String name, int x, int y) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		initGround();
	}
	
	private void initGround() {
		groundImg = Assets.getGround(imgName + ".png");
	}
	
	public void update(){		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, groundImg.getWidth(null), groundImg.getHeight(null));
	}

	public void render(Graphics g) {
		g.drawImage(groundImg, this.x, this.y, null);
	}
}
```