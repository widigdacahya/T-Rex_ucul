package id.ac.its.trexucul.utils.helper.io;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadIO {
	private static Scanner input;
	
	public static void openFile(String fileName) {
		try {
			input = new Scanner(Paths.get(fileName));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	
	public static int[] readNumData() {
		int[] numData = new int[3];
		openFile("score_data.txt");
		
		try {
			for(int i = 0; i < 3; i++)
				numData[i] = input.nextInt();
		} catch (NoSuchElementException elementException){
			System.err.println("File improperly formed. Terminating.");
		} catch (IllegalStateException stateException){
			System.err.println("Error reading from file. Terminating.");
		}
		
		closeFile();
		
		return numData;
	}
	
	public static void closeFile() {
		if (input != null)
			input.close();
	} 
}
