package id.ac.its.trexucul.shootingaliens;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {

	protected int x,y,width,height;
	protected boolean visible;
	protected Image image;
	
	//The constructor initiates the x and y coordinates and the visible variable.
	//common code from Missile and SpaceShip classes
	public Sprite(int x, int y) {
		
		this.x = x;
		this.y = y;
		visible = true;
		
	}
	
	protected void loadImage (String imageName) {
		ImageIcon ii = new ImageIcon(imageName);
		image = ii.getImage();
	}
	
	protected void getImageDimensions() {
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
	
}
