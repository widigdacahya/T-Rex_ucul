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
	
	
}
