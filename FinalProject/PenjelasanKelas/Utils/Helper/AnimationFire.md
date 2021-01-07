# ☕️ AnimationFire Class

****
### 💡Penjelasan:
Kelas ini berfungsi untuk mengirim gambar yang akan dirender.
Dari beberapa asset gambar, kelas ini akan menentukan urutan
gambar yang akan dikirim ke fungsi render nantinya.

spesifiknya, fungsi ini merender animasi saat player menembak

### 💡Atribut dan Fungsi:
Ada 1 atribut:   
- timer: timer yang memberi interval agar animasi lebih sesuai FPSnya

Ada 2 jenis fungsi:
- konstruktor: memerlukan speed dan foto animasi.
- runAnimation: fungsi yang menjalankan animasi.

****
```java
package id.ac.its.trexucul.utils.helper;

import java.awt.image.BufferedImage;

public class AnimationFire extends Animation{
	
	private SecondsTimer timer = new SecondsTimer(0.3f);

	public AnimationFire(int speed, BufferedImage[] args) {
		super(speed, args);
	}
	
	@Override
	public void runAnimation() {
		
		if(timer.finishCounting()) {
			nextFrame();
			
		}
		
	}

}
```
