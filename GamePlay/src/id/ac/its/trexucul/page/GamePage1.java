package id.ac.its.trexucul.page;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import id.ac.its.trexucul.components.Enemy;
import id.ac.its.trexucul.components.EnemyBullet;
import id.ac.its.trexucul.components.Ground;
import id.ac.its.trexucul.components.Player;
import id.ac.its.trexucul.components.PlayerBullet;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.main.Camera;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.BulletListener;
import id.ac.its.trexucul.util.PageState;

//Level 1 Game Page
public class GamePage1 extends PageState {
	
	private Player player;
	private Ground ground;
	private List<Enemy> enemy;
	private int enemyCount;
	private float camX, camY;
	
	private final int [][] enemyPosition = {
		{900,500},{1220,500},{1450,500},
		{2150,500},{2650,500},{2750,500},
		{3150,500},{3450,500},{3550,500},
		{3750,500}
	};
	
	private ArrayList<PlayerBullet> pBullets = new ArrayList<PlayerBullet>();
	private ArrayList<EnemyBullet> eBullets = new ArrayList<EnemyBullet>();
	
	public GamePage1(Window window) {
		super(window);
		enemy = new ArrayList<>(); 
				
		for (int[] p: enemyPosition) {
			enemy.add(new Enemy("Enemy",p[0],p[1]));
			
		}
		
		player = new Player("Player", 20, 500, new BulletListener() {
			@Override
			public void onClick(int x, int y) {
				pBullets.add(new PlayerBullet("Bullet", x, y));
			}
		});
		ground = new Ground("darkground", 0, 646);

	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.gamepage1BG, 0, 0, null);
		ground.render(g);
		player.render(g);
		
		//stats
		g.setColor(Color.white);
		g.drawString("Enemies: " + enemyCount + " ", (int)((int)(-window.cam.getX())+1100), (int)((int)(-window.cam.getY())+30));

		enemyCount = 0;
		
		for(Enemy enemy: enemy) {	
			if(enemy.isVisible()) {
				enemy.render(g);
				g.setColor(Color.white);
				g.drawString("Enemy: " + enemy.getHealth() + " ", enemy.getX()+5, enemy.getY()-20);
				enemyCount++;
			}
		}
		
		for(PlayerBullet bullet : pBullets) {
			bullet.render(g);
		}
		
		for(EnemyBullet bullet : eBullets) {
			bullet.render(g);
		}
	}

	@Override
	public void update() {
		
		player.update(ground);
		
		//enemy.update(ground);

		for(Enemy enemy: enemy) {
			if (enemy.getX() < (-camX+Window.WIDTH) && enemy.getX() > -camX)
				enemy.setIncluded(true);
			else
				enemy.setIncluded(false);
			enemy.update(ground);
		}
		

		checkBulletCollision();

		for(int i = 0; i < eBullets.size(); i++) {
			eBullets.get(i).update();
			player.updateVisibility(eBullets);
		}
		
		for(int i = 0; i < pBullets.size(); i++) {
			pBullets.get(i).update();
			//enemy.updateVisibility(pBullets.get(0));
			for(Enemy enemy: enemy) {
				enemy.updateVisibility(pBullets.get(i));
				if( enemy.isVisible() ) {
					fire(enemy);
				}
			}
		}
		
		//player mati
		if(!player.isVisible()) {
			player.setVisibility(true);
			player.setHealth(100);
			PageState.currentState = window.getGameOverPage();
		}
			

	}
	
	public void fire(Enemy enemy) {
		if(enemy.getBt().finishCounting() && enemy.getRt().finishCounting()) {
			eBullets.add(new EnemyBullet("Bullet", enemy.getX(), enemy.getY()+23, null));
		}
			
	}
	
	public Player getPlayer() {
		return player;
	}
	
	private void checkBulletCollision() {
		int index = 0;
		
		while (index < pBullets.size()) {
			boolean bState = false;
			
			pBullets.get(index).update();
			
			bState = checkEnemyCollision(pBullets.get(index));
			
			if (bState)
				pBullets.remove(index);
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
				if (!enemy.get(index).isVisible())
					enemy.remove(index);
				break;
			} else
				index++;
		}
		
		return eState;
	}
}
