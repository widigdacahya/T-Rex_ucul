package id.ac.its.trexucul.page;

import java.awt.Graphics;

import id.ac.its.trexucul.components.Bullet;
import id.ac.its.trexucul.components.Enemy;
import id.ac.its.trexucul.components.Ground;
import id.ac.its.trexucul.components.Player;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.PageState;

// Level 3 Game Page
public class GamePage3 extends PageState {
	
	private Player player;
	private Enemy enemy;
	private Bullet bullet;
	private Ground ground;
	
	public GamePage3(Window window) {
		super(window);
		player = new Player("Player", 20, 500);
		enemy = new Enemy("Enemy", 1100, 500);
		bullet = new Bullet("Bullet",180,524);
		ground = new Ground("grounddark3", 0, 646);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gamepage3BG, 0, 0, null);
		player.render(g);
		enemy.render(g);
		bullet.render(g);
		ground.render(g);
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
