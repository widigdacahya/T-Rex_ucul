package id.ac.its.trexucul.utils.helper.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import id.ac.its.trexucul.model.data.Score;

public class ReadSerial {
	private static ObjectInputStream input;

	public static void openFile(String fileName) {
		try {
			input = new ObjectInputStream(new FileInputStream(fileName));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			ioException.printStackTrace();
			System.exit(1);
		}
	}

	public static ArrayList<Score> readRecords(String fileName) {
		ArrayList<Score> record = new ArrayList<Score>();
		
		openFile(fileName);
		
		try {
			record = (ArrayList<Score>)input.readObject();
		} catch (EOFException endOfFileException) {
			System.out.printf("%nNo more records%n");
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
		}
		
		closeFile();
		
		return record;
	}
	
	public static int[] readNumData() {
		int[] numData = new int[3];
		openFile("score_data.txt");
		
		try {
			for(int i = 0; i < 3; i++)
				numData[i] = input.readInt();
		} catch (EOFException endOfFileException) {
			System.out.printf("%nNo more records%n");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
		}

		closeFile();
		
		return numData;
	}

	public static void closeFile() {
		try {
			if (input != null)
				input.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
			System.exit(1);
		}
	}
}
