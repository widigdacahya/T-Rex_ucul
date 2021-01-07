# ☕️ KeyboardHandler Class

****
### 💡Penjelasan:
Kelas ini berfungsi untuk memudahkan dalam penanganan input keyboard apakah ditekan atau tidak.
dan untuk membatasi karakter yang diinputkan

### 💡Atribut dan Fungsi:
Ada 9 atribut:   
- keys
- UP
- LEFT
- RIGHT
- DOWN
- SPACE
- BACK_SPACE
- keyListener

Ada 7 jenis fungsi:
- KeyboardHandler: konstructor.
- update: mengecek apakah tombol-tombol diatribut apakah ditekan
- keyPressed: fungsi yang membuat flag pada tombol yang ditekan menjadi true yang akan dicek pada update
- keyReleased: fungsi yang membuat flag pada tombol yang ditekan menjadi false yang akan dicek pada update
- keyTyped: memasukkan huruf yang sudah divalidate ke dalam input
- validateKeyInput: memvalidasi apakah char yang ditekan diperbolehkan untuk input
- setKeyListener: value char dari tombol yang ditekan ditangkap oleh fungsi ini.

****
```java
package id.ac.its.trexucul.utils.handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import id.ac.its.trexucul.main.pages.PageState;
import id.ac.its.trexucul.main.pages.VictoryPage;
import id.ac.its.trexucul.utils.listener.KeyTypedListener;

public class KeyboardHandler implements KeyListener {
	
	private boolean[] keys;
	
	public static boolean UP;
	public static boolean LEFT;
	public static boolean RIGHT;
	public static boolean DOWN;
	public static boolean SPACE;
	public static boolean ENTER;
	public static boolean BACK_SPACE;
	
	private KeyTypedListener keyListener;
	
	public KeyboardHandler() {
		keys = new boolean[256];
		UP = false;
		DOWN = false;
		RIGHT = false;
		LEFT = false;
		SPACE = false;
		ENTER = false;
		BACK_SPACE = false;
	}
	
	public void update() {
		UP = keys[KeyEvent.VK_UP];
		LEFT = keys[KeyEvent.VK_LEFT];
		RIGHT = keys[KeyEvent.VK_RIGHT];
		DOWN = keys[KeyEvent.VK_DOWN];
		SPACE = keys[KeyEvent.VK_SPACE];
		ENTER = keys[KeyEvent.VK_ENTER];
		BACK_SPACE = keys[KeyEvent.VK_BACK_SPACE];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
//		if (PageState.currentState instanceof VictoryPage) {
//			if (!BACK_SPACE) {
//				keyListener.keyInput(e);
//			}
//		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (PageState.currentState instanceof VictoryPage) {
			if (validateKeyInput((int)e.getKeyChar())) {
				keyListener.keyInput(e);
			}
		}
	}
	
	private boolean validateKeyInput(int ascii) {
		return (ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122) ||
				ascii == 95 || (ascii >= 48 && ascii <= 57) || ascii == 32;
	}
	
	public void setKeyListener(KeyTypedListener keyListener) {
		this.keyListener = keyListener;
	}
}
```
