package id.ac.its.trex.shapeapp;

public class Circle extends Shape{

    private double radius;

    //constructor
    public Circle() {
        super();
        System.out.println("[Circle] Default Constructor");
		this.radius = 0.0;
    }

    public Circle(double radius) {
		super();
		System.out.println("[Circle] constructor 1");
		this.radius = radius;
	}

    /*
    public Circle(String color, double radius) {
		super(color);
		System.out.println("[Circle] constructor 2");
		this.radius = radius;
	}*/


    public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

    @Override
    public double getArea() {
        return 3.14*this.radius*this.radius;
    }

    @Override
    public double getAround() {
        return 3.14 * 2 * this.radius;
    }
    
}