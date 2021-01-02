package id.ac.its.trexucul.model.serial;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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

	public static <T> ArrayList<T> readRecords(String fileName) {
		ArrayList<T> record = new ArrayList<T>();
		
		openFile(fileName);
		
		try {
			record = (ArrayList<T>) input.readObject();
			
//			System.out.printf("%s%nNama: %s%nScore: %s%n",
//							record.getLevel(), record.getPlayerName(),
//							record.getScore());
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
