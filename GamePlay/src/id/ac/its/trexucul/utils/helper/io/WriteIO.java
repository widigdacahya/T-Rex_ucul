package id.ac.its.trexucul.utils.helper.io;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteIO {
	private static Formatter output;

	public static void openFile(String fileName) {
		try {
			output = new Formatter(fileName);
		} catch (SecurityException securityException) {
			System.err.println("Write permission denied. Terminating.");
			System.exit(1);
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	public static void writeNumData(int[] numData) {
		openFile("score_data.txt");
		
		try {
//			for(int i = 0; i < 3; i++)
//				numData[i] = input.readInt();
			output.format("%d %d %d%n", numData[0], numData[1], numData[2]);
		} catch (FormatterClosedException formatterClosedException) {
			System.err.println("Error writing to file. Terminating.");
		} catch (NoSuchElementException elementException) {
			System.err.println("Invalid input. Please try again.");
		}
		
		closeFile();
	}
	
	public static void closeFile() {
		if (output != null)
			output.close();
	}
	
}
