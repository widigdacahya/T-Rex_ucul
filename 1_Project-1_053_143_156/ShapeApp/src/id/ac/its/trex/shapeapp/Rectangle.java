package id.ac.its.trex.shapeapp;

public class Rectangle extends Shape {
	
	// properti spesifik untuk kelas Rectangle
	protected double height;
	protected double width;
	
	public Rectangle() {
		super();
		this.height = 0.0;
		this.width = 0.0;
	}
	
	public Rectangle(double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}
	
	@Override
	public double getAround() {
		return getWidth()*2 + getHeight()*2;
	}
	

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}		
}
