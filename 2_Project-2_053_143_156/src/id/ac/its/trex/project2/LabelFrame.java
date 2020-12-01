package id.ac.its.trex.project2;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {
	
	private final JLabel label1,nrp1;
	private final JLabel label2,nrp2;
	private final JLabel label3,nrp3;

	
	public LabelFrame() {
		super("Kelompok T-Rex Ucul");
		setLayout(new FlowLayout());
		
		
		//Anggota 1
		label1 = new JLabel("Alam Tajuu Sarof");
		//label1.setToolTipText("This is label1");
		add(label1);
		
		Icon cahya = new ImageIcon(getClass().getResource("fotocahya.jpg"));
		nrp1 = new JLabel("05111940000053", cahya, SwingConstants.LEFT);
		add(nrp1);
		
		//Anggota 2
		label2 = new JLabel("M Maroqi Abdul Jalil");
		//label1.setToolTipText("This is label1");
		add(label2);
		
		//Icon cahya = new ImageIcon(getClass().getResource("fotocahya.jpg"));
		nrp2 = new JLabel("05111940000143", cahya, SwingConstants.LEFT);
		add(nrp2);
		
		
		//Anggota 3
		label3 = new JLabel("Cahyadesthian R.W.");
		//label1.setToolTipText("This is label1");
		add(label3);
		
		//Icon cahya = new ImageIcon(getClass().getResource("fotocahya.jpg"));
		nrp3 = new JLabel("05111940000156", cahya, SwingConstants.LEFT);
		add(nrp3);
		
		
		
		
	}

}
