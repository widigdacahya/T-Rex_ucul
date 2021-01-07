# ☕️ EnemyBullet Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai objek permainan untuk menampilkan peluru dari senjata enemy.
Kelas ini merupakan class yang diturunkan dari kelas Bullet.
Kelas ini digunakan dalam Game Screen, kelas ini memanggil fungsi dari parent classnya.

### 💡Atribut dan Fungsi:
Ada 3 jenis fungsi:
- Konstruktor: EnemyBullet.
- Update dan render objek: update dan render.
- Getter dan Setter: getBounds.

****

```java
public class EnemyBullet extends Bullet {
	
	public EnemyBullet(String name, int x, int y) {
		super(name, x, y, -50.0f);
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
	}

	@Override
	public Rectangle getBounds() {
		return super.getBounds();
	}
}
```