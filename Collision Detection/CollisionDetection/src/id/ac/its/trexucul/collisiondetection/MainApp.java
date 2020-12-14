package id.ac.its.trexucul.collisiondetection;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MainApp extends JFrame{

	public MainApp() {
		initUI();
	}
	
	private void initUI() {
		add(new Board());
		setTitle("Shooting Aliens");
		setSize(1280,720);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(() -> {
			MainApp ex = new MainApp();
			ex.setVisible(true);
		});
		
		

	}

	
}
