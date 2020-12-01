package id.ac.its.trex.project2;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {

	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	
	public LabelFrame() {
		super("Testing JLabel");
		setLayout(new FlowLayout());
		
		//JLabel constructor with string argument
		label1 = new JLabel("Label with text");
		label1.setToolTipText("This is label1");
		add(label1);
		
		//JLabel constrcutor with string, icon and alligmnet arguemnt
		Icon gopay = new ImageIcon(getClass().getResource("gopay_ic.png"));
		label2 = new JLabel("label with text and icon", gopay, SwingConstants.LEFT);
		label2.setToolTipText("This is label2");
		add(label2);
		
		//JLabel with no argumtn
		label3 = new JLabel();
		label3.setText("Label with icon and text at bottom");
		label3.setIcon(gopay);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		add(label3);
		
		
	}
	
}

