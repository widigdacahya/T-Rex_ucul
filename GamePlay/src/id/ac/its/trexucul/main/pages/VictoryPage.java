package id.ac.its.trexucul.main.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.data.Score;
import id.ac.its.trexucul.model.data.ScoreSerialIO;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.handler.KeyboardHandler;
import id.ac.its.trexucul.utils.handler.MouseHandler;
import id.ac.its.trexucul.utils.helper.FontLoader;
import id.ac.its.trexucul.utils.helper.SecondsTimer;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class VictoryPage extends PageState{
	
	private Image victoryText = Assets.getImageText("victory.png");
	protected ArrayList<CommonButton> buttons  = new ArrayList<CommonButton>();
	private CommonButton inputNameButton;
	
	private String textTyped;
	private SecondsTimer timer;

	private boolean finishInput = false;
	private String label = "Masukkan nama Anda:";
	private Font input = FontLoader.loadFont("res/fonts/Russo_One.ttf", 28);
	private Font inputLabel = FontLoader.loadFont("res/fonts/Russo_One.ttf", 20);
	
	private int score = 0;
	private ScoreSerialIO scoreSerial;

	public VictoryPage(Window window) {
		super(window);

		Assets.width = 177;
		Assets.height = 45;
		buttons.add(new CommonButton("coba_lagi_btn", Window.WIDTH/2 - 300, Window.HEIGHT/2, new ClickListener() {
			@Override
			public void onClick() {
				//Go to Level Page
				MouseHandler.leftBtn = false;
				PageState.currentState = window.getLevelPage();
			}
		}));
		buttons.add(new CommonButton("keluar_btn", Window.WIDTH/2 + 125, Window.HEIGHT/2, new ClickListener() {
			@Override
			public void onClick() {
				// Exit game
				MouseHandler.leftBtn = false;
				System.exit(1);
			}
		}));
		
		inputNameButton = new CommonButton("submit_name_btn", Window.WIDTH/2 - (185/2), Window.HEIGHT/2 + 20, new ClickListener() {
			@Override
			public void onClick() {
				finishInput = true;
				MouseHandler.leftBtn = false;
				scoreSerial.addRecord(new Score(score, textTyped));
			}
		}, 185, 76);
		
		textTyped = "";
		timer = new SecondsTimer(0.1f);
	}
	
	public void setLevelType(SelectedGamePage type) {
		finishInput = false;
		textTyped = "";
		scoreSerial = new ScoreSerialIO(type);
	}

	@Override
	public void update() {
		if(finishInput) {
			for(int i = 0; i < buttons.size(); i++)
				buttons.get(i).update();
		} else
			inputNameButton.update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameSplashPage, 0, 0, null);
		g.drawImage(victoryText, 400, 200, null);
		if(finishInput) {
			for(int i = 0; i < buttons.size(); i++)
				buttons.get(i).render(g);
		} else {
			inputNameButton.render(g);

			if(KeyboardHandler.BACK_SPACE && timer.finishCounting())
				textTyped = method(textTyped);
			
			paintInputText(g);
		}
	}
	
	public void paintInputText(Graphics g) {
		FontMetrics fm = g.getFontMetrics(input);
		FontMetrics fmL = g.getFontMetrics(inputLabel);
		
		g.setColor(Color.WHITE);
		g.setFont(inputLabel);
		g.drawString(label, Window.WIDTH/2 - (fmL.stringWidth(label)/2), Window.HEIGHT/2 - 32);
		g.setFont(input);
		g.drawString(textTyped, Window.WIDTH/2 - (fm.stringWidth(textTyped)/2), Window.HEIGHT/2 + 4);
	}
	
	public void updateTextTyped(KeyEvent e) {
		if (!KeyboardHandler.BACK_SPACE && !finishInput)
			textTyped += e.getKeyChar();
	}
	
	public String method(String str) {
	    if (str != null && str.length() > 0) {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
