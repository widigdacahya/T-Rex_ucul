package id.ac.its.trexucul.model.data;

import java.util.ArrayList;
import java.util.Collections;

import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.helper.io.ReadIO;
import id.ac.its.trexucul.utils.helper.io.ReadSerial;
import id.ac.its.trexucul.utils.helper.io.WriteIO;
import id.ac.its.trexucul.utils.helper.io.WriteSerial;

public class ScoreSerialIO {
	
	private String fileName;
	private int[] numData;
	private int indexNum;
	
	public ScoreSerialIO(SelectedGamePage type) {
		String fileName = null;
		if (type == SelectedGamePage.Satu) {
			fileName = "score_data_level_1.txt";
			indexNum = 0;
		} else if (type == SelectedGamePage.Dua) {
			fileName = "score_data_level_2.txt";
			indexNum = 1;
		} else if (type == SelectedGamePage.Tiga) {
			fileName = "score_data_level_3.txt";
			indexNum = 2;
		}
		
		this.fileName = fileName;
		this.numData = ReadIO.readNumData();
	}
	
	public void addRecord(Score data) {
		if (numData[indexNum] > 0) {
			ArrayList<Score> scoreList = ReadSerial.readRecords(fileName);
			
			if (scoreList != null) {
				if (scoreList.size() >= 5) {
					scoreList.add(data);
					Collections.sort(scoreList, new ScoreComparator());
					scoreList.remove(5);
				} else {
					scoreList.add(data);
					Collections.sort(scoreList, new ScoreComparator());
				}
			} else
				scoreList.add(data);
			
			WriteSerial.addRecords(scoreList, fileName);
			numData[indexNum] = scoreList.size();
		} else {
			ArrayList<Score> scoreList = new ArrayList<Score>();
			scoreList.add(data);
			WriteSerial.addRecords(scoreList, fileName);
			numData[indexNum]++;
		}
		
		WriteIO.writeNumData(numData);
	}
	
	public ArrayList<Score> getRecords() {
		ArrayList<Score> scoreList = new ArrayList<Score>();
		this.numData = ReadIO.readNumData();
		
		if (numData[indexNum] > 0) {
			scoreList = ReadSerial.readRecords(fileName);
		} else
			scoreList.add(new Score(0, ""));
		
		return scoreList;
	}
}
