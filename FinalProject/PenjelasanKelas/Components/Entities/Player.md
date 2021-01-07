# ☕️ Player Class

****
### 💡Penjelasan:
Kelas ini berfungsi sebagai objek permainan untuk menampilkan player.
Kelas ini merupakan abstract class yang nantinya akan diturunkan kepada kelas player dengan spesifikasi tembak tertentu.
Kelas ini digunakan dalam Game Screen, selain itu kelas ini juga mengatur pergerakan player dan animasi player.
Mulai dari mengambil gambar player dari aset, mengatur interval tembak, hingga mentukan posisi dan kecepatan geraknya.

### 💡Atribut dan Fungsi:
Ada 20 atribut:   
- imgName: gambar objek.
- x, y: posisi objek.
- velX, velY, velSpeed: kecepatan objek.
- fireDamage, toEnemyDamage: dmaage tembakan objek.
- gravity: kecepatan gravitasi objek.
- falling, jumping: status objek pada y.
- MAX_SPEED: kecepatan maksimum objek.
- rand: nilai tambahan untuk damage tembakan objek.
- bt, timer: pengatur delay.
- visibility, included: status visibilitas objek.
- health: banyak HP objek.
- steady: kondisi objek ketika berdiri tegak. 
- shield: kondisi objek ketika pelinfung aktif.
- firingflag: status menembak.
- firingWalkFlag: status tembak lari.
- click: menangani ketika mendapatkan klik.

Ada 4 jenis fungsi:
- Konstruktor: Player.
- Inisiasi gambar objek: initPlayer.
- Update dan render objek: update, render, updateVisibility, move, setFiringFlag, animating, dan collision.
- Getter dan Setter: getX, getY, getBounds, getWholeBounds, setvisibility, setCam, setShield, dan lain-lain.

****

```java
public abstract class Player {

	protected String imgName;
	protected int x, y;
	protected float velX, velY;
	protected int fireDamage;
	protected int toEnemyDamage;
	
	protected float gravity = 0.5f;
	protected float velSpeed = 4.0f;
	protected Rectangle bounds;
	
	protected boolean falling = true;
	protected boolean jumping = false;
	protected final int MAX_SPEED = 7;
	
	protected Timer timer;
	protected SecondsTimer bt;
	protected final int Delay = 200;
  Random rand = new Random(); 
	
  protected boolean steady = false;
  protected boolean shield = true;
  protected int firingflag = 0;
  protected int firingWalkFlag = 0;

  protected BulletListener click;

  protected boolean visibility = true;
  protected int health = 100;

	public abstract void initPlayer();
	public abstract void animating();
	public abstract void setFiringFlag();
	public abstract void render(Graphics g);
	public abstract void setCam();
	public abstract void collision(Ground ground);
	public abstract boolean updateVisibility(EnemyBullet eBullet);
	
	public Player(String name, int x, int y, BulletListener click) {
		this.imgName = name;
		this.x = x;
		this.y = y;
		this.click = click;
	}
	
	public void update(Ground ground){		
		if(KeyboardHandler.UP && (!jumping) ) {
			velY = -15;
			jumping = true;
			falling = true;
			shield = false;
		}
		
		if(KeyboardHandler.LEFT) {
			velX = -velSpeed;
			steady = false;
			shield = false;
		}
		
		if(KeyboardHandler.RIGHT) {
			velX = velSpeed;
			steady = false;
			shield = false;
		} 
		
		if(!KeyboardHandler.RIGHT && !KeyboardHandler.LEFT) {
			velX = 0;
		}
		
		if(KeyboardHandler.SPACE) {
			if(bt.finishCounting()) {
				click.onClick(x + 84, y + 23);
				setFiringFlag();
				shield = false;
			}
		}

		move();
		
		collision(ground);
		animating();
	}
	
	public void move() {
		
		x += velX;
		y += velY;
		
		if(falling || jumping) {
			velY += gravity;
			
			if(velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		}
		
		setCam();
	}
	
	public boolean isShield() {
		return shield;
	}

	public void setShield(boolean shield) {
		this.shield = shield;
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

	public boolean isVisible() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isSteady() {
		return steady;
	}

	public void setSteady(boolean steady) {
		this.steady = steady;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public int getFireDamage() {
		return fireDamage;
	}

	public void setFireDamage(SelectedGamePage fireDamage) {
		
		if(fireDamage == SelectedGamePage.Satu)
			this.fireDamage = 4;
		else if(fireDamage == SelectedGamePage.Dua)
			this.fireDamage = 7;
		else
			this.fireDamage = 12;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public int getToEnemyDamage() {
		return toEnemyDamage;
	}

	public void setToEnemyDamage(int toEnemyDamage) {
		this.toEnemyDamage = toEnemyDamage;
	}

	public SecondsTimer getBt() {
		return bt;
	}

	public void setBt(SecondsTimer bt) {
		this.bt = bt;
	}

	public float getVelSpeed() {
		return velSpeed;
	}

	public void setVelSpeed(float velSpeed) {
		this.velSpeed = velSpeed;
	}

}
```