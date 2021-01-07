# ☕️ CommonButton Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai komponen permainan untuk menampilkan tombol dengan assets yang telah dibuat sebelumnya.
Kelas ini digunakan hampir di keseluruhan screen untuk mnanangani input tombol.
Mulai dari tombol main, skor, credits, kembali, keluar, dan coba lagi.

### 💡Atribut dan Fungsi:
Ada 8 atribut:   
- btnName: sebagai nama aset.
- x dan y: sebagai posisi.
- bounds: sebagai batas bidang.
- hovering: status pointer ketika sedang diatasnya.
- click: menangani pemanggilan fungsi ketika kompnen diklik.
- btn: gambar dari komponen.
- btnHov: gambar dari komponen ketika pointer sedang diatasnya.

Ada 4 jenis fungsi:
- Konstruktor: CommonButton.
- Inisiasi gambar komponen: initBtn.
- Update dan render komponen: update dan render.
- Getter dan Setter: getX, getY, setX, dan setY.

****

```java
public class CommonButton {
	
	protected String btnName;
	private int x, y;
	private Rectangle bounds;
	private boolean hovering;
	private ClickListener click;
	
	protected Image btn;
	protected Image btnHov;
	
	public CommonButton(String name, int x, int y, ClickListener click) {
		this.btnName = name;
		this.x = x;
		this.y = y;
		this.click = click;
		hovering = false;
		initBtn();
	}
	
	public CommonButton(String name, int x, int y, ClickListener click, int w, int h) {
		this.btnName = name;
		this.x = x;
		this.y = y;
		this.click = click;
		hovering = false;
		initBtn(w, h);
	}
	
	private void initBtn() {
		btn = Assets.getImageBtn(btnName + ".png");
		btnHov = Assets.getImageBtn(btnName + "_hov.png");
	}
	
	private void initBtn(int width, int height) {
		btn = Assets.getImageBtn(btnName + ".png", width, height);
		btnHov = Assets.getImageBtn(btnName + "_hov.png", width, height);
	}
	
	public void update(){
		int addition = 0;
		
		if (PageState.currentState instanceof GamePage)
			addition = this.x-60;
		
		if(bounds != null && bounds.contains(MouseHandler.x+addition, MouseHandler.y)) {
			hovering = true;
			if(MouseHandler.leftBtn) {
				click.onClick();
				MouseHandler.leftBtn = false;
			}	
		} else
			hovering = false;
	}
	
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(btnHov, this.x, this.y, null);
			bounds = new Rectangle(this.x, this.y, btnHov.getWidth(null), btnHov.getHeight(null));
		} else {
			g.drawImage(btn, this.x, this.y, null);
			bounds = new Rectangle(this.x, this.y, btn.getWidth(null), btn.getHeight(null));
		}
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