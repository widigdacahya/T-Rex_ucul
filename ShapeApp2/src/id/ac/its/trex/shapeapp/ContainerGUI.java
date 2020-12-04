package id.ac.its.trex.shapeapp;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import id.ac.its.trex.shapeapp.shape.Circle;

public class ContainerGUI extends JFrame implements ActionListener {
	
	private JPanel shapeMenu;
	private JPanel shapeInput;
	private JPanel resultOperation;
	private Container content;
	
	private JLabel menuLabel;
	private JButton circle;
	private JButton rectangle;
	private JButton triangle;
	
	private JLabel input1Label;
	private JLabel input2Label;
	private JLabel input3Label;
	private JTextField input1;
	private JTextField input2;
	private JTextField input3;
	
	private JButton count;
	private JLabel result;
	
	private String currentOp;
	
	public ContainerGUI() {
		super("ShapeApp");
		content = getContentPane();
		
		initMenu();
		initInput();
		initResultOp();
		
		content.setLayout(new GridLayout(3, 1, 5, 5));
		content.add(shapeMenu);
		content.add(shapeInput);
		content.add(resultOperation);
	}
	
	private void initMenu() {
		menuLabel = new JLabel("<html>"
				+ "Silahkan pilih<br>"
				+ "bidang datar:"
				+ "</html>");
		circle = new JButton("Lingkaran");
		circle.addActionListener(this);
		rectangle = new JButton("Persegi Panjang");
		rectangle.addActionListener(this);
		triangle = new JButton("Segitiga");
		triangle.addActionListener(this);
		
		shapeMenu = new JPanel(new GridLayout(1, 4, 5, 5));
		shapeMenu.add(menuLabel);
		shapeMenu.add(circle);
		shapeMenu.add(rectangle);
		shapeMenu.add(triangle);
	}
	
	private void initInput() {
		input1Label = new JLabel("Masukkan lebar:");
		input2Label = new JLabel("Masukkan tinggi:");
		input3Label = new JLabel("Masukkan c:");
		
		input1 = new JTextField("Lebar");
		input2 = new JTextField("Tinggi");
		input3 = new JTextField("c");
		
		shapeInput = new JPanel(new GridLayout(2, 2, 5, 5));
		shapeInput.add(input1Label);
		shapeInput.add(input1);
		shapeInput.add(input2Label);
		shapeInput.add(input2);
		
		currentOp = "Persegi";
	}
	
	private void initResultOp() {
		count = new JButton("Hitung");
		count.addActionListener(this);
		result = new JLabel("Luas dan Keliling");
		
		resultOperation = new JPanel(new GridLayout(1, 2, 5, 5));
		resultOperation.add(count);
		resultOperation.add(result);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == circle) {
			input1Label.setText("Masukkan jari-jari:");
			input1.setText("Jari-jari");
			
			shapeInput.setLayout(new GridLayout(1, 2, 5, 5));
			shapeInput.add(input1Label);
			shapeInput.add(input1);
			shapeInput.remove(input2Label);
			shapeInput.remove(input2);
			shapeInput.remove(input3Label);
			shapeInput.remove(input3);
			
			content.revalidate();
			content.repaint();
			
			currentOp = "Lingkaran";
		} else if (e.getSource() == rectangle) {
			input1Label.setText("Masukkan lebar:");
			input2Label.setText("Masukkan tinggi:");
			input1.setText("Lebar");
			input2.setText("Tinggi");
			
			shapeInput.setLayout(new GridLayout(2, 2, 5, 5));
			shapeInput.add(input1Label);
			shapeInput.add(input1);
			shapeInput.add(input2Label);
			shapeInput.add(input2);
			shapeInput.remove(input3Label);
			shapeInput.remove(input3);

			content.revalidate();
			content.repaint();

			currentOp = "Persegi";
		} else if (e.getSource() == triangle) {
			input1Label.setText("Masukkan a:");
			input2Label.setText("Masukkan b:");
			input3Label.setText("Masukkan c:");
			input1.setText("a");
			input2.setText("b");
			input3.setText("c");
			
			shapeInput.setLayout(new GridLayout(3, 2, 5, 5));
			shapeInput.add(input1Label);
			shapeInput.add(input1);
			shapeInput.add(input2Label);
			shapeInput.add(input2);
			shapeInput.add(input3Label);
			shapeInput.add(input3);

			content.revalidate();
			content.repaint();

			currentOp = "Segitiga";
		} else if (e.getSource() == count) {
			if (currentOp.equals("Lingkaran")) {
				double r = Double.parseDouble(input1.getText());
				Circle c = new Circle(r);
				
				result.setText(String.format("Luas: %.2lf Keliling: %.2lf", c.getArea(), c.getAround()));

				content.revalidate();
				content.repaint();
			}
		}
	}
}
