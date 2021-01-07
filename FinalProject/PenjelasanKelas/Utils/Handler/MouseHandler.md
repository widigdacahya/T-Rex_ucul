# ☕️ MouseHandler Class

****
### 💡Penjelasan:
Kelas ini berfungsi untuk memudahkan dalam penanganan input mouse apakah ditekan atau tidak.

### 💡Atribut dan Fungsi:
Ada 4 atribut:   
- x: koordinat x pada saat ada event mouse
- y: koordinat y pada saat ada event mouse
- leftBtn
- rightBtn

Ada 5 jenis fungsi:
- MouseHandler: konstructor.
- mousePressed: fungsi yang membuat flag pada tombol mouse yang ditekan menjadi true yang akan dicek pada update
- mouseReleased: fungsi yang membuat flag pada tombol mouse yang ditekan menjadi false yang akan dicek pada update
- mouseDragged: fungsi yang memuat koordinat x dan y pada saat mouse dipress secara ditahan
- mouseMoved: fungsi yang memuat koordinat x dan y pada saat mouse digerakkan

****
```java
package id.ac.its.trexucul.utils.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
	
	public static int x;
	public static int y;
	public static boolean leftBtn;
	public static boolean rightBtn;
	
	public MouseHandler() {
		x = 0;
		y = 0;
	}

	@Override
	public void mousePressed(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1)
			leftBtn = true;
		if(e.getButton() == MouseEvent.BUTTON2)
			rightBtn= true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1)
			leftBtn = false;
		if(e.getButton() == MouseEvent.BUTTON2)
			rightBtn= false;
	}
	@Override
	public void mouseDragged(MouseEvent e){
		x = e.getX();
		y = e.getY();
	}
	@Override
	public void mouseMoved(MouseEvent e){
		x = e.getX();
		y = e.getY();
	}
}
```
