package id.ac.its.trexucul.model.data;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {

	@Override
	public int compare(Score a, Score b) {
		return b.getScore() - a.getScore();
	}
}
