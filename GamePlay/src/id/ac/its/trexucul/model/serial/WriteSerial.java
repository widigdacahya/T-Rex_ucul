package id.ac.its.trexucul.model.serial;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteSerial {
	private static ObjectOutputStream output;

	public static void openFile() {
		try {
			output = new ObjectOutputStream(
			Files.newOutputStream(Paths.get("score_data.ser")));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	public static void addRecords(int score, String playerName, String level) {
		Scanner input = new Scanner(System.in);
		
		openFile();
		
		while (input.hasNext()) {
			try {
				Score record = new Score(score, playerName, level);
				
				output.writeObject(record);
			} catch (NoSuchElementException elementException) {
				System.err.println("Invalid input. Please try again.");
				input.nextLine();
			} catch (IOException ioException) {
				System.err.println("Error writing to file. Terminating.");
				break;
			}
		}
		
		closeFile();
	}

	public static void closeFile() {
		try {
			if (output != null)
			output.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
		}
	}
}
