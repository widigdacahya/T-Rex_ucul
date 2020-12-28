package id.ac.its.trexucul.page;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.util.ClickListener;
import id.ac.its.trexucul.util.CreateTextFile;
import id.ac.its.trexucul.util.KeyboardHandler;
import id.ac.its.trexucul.util.PageState;

public class VictoryPage extends PageState{
	
	private Image gameOverText = Assets.getImageText("victory.png");
	protected ArrayList<CommonButton> buttons  = new ArrayList<CommonButton>();

	public VictoryPage(Window window) {
		super(window);
		
		Assets.width = 177;
		Assets.height = 45;
		buttons.add(new CommonButton("coba_lagi_btn", Window.WIDTH/2 - 300, Window.HEIGHT/2, new ClickListener() {
			@Override
			public void onClick() {
				
				//Go to Level Page
				PageState.currentState = window.getLevelPage();
				
			}
		}));
		buttons.add(new CommonButton("keluar_btn", Window.WIDTH/2 + 125, Window.HEIGHT/2, new ClickListener() {
			@Override
			public void onClick() {
				
				// Exit game
				System.exit(1);
			}
		}));
	}
	
	public void init() {
		CreateTextFile.openFile();
		
		try {
			CreateTextFile.addRecords( ( window.getGamePage1().getScore() ) + " " + inputName());
		}catch(NullPointerException e) {
			CreateTextFile.addRecords( ( 0 ) + " " + inputName());
		}
		
		CreateTextFile.closeFile();
	}
	
	public String inputName() {
		
		System.out.println("tes");
		
		JFrame f=new JFrame("Button Example"); 
//		//submit button
//		JButton b=new JButton("Submit");    
//		b.setBounds(100,100,140, 40);    
		        //enter name label
		JLabel label = new JLabel();        
		label.setText("Enter Name :");
		label.setBounds(10, 10, 100, 100);
		        //empty label which will show event after button clicked
		JLabel label1 = new JLabel();
		label1.setBounds(10, 110, 200, 100);
		        //textfield to enter name
		JTextField textfield= new JTextField();
		textfield.setBounds(110, 50, 130, 30);
		        //add to frame
		f.add(label1);
		f.add(textfield);
		f.add(label);
//		f.add(b);    
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
		textfield.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textfield.getText();			}

		});
		
		System.out.println(textfield.getText());
		return textfield.getText();
	}

	@Override
	public void update() {
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameSplashPage, 0, 0, null);
		g.drawImage(gameOverText, 400, 200, null);
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).render(g);
	}
}
