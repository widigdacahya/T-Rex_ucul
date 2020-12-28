package id.ac.its.trexucul.util;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

public class CreateTextFile {

	private static Formatter output; // outputs text to a file
	
	// open file clients.txt
	public static void openFile() {
		try {
			output = new Formatter("score.txt"); // open the file
		} catch (SecurityException securityException){
			System.err.println("Write permission denied. Terminating.");
//			System.exit(1); // terminate the program
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file. Terminating.");
//			System.exit(1); // terminate the program
		}
	}

	// add records to file
	public static void addRecords(String input) {
//		Scanner input = new Scanner(System.in);
//		System.out.printf("%s? %n","Enter your name");
		
		
		try{// output new record to file; assumes valid input
			output.format("%s", input);

		} catch (FormatterClosedException formatterClosedException){
			System.err.println("Error writing to file. Terminating.");
		} catch (NoSuchElementException elementException){
			System.err.println("Invalid input. Please try again.");
			System.out.print(input);// discard input so user can try again
		} 
		
		
		
	}
	
	// close file
	public static void closeFile() {
		if (output != null)
			output.close();
	}
}

/*

100	Bob	Blue	24.98
200	Steve	Green	-345.67
300	Pam	White	0.00
400	Sam	Red	-42.16
500	Sue	Yellow	224.62

^Z

[CAPSLOCK ON] <CTRL> + z

 */ 
