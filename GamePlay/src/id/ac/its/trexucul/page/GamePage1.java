package id.ac.its.trexucul.page;

import java.awt.Graphics;

import id.ac.its.trexucul.components.Bullet;
import id.ac.its.trexucul.components.Enemy;
import id.ac.its.trexucul.components.Ground;
import id.ac.its.trexucul.components.Player;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.PageState;

//Level 1 Game Page
public class GamePage1 extends PageState {
	
	private Player player;
	private Enemy enemy;
	private Bullet bullet;
	private Ground ground;
	
	public GamePage1(Window window) {
		super(window);
		player = new Player("Player", 20, 500);
		enemy = new Enemy("Enemy", 1100, 500);
		bullet = new Bullet("Bullet",180,524);
		ground = new Ground("darkground", 0, 646);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gamepage1BG, 0, 0, null);
		ground.render(g);
		player.render(g);
		enemy.render(g);
		bullet.render(g);
	}

	@Override
	public void update() {
		player.update(ground);
		enemy.update();
		bullet.update();
		
	}
	
	public Player getPlayer() {
		return player;
	}
}
