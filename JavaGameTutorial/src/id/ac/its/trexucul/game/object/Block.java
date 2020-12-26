package id.ac.its.trexucul.game.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import id.ac.its.trexucul.game.framework.GameObject;
import id.ac.its.trexucul.game.framework.ObjectId;
import id.ac.its.trexucul.game.framework.Texture;
import id.ac.its.trexucul.game.window.Game;

public class Block extends GameObject{

	Texture tex = Game.getInstance();
	private int type;

	public Block(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
	}
	
	@Override
	public void tick(LinkedList<GameObject> object) {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawRect((int)x, (int)y, 32, 32);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

	

}
