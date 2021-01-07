package id.ac.its.trexucul.main.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.components.entities.Enemy;
import id.ac.its.trexucul.components.entities.Player;
import id.ac.its.trexucul.components.entities.Riffle;
import id.ac.its.trexucul.components.entities.Sniper;
import id.ac.its.trexucul.components.objects.EnemyBullet;
import id.ac.its.trexucul.components.objects.Ground;
import id.ac.its.trexucul.components.objects.PlayerBullet;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.helper.FontLoader;
import id.ac.its.trexucul.utils.helper.SecondsTimer;
import id.ac.its.trexucul.utils.listener.BulletListener;
import id.ac.its.trexucul.utils.listener.ClickListener;

//Level 1 Game Page
public class GamePage extends PageState {
	
	/*to declare a character use
	 * Player polymorp or specify
	 * the class. available class:
	 * riffle and sniper
	 * ex:
	 * Player player = new Sniper(param)
	 * Sniper player = new Sniper(param)
	 * */
	private Player player;
	private Ground ground;
	private List<Enemy> enemy;
	private int enemyCount = 0;
	private float camX, camY;
	private CommonButton backButton;
	public int score = 0;
	
	private SelectedGamePage type;
	public static SelectedGamePage character;
	private Font font = FontLoader.loadFont("res/fonts/Russo_One.ttf", 14);
	private Font fontm = FontLoader.loadFont("res/fonts/Russo_One.ttf", 16);
	private Font fontl = FontLoader.loadFont("res/fonts/Russo_One.ttf", 24);
	
	private final int [][] enemyPosition = {
		{900,500},{1220,500},{1450,500},
		{2150,500},{2650,500},{2750,500},
		{3150,500},{3450,500},{3550,500},
		{3750,500}
	};
	
	private ArrayList<PlayerBullet> pBullets = new ArrayList<PlayerBullet>();
	private ArrayList<EnemyBullet> eBullets = new ArrayList<EnemyBullet>();
	
	/*to do
	 * set character on this constructor and fix other*/
	public GamePage(Window window, SelectedGamePage type, SelectedGamePage Character) {
		super(window);
		this.type = type;
		enemy = new ArrayList<>(); 
				
		for (int[] p: enemyPosition) {
			enemy.add(new Enemy("Enemy",p[0],p[1]));
		}
		
		setCharacter(character);
		setDifficulty(type);
		
		backButton = new CommonButton("kembali_btn", 10, 640, new ClickListener() {
			@Override
			public void onClick() {
				//Go to menu
				PageState.currentState = window.getMenuPage();
			}
		}, 239, 52);
	}

	@Override
	public void render(Graphics g) {
		// P-GamePage
		if (type == SelectedGamePage.Satu)
			g.drawImage(Assets.gamepage1BG, 0, 0, null);
		else if (type == SelectedGamePage.Dua)
			g.drawImage(Assets.gamepage2BG, 0, 0, null);
		else if (type == SelectedGamePage.Tiga)
			g.drawImage(Assets.gamepage3BG, 0, 0, null);
		
		ground.render(g);
		player.render(g);
		
		//stats
		FontMetrics fm = g.getFontMetrics(fontm);
		FontMetrics fmL = g.getFontMetrics(fontl);
		
		g.setColor(Color.white);
		g.setFont(fontm);
		String enemiesCountText = "Musuh: " + enemyCount;
		g.drawString(enemiesCountText, (int)(-camX)+(Window.WIDTH-fm.stringWidth(enemiesCountText)-20), (int)(-camY)+30);
		g.drawString("HP Player: " + player.getHealth() + " ", (int)(-camX)+20, (int)(-camY)+30);
		
		g.setFont(fontl);
		String scoreText = "Skor: " + score;
		g.drawString(scoreText, (int)(-camX)+(Window.WIDTH/2-fmL.stringWidth(scoreText)/2), (int)(-camY)+30);

		g.setFont(fontm);
		if(player.getVelX()!=0)
			g.drawString("Pelindung: Mati", (int)(-camX)+20, (int)(-camY)+45);
		else if(player.isShield() ) 
			g.drawString("Pelindung: Hidup", (int)(-camX)+20, (int)(-camY)+45);
		else
			g.drawString("Pelindung: Mati", (int)(-camX)+20, (int)(-camY)+45);
		

		for(Enemy enemy: enemy) {	
			if(enemy.isVisible() && enemy.isIncluded()) {
				enemy.render(g);
				g.setColor(Color.white);
				g.setFont(font);
				g.drawString("HP Musuh: " + enemy.getHealth() + " ", enemy.getX()+5, enemy.getY()-20);			
			}
		}
		
		for(PlayerBullet bullet : pBullets) {
			if (checkIsIncluded(bullet.getX()))
				bullet.render(g);
		}
		
		for(EnemyBullet bullet : eBullets) {
			if (checkIsIncluded(bullet.getX()))
				bullet.render(g);
		}
		
		backButton.render(g);
	}

