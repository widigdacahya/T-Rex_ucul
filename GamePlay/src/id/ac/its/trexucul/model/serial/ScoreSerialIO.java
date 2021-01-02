package id.ac.its.trexucul.model.serial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreSerialIO {
	
	private String fileName;
	
	public ScoreSerialIO(String fileName) {
		this.fileName = fileName;
	}
	
	public void addRecord(Score data) {
		ArrayList<Score> scoreList = ReadSerial.<Score>readRecords(fileName);
		
		if (scoreList != null) {
			if (scoreList.size() > 5) {
				scoreList.add(data);
				Collections.sort(scoreList, new ScoreComparator());
				scoreList.remove(5);
			} else {
				scoreList.add(data);
				Collections.sort(scoreList, new ScoreComparator());
			}
		} else
			scoreList.add(data);
		
		WriteSerial.<Score>addRecords(scoreList, fileName);
	}
}
