package id.ac.its.trexucul.main.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import id.ac.its.trexucul.components.CommonButton;
import id.ac.its.trexucul.main.Window;
import id.ac.its.trexucul.model.data.Score;
import id.ac.its.trexucul.model.data.ScoreSerialIO;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.helper.FontLoader;
import id.ac.its.trexucul.utils.listener.ClickListener;

public class ScorePage extends PageState {
	
	private ArrayList<ArrayList<Score>> scoreList = new ArrayList<ArrayList<Score>>();

	private ScoreSerialIO level1IO;
	private ScoreSerialIO level2IO;
	private ScoreSerialIO level3IO;
	private CommonButton backBtn;
	
	private Font font = FontLoader.loadFont("res/fonts/Russo_One.ttf", 18);
	private int[][] textPos = {
			{149, 310}, {538, 310}, {931, 310}
	};

	public ScorePage(Window window) {
		super(window);
		
		//mengubah ukuran tombol main
		Assets.width = 113;
		Assets.height = 43;
		
		//kembali
		backBtn = new CommonButton("kembali", 11, 625, new ClickListener() {
			@Override
			public void onClick() {
				PageState.currentState = window.getMenuPage();
			}
		});
		
		level1IO = new ScoreSerialIO(SelectedGamePage.Satu);
		level2IO = new ScoreSerialIO(SelectedGamePage.Dua);
		level3IO = new ScoreSerialIO(SelectedGamePage.Tiga);
		
		initList();
	}

	@Override
	public void update() {
		backBtn.update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.scoreBG, 0, 0, null);
		backBtn.render(g);
		paintScore(g);
	}
	
	private void initList() {
		scoreList.add(level1IO.getRecords());
		scoreList.add(level2IO.getRecords());
		scoreList.add(level3IO.getRecords());
	}
	
	private void paintScore(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(font);
		
		int index = 0;
		for(ArrayList<Score> scoreL : scoreList) {
			int posAdd = 0;
			
			String text = String.format("%-20s", "Nama");
			g.drawString(text, textPos[index][0], textPos[index][1]+posAdd);
			for(int i = 0; i < scoreL.size(); i++) {
				posAdd += 40;
				text = String.format("%-20s", scoreL.get(i).getPlayerName());
				g.drawString(text, textPos[index][0], textPos[index][1]+posAdd);
			}
			
			posAdd = 0;
			text = String.format("%s", "Score");
			g.drawString(text, textPos[index][0]+127, textPos[index][1]+posAdd);
			for(int i = 0; i < scoreL.size(); i++) {
				posAdd += 40;
				text = String.format("%s", scoreL.get(i).getScore());
				g.drawString(text, textPos[index][0]+127, textPos[index][1]+posAdd);
			}
			index++;
		}
	}
}
