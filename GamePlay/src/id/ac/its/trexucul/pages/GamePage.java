package id.ac.its.trexucul.pages;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.components.entities.Enemy;
import id.ac.its.trexucul.components.entities.Player;
import id.ac.its.trexucul.components.entities.Sniper;
import id.ac.its.trexucul.components.objects.EnemyBullet;
import id.ac.its.trexucul.components.objects.Ground;
import id.ac.its.trexucul.components.objects.PlayerBullet;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.helper.Camera;
import id.ac.its.trexucul.utils.listener.BulletListener;
import id.ac.its.trexucul.utils.listener.ClickListener;

//Level 1 Game Page
public class GamePage extends PageState {
	
	private Sniper player;
	private Ground ground;
	private List<Enemy> enemy;
	private int enemyCount = 0;
	private float camX, camY;
	private CommonButton backButton;
	public int score = 0;
	
	private SelectedGamePage type;
	
	private final int [][] enemyPosition = {
		{900,500},{1220,500},{1450,500},
		{2150,500},{2650,500},{2750,500},
		{3150,500},{3450,500},{3550,500},
		{3750,500}
	};
	
	private ArrayList<PlayerBullet> pBullets = new ArrayList<PlayerBullet>();
	private ArrayList<EnemyBullet> eBullets = new ArrayList<EnemyBullet>();
	
	public GamePage(Window window, SelectedGamePage type) {
		super(window);
		this.type = type;
		enemy = new ArrayList<>(); 
				
		for (int[] p: enemyPosition) {
			enemy.add(new Enemy("Enemy",p[0],p[1]));
		}
		
		player = new Sniper("Player", 20, 500, new BulletListener() {
			@Override
			public void onClick(int x, int y) {
				pBullets.add(new PlayerBullet("Bullet", x, y));
			}
		});

		if (type == SelectedGamePage.Satu)
			ground = new Ground("darkground", 0, 646);
		else if (type == SelectedGamePage.Dua)
			ground = new Ground("grounddark2", 0, 646);
		else if (type == SelectedGamePage.Tiga)
			ground = new Ground("grounddark3", 0, 646);
		
		Assets.width = 96;
		Assets.height = 36;
		backButton = new CommonButton("btn_kembali", 60, 640, new ClickListener() {
			@Override
			public void onClick() {
				//Go to menu
				PageState.currentState = window.getMenuPage();
			}
		});
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
		g.setColor(Color.white);
		g.drawString("Enemies: " + enemyCount + " ", (int)((int)(-camX)+1100), (int)((int)(-camY)+30));
		g.drawString("Health: " + player.getHealth() + " ", (int)((int)(-camX)+20), (int)((int)(-camY)+30));
		g.drawString("Score: " + score + " ", (int)((int)(-camX)+500), (int)((int)(-camY)+30));

		if(player.getVelX()!=0)
			g.drawString("Shield: OFF", (int)((int)(-camX)+20), (int)((int)(-camY)+45));
		else if(player.isShield() ) 
			g.drawString("Shield: ON", (int)((int)(-camX)+20), (int)((int)(-camY)+45));
		else
			g.drawString("Shield: OFF", (int)((int)(-camX)+20), (int)((int)(-camY)+45));
		

//		enemyCount = 0;
		for(Enemy enemy: enemy) {	
			if(enemy.isVisible()) {
				enemy.render(g);
				g.setColor(Color.white);
				g.drawString("Enemy: " + enemy.getHealth() + " ", enemy.getX()+5, enemy.getY()-20);
//				enemyCount++;
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
			PageState.currentState = window.getVictoryPage();
			window.getVictoryPage().update();
			window.getVictoryPage().render(window.getGraphics());

			if (type == SelectedGamePage.Satu)
				window.getVictoryPage().inputData("Level 1");
			else if (type == SelectedGamePage.Dua)
				window.getVictoryPage().inputData("Level 2");
			else if (type == SelectedGamePage.Tiga)
				window.getVictoryPage().inputData("Level 3");
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
		
		backButton.setX( (int) -camX+60 );
		backButton.update();
	}
	
	public void fire(Enemy enemy) {
		if(enemy.getBullet()) {
			enemy.setBullet(false);
			eBullets.add(new EnemyBullet("Bullet", enemy.getX(), enemy.getY()+23, null));
			//System.out.printf("PosX: %d, PosY: %d%n", enemy.getX(), enemy.getY()+23);
		}
	}
	
	public void score(int damage) {
		score += (damage * (101-player.getHealth()));
	}
	
	public Sniper getPlayer() {
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
	

}
