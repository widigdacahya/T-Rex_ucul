# ☕️ Text Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai kelas pembantu untuk menuliskan teks ke dalam kanvas.

### 💡Atribut dan Fungsi:
Hanya terdapat satu fungsi yaitu drawString, yaitu fungsi untu menggambarkan teks ke dalam kanvas.

****

```java
public class Text {
	
	public static void drawString(Graphics g, String text, int posX, int posY, boolean center, Color c) {
		
		g.setColor(c);
		int x = posX;
		int y = posY;
		FontMetrics fm = g.getFontMetrics();
		if(center) {
			x = x - fm.stringWidth(text)/2;
			y = (y - fm.getHeight()/2) + fm.getAscent();
		}
		
		g.drawString(text, x, y);
	}
}
```