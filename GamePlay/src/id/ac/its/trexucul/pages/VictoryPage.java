package id.ac.its.trexucul.pages;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.model.serial.WriteSerial;
import id.ac.its.trexucul.utils.handler.KeyboardHandler;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class VictoryPage extends PageState{
	
	private Image gameOverText = Assets.getImageText("victory.png");
	protected ArrayList<CommonButton> buttons  = new ArrayList<CommonButton>();
	
	private String nameValue;
	private SelectedGamePage type;
	private boolean initTF = false;
	private JTextField textfield;

	public VictoryPage(Window window, SelectedGamePage type) {
		super(window);
		
		this.type = type;

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
		
		textfield= new JTextField(10);
		textfield.setBounds(1000, 50, 100, 30);
//		textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		textfield.setEditable(true);
		textfield.setBackground(Color.WHITE);
		textfield.setForeground(Color.BLACK);
		
		textfield.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nameValue = textfield.getText();	
//				WriteSerial.addRecords(window.getGamePage().getScore(), nameValue, level);		
			}
		});
	}
	
	public void inputData(String level, Graphics g) {
        //textfield to enter name
		textfield.printAll(g);
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
		
		if (type == SelectedGamePage.Satu)
			inputData("Level 1", g);
		else if (type == SelectedGamePage.Dua)
			inputData("Level 2", g);
		else if (type == SelectedGamePage.Tiga)
			inputData("Level 3", g);
	}
}
