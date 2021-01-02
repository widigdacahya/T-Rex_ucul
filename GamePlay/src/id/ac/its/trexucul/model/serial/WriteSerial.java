package id.ac.its.trexucul.model.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteSerial {
	private static ObjectOutputStream output;

	public static void openFile(String fileName) {
		try {
//			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("score_data.ser"), true));
			output = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			ioException.printStackTrace();
			System.exit(1);
		}
	}

	public static <T> void addRecords(ArrayList<T> itemArr, String fileName) {		
		openFile(fileName);
		
		try {
			output.writeObject(itemArr);
		} catch (NoSuchElementException elementException) {
			System.err.println("Invalid input. Please try again.");
		} catch (IOException ioException) {
			System.err.println("Error writing to file. Terminating.");
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
