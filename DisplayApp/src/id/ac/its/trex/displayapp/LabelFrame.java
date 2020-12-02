package id.ac.its.trex.displayapp;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel label1,nrp1;
	private final JLabel label2,nrp2;
	private final JLabel label3,nrp3;

	
	public LabelFrame() {
		super("Kelompok T-Rex Ucul");
		setLayout(new FlowLayout());
		
		
		//Anggota 1
		label1 = new JLabel("Alam Tajuu Sarof");
		add(label1);
		
		//resize foto
		ImageIcon Allam = new ImageIcon(getClass().getResource("fotoallam.jpg")); // load the image to a imageIcon
		Image AllamImg = Allam.getImage();
		Image modAllamImg = AllamImg.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
		Allam = new ImageIcon(modAllamImg);
		nrp1 = new JLabel("05111940000053", Allam, SwingConstants.LEFT);
		add(nrp1);
		
		//Anggota 2
		label2 = new JLabel("M Maroqi Abdul Jalil");
		add(label2);
		
		//resize foto
		ImageIcon Jalil = new ImageIcon(getClass().getResource("fotojalil.jpg")); // load the image to a imageIcon
		Image JalilImg = Jalil.getImage();
		Image modJalilImg = JalilImg.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
		Jalil = new ImageIcon(modJalilImg);
		nrp2 = new JLabel("05111940000143", Jalil, SwingConstants.LEFT);
		add(nrp2);
		
		
		//Anggota 3
		label3 = new JLabel("Cahyadesthian R.W.");
		add(label3);
		
		Icon cahya = new ImageIcon(getClass().getResource("fotocahya.jpg"));
		nrp3 = new JLabel("05111940000156", cahya, SwingConstants.LEFT);
		add(nrp3);
		
		
	}

}

