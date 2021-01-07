# ☕️ Camera Class

****
### 💡Penjelasan:
Kelas ini berfungsi untuk menentukan posisi kamera pada saat inGame.

### 💡Atribut dan Fungsi:
Ada 2 atribut:   
- x, y: posisi kamera
- MAX_BG_WIDTH: ukuran background.

Ada 4 jenis fungsi:
- konstruktor: inisiasi camera pada awal game.
- setter dan getter.
- update: mengatur letak kamera saat player bergerak.
- resetCameraPosition: untuk mereset posisi camera ke 0.

****
```java
package id.ac.its.trexucul.utils.helper;

import id.ac.its.trexucul.components.entities.Player;
import id.ac.its.trexucul.main.Window;

public class Camera {
	
	public float x,y;

	public static int MAX_BG_WIDTH = 4370;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void update(Player player) {
		if (player.getX() > Window.WIDTH/6 && player.getX() < MAX_BG_WIDTH-Window.WIDTH*5/6)
			x = -player.getX() + Window.WIDTH/6;
	}
	
	public void resetCameraPosition() {
		this.x = 0;
		this.y = 0;
	}
}
```
