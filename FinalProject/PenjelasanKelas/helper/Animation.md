# ☕️ Animation Class

****
### 💡Penjelasan:
Kelas ini berfungsi untuk mengirim gambar yang akan dirender.
Dari beberapa asset gambar, kelas ini akan menentukan urutan
gambar yang akan dikirim ke fungsi render nantinya.

### 💡Atribut dan Fungsi:
Ada 6 atribut:   
- speed: variable yang menentukan kecepatan pergantian frame.
- frames: jumlah frame yang tersedia.
- index: frame saat ini yang dikirim ke render.
- count: iterator frame
- images: animasi atau sekumpulan foto yang akan dirender
- currentImg: foto yang sedang dirender

Ada 4 jenis fungsi:
- konstruktor: memerlukan speed dan foto animasi.
- runAnimation: fungsi yang menjalankan animasi.
- nextFrame: fungsi yang menunjuk foto yang akan dirender
- drawAnimation: menggambar gambar yang telah ditentukan

****
```java
package id.ac.its.trexucul.utils.helper;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {
	protected int speed;
	protected int frames;
	
	protected int index = 0;
	protected int count = 0;
	
	protected BufferedImage[] images;
	protected BufferedImage currentImg;
	
	public Animation(int speed, BufferedImage... args) {
		this.speed = speed;
		images = new BufferedImage[args.length];
		 
		for(int i = 0; i < args.length; i++) {
			images[i] = args[i];
		}
		frames = args.length;
	}
	
	public void runAnimation() {
		index++;
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	}
	
	protected void nextFrame() {
		for (int i = 0; i < frames; i++) {
			if (count == i) {
				currentImg = images[i];
			}
		}
		
		count++;
		
		if (count > frames) 
			count = 0;
	}
	
	public void drawAnimation(Graphics g, int x, int y) {
		g.drawImage(currentImg, x, y, null);
	}
	
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
		g.drawImage(currentImg, x, y, scaleX, scaleY, null);
	}
}
```
