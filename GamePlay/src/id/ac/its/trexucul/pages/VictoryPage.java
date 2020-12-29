package id.ac.its.trexucul.pages;

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
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.serial.WriteSerial;
import id.ac.its.trexucul.utils.handler.KeyboardHandler;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class VictoryPage extends PageState{
	
	private Image gameOverText = Assets.getImageText("victory.png");
	protected ArrayList<CommonButton> buttons  = new ArrayList<CommonButton>();
	
	private String nameValue;

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
	
	public void inputData(String level) {		
		JFrame f=new JFrame("Button Example");
		
		//submit button
        //enter name label
		JLabel label = new JLabel();        
		label.setText("Enter Name :");
		label.setBounds(10, 10, 100, 100);
		
        //empty label which will show event after button clicked
		JLabel label1 = new JLabel();
		label1.setBounds(10, 110, 200, 100);
		
        //textfield to enter name
		JTextField textfield= new JTextField(10);
		textfield.setBounds(110, 50, 130, 30);
		
        //add to frame
		f.add(label1);
		f.add(textfield);
		f.add(label);
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textfield.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nameValue = textfield.getText();	
				WriteSerial.addRecords(window.getGamePage().getScore(), nameValue, level);		
			}
		});
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
