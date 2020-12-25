package id.ac.its.trexucul.game.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import id.ac.its.trexucul.game.framework.GameObject;
import id.ac.its.trexucul.game.framework.ObjectId;

public class Player extends GameObject {
	
	private float width=32;
	private float height =64;
	
	
	private float gravity = 0.05f;
	private final float MAX_SPEED = 10;

	public Player(float x, float y, ObjectId id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		
		x += velX;
		y += velY;
		
		if(falling || jumping) {
			velY += gravity;
			
			if(velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x,(int)y,(int)width,(int)height);
		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}

}
