package id.ac.its.trex.shapeapp;

import javax.swing.JOptionPane;

public class SampleGUI {
	public static void main(String[] args)
	{
		Shape[] shapes = new Shape[3];
		
		//input
		Object[] availableShape = {"Circle", "Rectangle", "Triangle"};
		Object selected = JOptionPane.showInputDialog(null, 
				"Choose Shape", "Shape Type", 
				JOptionPane.QUESTION_MESSAGE, null, availableShape, availableShape[0]);
		
		if(selected == availableShape[0]) {
			String inputRadius = JOptionPane.showInputDialog("Enter Radius: ");
			shapes[0] = new Circle(Integer.parseInt(inputRadius));
			
			JOptionPane.showMessageDialog(null, "Circle Area = "+ shapes[0].getArea() + 
					"\nCircle Around = "+ shapes[0].getAround(), "Circle", 
					JOptionPane.INFORMATION_MESSAGE);
			
		}else if(selected == availableShape[1]) {
			String inputHeight = JOptionPane.showInputDialog("Enter Height: ");
			String inputWidth = JOptionPane.showInputDialog("Enter Width: ");
			shapes[1] = new Rectangle(Integer.parseInt(inputHeight), Integer.parseInt(inputWidth));
			
			JOptionPane.showMessageDialog(null, "Rectangle Area = "+ shapes[1].getArea() + 
					"\nRectangle Around = "+ shapes[1].getAround(), "Rectangle", 
					JOptionPane.INFORMATION_MESSAGE);
			
		}else if(selected == availableShape[2]) { //segitiga siku2. dengan sisi yang panjang adalah c
			String inputA = JOptionPane.showInputDialog("Enter A: ");
			String inputB = JOptionPane.showInputDialog("Enter B: ");
			String inputC = JOptionPane.showInputDialog("Enter C: ");
			shapes[2] = new Triangle(Integer.parseInt(inputA), Integer.parseInt(inputB), Integer.parseInt(inputC));
			
			JOptionPane.showMessageDialog(null, "Triangle Area = "+ shapes[2].getArea() + 
					"\nTriangle Around = "+ shapes[2].getAround(), "Triangle", 
					JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null, "Something went wrong!", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
}
