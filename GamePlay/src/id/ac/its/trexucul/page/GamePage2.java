package id.ac.its.trexucul.page;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import id.ac.its.trexucul.components.Bullet;
import id.ac.its.trexucul.components.Enemy;
import id.ac.its.trexucul.components.Ground;
import id.ac.its.trexucul.components.Player;
import id.ac.its.trexucul.components.PlayerBullet;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.BulletListener;
import id.ac.its.trexucul.util.PageState;

//Level 2 Game Page
public class GamePage2 extends PageState{
	
	private Player player;
	private List<Enemy> enemy;
	private Ground ground;
	private int enemyCount;
	private float camX, camY;
	
	private final int [][] enemyPosition = {
			{900,500},{1220,500},{1450,500},{1609,500},{1780,500},
			{2150,500},{2350,500},{2500,500},{2700,500},{2880,500},
			{3120,500},{3220,500},{3450,500},{3650,500},{3800,500}
	};
	
	private ArrayList<PlayerBullet> pBullets = new ArrayList<PlayerBullet>();
	
	public GamePage2(Window window) {
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
		
		ground = new Ground("grounddark2", 0, 646);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gamepage2BG, 0, 0, null);
		player.render(g);
		ground.render(g);
		
		g.setColor(Color.WHITE);
		g.drawString("Enemies: " + enemyCount + " ", (int)((int)(-camX)+1100), (int)((int)(-camY)+30));
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
	}

	@Override
	public void update() {
		camX = window.cam.getX();
		camY = window.cam.getY();
		
		player.update(ground);
		
		for(Enemy enemy: enemy) {
			if (enemy.getX() < (-camX+Window.WIDTH) && enemy.getX() > -camX)
				enemy.setIncluded(true);
			else
				enemy.setIncluded(false);
			enemy.update(ground);
		}
		
		checkBulletCollision();
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
