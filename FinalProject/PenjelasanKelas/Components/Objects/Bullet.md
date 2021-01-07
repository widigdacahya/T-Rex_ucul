# ☕️ Bullet Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai objek permainan untuk menampilkan peluru dari senjata.
Kelas ini merupakan parent class yang nantinya akan diturunkan kepada kelas PlayerBullet dan EnemyBullet.
Kelas ini digunakan dalam Game Screen, selain itu kelas ini juga mengatur pergerakan peluru.
Mulai dari mengambil gambar peluru dari aset hingga mentukan posisi dan kecepatan geraknya.

### 💡Atribut dan Fungsi:
Ada 7 atribut:   
- imgName: nama gambar objek.
- x, y; posisi objek.
- velX: kecepatan objek.
- bounds: batas bidang objek.
- visible: visibilitas objek.
- bulletImg: gambar objek.

Ada 4 jenis fungsi:
- Konstruktor: Bullet.
- Inisiasi gambar objek: initBullet.
- Update dan render objek: update dan render.
- Getter dan Setter: getX, getY, getBounds, getVisible, isVisible, setX, dan setY.

****

```java
public class Bullet {
	
	protected String imgName;
	protected int x, y;
	protected float velX;
	protected Rectangle bounds;
	public boolean visible;
	protected Image bulletImg;
	
	public Bullet(String name, int x, int y, float velX) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.visible = true;
		initBullet();
	}
	
	private void initBullet() {
		bulletImg = Assets.getImageBullet(imgName + ".png");
	}
	
	public void update(){
		x += velX;
	}
	
	public void render(Graphics g) {
		g.drawImage(bulletImg, this.x, this.y, null);
		bounds = new Rectangle(x, y, bulletImg.getWidth(null), bulletImg.getHeight(null));
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
```