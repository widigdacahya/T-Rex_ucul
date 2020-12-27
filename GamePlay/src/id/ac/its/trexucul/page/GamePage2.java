package id.ac.its.trexucul.page;

import java.awt.Graphics;
import java.util.ArrayList;

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
	private Enemy enemy;
	private Ground ground;
	
	private ArrayList<PlayerBullet> pBullets = new ArrayList<PlayerBullet>();
	
	public GamePage2(Window window) {
		super(window);
		enemy = new Enemy("Enemy", 1100, 500);
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
		enemy.render(g);
		ground.render(g);
		
		for(int i = 0; i < pBullets.size(); i++) {
			pBullets.get(i).render(g);
		}
	}

	@Override
	public void update() {
		player.update(ground);
		enemy.update(ground);
		
		for(int i = 0; i < pBullets.size(); i++) {
			pBullets.get(i).update();
			if (pBullets.get(i).checkCollision(enemy)) {
				enemy.setVisibility(false);
			}
		}
	}
	
	public Player getPlayer() {
		return player;
	}
}
