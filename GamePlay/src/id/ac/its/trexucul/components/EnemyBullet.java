package id.ac.its.trexucul.components;

import java.awt.Graphics;

public class EnemyBullet extends Bullet {
	
	private Player player;

	public EnemyBullet(String name, int x, int y, Player player) {
		super(name, x, y, -50.0f);
		this.player = player;
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
	}
}
