# ☕️ SecondsTimer Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai timer yang mempunyai format detik saat deklarasinya.

### 💡Atribut dan Fungsi:
Ada 4 atribut:   
- startTime.
- currentTime: waktu saat fungsi finishCounting dipanggil
- timeSec: waktu saat fungsi finishCounting dipanggil dalam format detik
- counter: durasi delay yang diinginkan.

Ada 2 jenis fungsi:
- konstruktor: inisiasi cooldown/delay yang diinginkan.
- finishCounting: mengecek apakah timer selesai menghitung mundur waktu yang telah dideklarasikan

****
```java
package id.ac.its.trexucul.utils.helper;

public class SecondsTimer {
	
	private Long startTime = 0l;
	private Long currentTime = 0l;
	private float timeSec = 0;
	private float counter;
	
	public SecondsTimer(float delay) {
		this.counter = delay;
		startTime = System.currentTimeMillis();
	}
	
	public boolean finishCounting() {
		
		currentTime = System.currentTimeMillis() - startTime;
		timeSec = currentTime.floatValue()/1000;
		
		if (counter - timeSec < 0) {
			startTime = System.currentTimeMillis();
			return true;
		}
		
		return false;
	}
	
}
```
