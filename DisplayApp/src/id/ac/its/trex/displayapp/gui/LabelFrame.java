package id.ac.its.trex.displayapp.gui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;

	
	public LabelFrame() {
		super("Kelompok T-Rex Ucul");
		setLayout(new FlowLayout());
		
		// Anggota 1
		ImageIcon Allam = new ImageIcon(getClass().getResource("../assets/fotoallam.jpg")); // load the image to a imageIcon
		Image AllamImg = Allam.getImage();
		Image modAllamImg = AllamImg.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
		Allam = new ImageIcon(modAllamImg);
		label1 = new JLabel("<html>"
				+ "Nama: Alam Tajuu Sarof<br>"
				+ "NRP: 05111940000053"
				+ "</html>", Allam, SwingConstants.LEFT);
		add(label1);
		
		//Anggota 2
		ImageIcon Jalil = new ImageIcon(getClass().getResource("../assets/fotojalil.jpg")); // load the image to a imageIcon
		Image JalilImg = Jalil.getImage();
		Image modJalilImg = JalilImg.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
		Jalil = new ImageIcon(modJalilImg);
		label2 = new JLabel("<html>"
				+ "Nama: M Maroqi Abdul Jalil<br>"
				+ "NRP: 05111940000143"
				+ "</html>", Jalil, SwingConstants.LEFT);
		add(label2);
		
		
		//Anggota 3
		Icon cahya = new ImageIcon(getClass().getResource("../assets/fotocahya.jpg"));
		label3 = new JLabel("<html>"
				+ "Nama: Cahyadesthian R.W.<br>"
				+ "NRP: 05111940000156"
				+ "</html>", cahya, SwingConstants.LEFT);
		add(label3);
		
		
	}

}

