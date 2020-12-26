package id.ac.its.trexucul.game.window;

import java.awt.Graphics;
import java.util.LinkedList;

import id.ac.its.trexucul.game.framework.GameObject;
import id.ac.its.trexucul.game.framework.ObjectId;
import id.ac.its.trexucul.game.object.Block;

public class Handler {

public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
		
	public void tick() {
		for(int i=0; i<object.size(); i++) {
			tempObject = object.get(i);
			
			tempObject.tick(object);
		}
	}
	
	
	public void render(Graphics g) {
		for(int i=0; i<object.size(); i++) {
			tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void createLevel() {
		//handler.addObject(new Test(100,100,ObjectId.Test));
				for(int xx=0; xx<Game.WIDTH+32; xx+=32) {
					addObject(new Block(xx, Game.HEIGHT-32, ObjectId.Block));
				}
				
				for(int right = Game.HEIGHT-64; right > -32; right -=32) {
					addObject(new Block(Game.WIDTH-32,right,ObjectId.Block));
				}
				
				for(int left = Game.HEIGHT-32; left > -32; left -= 32) {
					addObject(new Block(0, left, ObjectId.Block));
				}
				
				for(int center = 400; center <= 496; center += 32) {
					addObject(new Block(center, 390,ObjectId.Block));
				}
				
				for(int floatingBlock = 120; floatingBlock <= 216; floatingBlock += 32) {
					addObject(new Block((floatingBlock), 420, ObjectId.Block));
				}
				
	}
	
}
