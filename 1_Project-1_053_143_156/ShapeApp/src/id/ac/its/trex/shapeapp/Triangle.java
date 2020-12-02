package id.ac.its.trex.shapeapp;

public class Triangle extends Shape{
	private double a;
	private double b;
	private double c;
	
	public Triangle (double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	protected double getA() {
		return a;
	}
	protected void setA(double a) {
		this.a = a;
	}
	protected double getB() {
		return b;
	}
	protected void setB(double b) {
		this.b = b;
	}
	protected double getC() {
		return c;
	}
	protected void setC(double c) {
		this.c = c;
	}
	
	@Override
	public double getArea() {
		return (a*b/2);
	}
	
	@Override
	public double getAround() {
		return getA()+getB()+getC();
	}
	
	@Override
	public String toString() {
		return "Trinagle [a= "+getA()+", b= "+getB()+", c= "+getC()+"]";
	}
}
