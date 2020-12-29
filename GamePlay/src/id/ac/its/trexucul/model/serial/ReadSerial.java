package id.ac.its.trexucul.model.serial;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadSerial {
	private static ObjectInputStream input;

	public static void openFile() {
		try {
			input = new ObjectInputStream(
			Files.newInputStream(Paths.get("score_data.ser")));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}

	public static void readRecords() {
		openFile();
		
		try {
			while (true) {
				Score record = (Score) input.readObject();
				
				System.out.printf("%s%nNama: %s%nScore: %s%n",
								record.getLevel(), record.getPlayerName(),
								record.getScore());
			}
		} catch (EOFException endOfFileException) {
			System.out.printf("%nNo more records%n");
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
		}
		
		closeFile();
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
