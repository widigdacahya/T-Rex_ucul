package id.ac.its.trexucul.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
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
import id.ac.its.trexucul.utils.helper.FontLoader;
import id.ac.its.trexucul.utils.helper.SecondsTimer;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class VictoryPage extends PageState{
	
	private Image gameOverText = Assets.getImageText("victory.png");
	protected ArrayList<CommonButton> buttons  = new ArrayList<CommonButton>();
	
	private String nameValue;
	private SelectedGamePage type;
	private boolean initTF = false;
	private JTextField textfield;
	
	private String level;
	private Rectangle r;
	private String textTyped;
	private SecondsTimer timer;

	public VictoryPage(Window window) {
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
		buttons.add(new CommonButton("submit_name_btn", Window.WIDTH/2 - (185/2), Window.HEIGHT/2 + 20, new ClickListener() {
			@Override
			public void onClick() {
				// Exit game
				System.exit(1);
			}
		}, 185, 76));
		
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
		
		r = new Rectangle(200,200,250,30);
		textTyped = "";
		timer = new SecondsTimer(0.1f);
	}
	
	public void inputData(String level, Graphics g) {
        //textfield to enter name
		textfield.printAll(g);
	}
	
	public void setLevelType(SelectedGamePage type) {
		this.type = type;
		
		if (type == SelectedGamePage.Satu)
			level = "Level 1";
		else if (type == SelectedGamePage.Dua)
			level = "Level 2";
		else if (type == SelectedGamePage.Tiga)
			level = "Level 3";
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

		if(KeyboardHandler.BACK_SPACE && timer.finishCounting())
			textTyped = method(textTyped);
		
		paintComponent(g);
	}
	
	public void paintComponent(Graphics g) {
		String label = "Masukkan nama Anda:";
		Font input = FontLoader.loadFont("res/fonts/Russo_One.ttf", 28);
		Font inputLabel = FontLoader.loadFont("res/fonts/Russo_One.ttf", 20);
		FontMetrics fm = g.getFontMetrics(input);
		FontMetrics fmL = g.getFontMetrics(inputLabel);
		
		g.setColor(Color.WHITE);
		g.setFont(inputLabel);
		g.drawString(label, Window.WIDTH/2 - (fmL.stringWidth(label)/2), Window.HEIGHT/2 - 32);
		g.setFont(input);
		g.drawString(textTyped, Window.WIDTH/2 - (fm.stringWidth(textTyped)/2), Window.HEIGHT/2 + 4);
	}
	
	public void updateTextTyped(KeyEvent e) {
		if (!KeyboardHandler.BACK_SPACE)
			textTyped += e.getKeyChar();
	}
	
	public String method(String str) {
	    if (str != null && str.length() > 0) {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
}