	@Override
	public void update() {
		camX = window.cam.getX();
		camY = window.cam.getY();
		
		player.update(ground);
		
		enemyCount = 0;
		for(Enemy enemy: enemy) {
			if (checkIsIncluded(enemy.getX()))
				enemy.setIncluded(true);
			else
				enemy.setIncluded(false);
			
			enemy.update(ground);
			
			if(enemy.isVisible()) {
				enemyCount++;
				if(enemy.isIncluded()) {
					fire(enemy);
				}
			}
		}
		
		if(enemyCount == 0 ) {
			window.setVictoryPage(type, score);
			PageState.currentState = window.getVictoryPage();
			return;
		}

		checkPlayerBulletCollision();
		checkEnemyBulletCollision();
		
		//player mati
		if(!player.isVisible()) {
			player.setVisibility(true);
			player.setHealth(100);
			window.cam.setX(0);
			window.cam.setY(0);
			PageState.currentState = window.getGameOverPage();
		}
		
		backButton.setX( (int)-camX+10 );
		backButton.update();
	}
	
	public void fire(Enemy enemy) {
		if(enemy.getBullet()) {
			enemy.setBullet(false);
			eBullets.add(new EnemyBullet("Bullet", enemy.getX(), enemy.getY()+23));
		}
	}
	
	public void score(int damage) {
		score += (damage * (111-player.getHealth()));
	}
	
	public Player getPlayer() {
		return player;
	}
	
	private void checkPlayerBulletCollision() {
		int index = 0;
		
		while (index < pBullets.size()) {
			boolean bState = false;

			if (checkIsIncluded(pBullets.get(index).getX())) {
				pBullets.get(index).update();
				
				bState = checkEnemyCollision(pBullets.get(index));
			}
			
			if (bState)
				pBullets.remove(index);
			else
				index++;
		}
	}
	
	private void checkEnemyBulletCollision() {
		int index = 0;
		
		while (index < eBullets.size()) {
			boolean bState = false;

			if (checkIsIncluded(eBullets.get(index).getX())) {
				eBullets.get(index).update();
				
				bState = checkPlayerCollision(eBullets.get(index));
			}
			
			if (bState)
				eBullets.remove(index);
			else
				index++;
		}
	}
	
	private boolean checkEnemyCollision(PlayerBullet bullet) {
		boolean eState = false;
		int index = 0;

		while (index < enemy.size()) {
			
			if(enemy.get(index).updateVisibility(bullet)) {
				eState = true;
				score(enemy.get(index).getFireDamage());
				
				if (!enemy.get(index).isVisible())
					enemy.remove(index);
				break;
			} else
				index++;
		}

		return eState;
	}

	
	private boolean checkPlayerCollision(EnemyBullet bullet) {
		boolean eState = false;
		
		if(player.updateVisibility(bullet)) {
			eState = true;
		}

		return eState;
	}
	
	private boolean checkIsIncluded(int x) {
		return (x < (-camX+Window.WIDTH) && x > -camX);
	}

	private void setDifficulty(SelectedGamePage type) {
		
		if (type == SelectedGamePage.Satu) {
			ground = new Ground("darkground", 0, 646);
			for(Enemy enemy: enemy)
				enemy.setRt(new SecondsTimer(5.0f));//set enemy reload time
		}
		else if (type == SelectedGamePage.Dua) {
			ground = new Ground("grounddark2", 0, 646);
			for(Enemy enemy: enemy)
				enemy.setRt(new SecondsTimer(4.0f));
		}
		else if (type == SelectedGamePage.Tiga) {
			ground = new Ground("grounddark3", 0, 646);
			for(Enemy enemy: enemy)
				enemy.setRt(new SecondsTimer(1.0f));
		}
	}
	
	private void setDamageToEnemy(int damage) {
		for(Enemy enemy: enemy)
			enemy.setFireDamage(damage);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public SelectedGamePage getType() {
		return type;
	}

	public void setType(SelectedGamePage type) {
		this.type = type;
	}

	public SelectedGamePage getCharacter() {
		return character;
	}

	public void setCharacter(SelectedGamePage character) {
		
		if(character == SelectedGamePage.Satu) {
			player = new Riffle("Player", 20, 500, new BulletListener() {
				@Override
				public void onClick(int x, int y) {
					pBullets.add(new PlayerBullet("Bullet", x, y));
				}
			});
			
			settingUpAbility(100, 26, 0.2f);
		} else if(character == SelectedGamePage.Dua) {
			player = new Sniper("Player", 20, 500, new BulletListener() {
				@Override
				public void onClick(int x, int y) {
					pBullets.add(new PlayerBullet("Bullet", x, y));
				}
			});
			
			settingUpAbility(110, 90, 0.9f);
		} else {
			player = new Sniper("Player", 20, 500, new BulletListener() {
				@Override
				public void onClick(int x, int y) {
					pBullets.add(new PlayerBullet("Bullet", x, y));
				}
			});
			
			settingUpAbility(80, 200, 1.4f);
		}
	}
	
	public void settingUpAbility(int health, int damageToEnemy, float bTimer) {
		player.setHealth(health);
		player.setToEnemyDamage(damageToEnemy);
		setDamageToEnemy(player.getToEnemyDamage());
		player.setBt(new SecondsTimer(bTimer));
	}
	

}
