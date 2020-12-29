package id.ac.its.trexucul.model.serial;

import java.io.Serializable;

public class Score implements Serializable {
	private int score;
	private String playerName;
	private String level;
	
	public Score() {
		this(0, "", "");
	}
	
	public Score(int score, String playerName, String level) {
		this.score = score;
		this.playerName = playerName;
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
}
