# ☕️ BulletListener interface 

****
### 💡Penjelasan:
Kelas atau interface ini berfungsi untuk abstraksi yang menangani input dari mouse.
Digunakan pada GamePage. Pada Player ditambahkan BulletListener ini, bila user melakukan
click pada mouse, maka akan memunculkan peluru dengan kecepatan tertentu. variable x dan y
pada fungsi tersebut digunakan untuk inisiasi posisi awal dari peluru sebelum bergerak atau
sesaat setelah diclick

### 💡Atribut dan Fungsi:

Ada 1 jenis fungsi:
- onClick: ClickEvent handling.

****
```java
  
package id.ac.its.trexucul.utils.listener;

public interface BulletListener {
	public abstract void onClick(int x, int y);
}
```
