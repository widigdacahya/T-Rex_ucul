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
		
		for(int i = 0; i < pBullets.size(); i++) {
			pBullets.get(i).render(g);
		}
		
		
		for(Enemy enemy: enemy) {	
			if(enemy.isVisible()) {
				enemy.render(g);
				//enemy stats
				g.setColor(Color.white);
				g.drawString("Enemy: " + enemy.getHealth() + " ", enemy.getX()+5, enemy.getY()-20);
			}
				
		}
		
	}

	@Override
	public void update() {
		player.update(ground);
		
		for(Enemy enemy: enemy) {
			enemy.update(ground);
		}
		
		for(int i = 0; i < pBullets.size(); i++) {
			pBullets.get(i).update();
			
			for(Enemy enemy: enemy) {
				enemy.updateVisibility(pBullets.get(i));
			}
		}
	}
	
	public Player getPlayer() {
		return player;
	}
}
