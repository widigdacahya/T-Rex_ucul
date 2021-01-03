package id.ac.its.trexucul.model.data;

import java.io.Serializable;

public class Score implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int score;
	private String playerName;
	
	public Score() {
		this(0, "");
	}
	
	public Score(int score, String playerName) {
		this.score = score;
		this.playerName = playerName;
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
}
