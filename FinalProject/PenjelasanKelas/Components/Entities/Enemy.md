# ☕️ Enemy Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai onjek permainan untuk menampilkan musuh dari player.
Kelas ini digunakan dalam Game Screen, selain itu kelas ini juga mengatur pergerakan musuh.
Mulai dari mengambil gambar musuh dari aset, mengatur interval tembak, hingga mentukan posisi dan kecepatan geraknya.

### 💡Atribut dan Fungsi:
Ada 20 atribut:   
- imgName: gambar objek.
- x, y: posisi objek.
- velX, velY: kecepatan objek.
- fireDamage: dmaage tembakan objek.
- gravity: kecepatan gravitasi objek.
- falling, jumping: status objek pada y.
- MAX_SPEED: kecepatan maksimum objek.
- rand: nilai tambahan untuk damage tembakan objek.
- bt, jt, rt: pengatur delay.
- playerImg: gambar objek.
- visibility, included: status visibilitas objek.
- health: banyak HP objek.
- bullet:	peluru dari senjata objek.
- enemyImg: gambar objek.

Ada 4 jenis fungsi:
- Konstruktor: Enemy.
- Inisiasi gambar objek: initEnemy.
- Update dan render objek: update, render, updateVisibility, move, jump, reload, dan collision.
- Getter dan Setter: getX, getY, setX, getBounds, getWholeBounds, setvisibility, dan lain-lain.

****

```java
public class Enemy {
	
	private String imgName;
	private int x, y;
	private float velX, velY;
	private int fireDamage;

	private float gravity = 0.5f;
	protected boolean falling = true;
	protected boolean jumping = false;
	private final int MAX_SPEED = 7;
	
	Random rand = new Random(); 
	
	private SecondsTimer bt, jt, rt; 
	private Image playerImg;
	
	private boolean visibility = true;
	private boolean included = false;
	private int health = 100;
	private boolean bullet;	
	private Image enemyImg;
	
	public Enemy(String name, int x, int y) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		
		this.bt = new SecondsTimer(0.2f);
		this.jt = new SecondsTimer(7.5f);
		this.rt = new SecondsTimer(5.0f);
		initEnemy();
	}
	
	private void initEnemy() {
		enemyImg = Assets.getImageEnemy(imgName + ".png");
	}
	
	public void update(Ground ground){
		if (included) {
			jump();
			reload();
		}
		
		move();
			
		collision(ground);
	}
	
	public void render(Graphics g) {

		if (visibility) {
			g.drawImage(enemyImg, this.x, this.y, null);
			new Rectangle(x, y, enemyImg.getWidth(null), enemyImg.getHeight(null));
		}
	}
	
	private void move() {
		
		x += velX;
		y += velY;
		
		if(falling || jumping) {
			velY += gravity;
			
			if(velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		} else {
			velX = velY= 0;
		}
		
	}
	
	private void collision(Ground ground) {
		if(getBounds().intersects(ground.getBounds())) {
			falling = false;
			jumping = false;
		}
	}
	
	public boolean updateVisibility(PlayerBullet bullet) {
		boolean state = false;
		
		if (getBounds() != null && bullet.getBounds() != null) {
			if(getBounds().intersects(bullet.getBounds())) {
				state = true;

				health -= fireDamage;

				bullet.visible = false;

				if(health < 0) {
					visibility = false;
				}
			}
		}

		return state;
	}

	public void jump() {
		
		if(jt.finishCounting()) {
			velY = -12;
			jumping = true;
			falling = true;
		}
	}
	
	public void reload() {
		if(rt.finishCounting()) {
			bullet = true;
		}
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x+68, y, 14, enemyImg.getHeight(null));
	}
	
	public Rectangle getWholeBounds() {
		return new Rectangle(x, y, enemyImg.getWidth(null), enemyImg.getHeight(null));
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle(x + 4, y,  24, 65);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle(x+30, y+2, 3, playerImg.getHeight(null)-4);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle(x, y+2, 3, playerImg.getHeight(null)-4);
	}	

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	
	public boolean isVisible() {
		return visibility;
	}

	public boolean isIncluded() {
		return included;
	}

	public void setIncluded(boolean included) {
		this.included = included;
	}
	
	public SecondsTimer getBt() {
		return bt;
	}

	public void setBt(SecondsTimer bt) {
		this.bt = bt;
	}

	public SecondsTimer getJt() {
		return jt;
	}

	public void setJt(SecondsTimer jt) {
		this.jt = jt;
	}

	public SecondsTimer getRt() {
		return rt;
	}

	public void setRt(SecondsTimer rt) {
		this.rt = rt;
	}

	public boolean getBullet() {
		return bullet;
	}

	public void setBullet(boolean bullet) {
		this.bullet = bullet;
	}

	public int getFireDamage() {
		return fireDamage;
	}

	public void setFireDamage(int fireDamage) {
		this.fireDamage = fireDamage;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	protected boolean isFalling() {
		return falling;
	}

	protected void setFalling(boolean falling) {
		this.falling = falling;
	}

	protected boolean isJumping() {
		return jumping;
	}

	protected void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}
```