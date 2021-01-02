package id.ac.its.trexucul.model.serial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.helper.io.ReadIO;
import id.ac.its.trexucul.utils.helper.io.ReadSerial;
import id.ac.its.trexucul.utils.helper.io.WriteIO;
import id.ac.its.trexucul.utils.helper.io.WriteSerial;

public class ScoreSerialIO {
	
	private String fileName;
	private SelectedGamePage type;
	
	private int[] numData;
	private int indexNum;
	
	public ScoreSerialIO(SelectedGamePage type) {
		String fileName = null;
		this.type = type;
		
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
		System.out.print(numData);
	}
	
	public void addRecord(Score data) {
		if (numData[indexNum] > 0) {
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
			numData[indexNum] = scoreList.size();
		} else {
			ArrayList<Score> scoreList = new ArrayList<Score>();
			scoreList.add(data);
			WriteSerial.<Score>addRecords(scoreList, fileName);
			numData[indexNum]++;
		}
		
		WriteIO.writeNumData(numData);
	}
}
