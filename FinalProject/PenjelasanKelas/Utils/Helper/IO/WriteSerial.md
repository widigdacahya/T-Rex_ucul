# ☕️ WriteSerial Class

****
### 💡Penjelasan:
Kelas ini berfungsi untuk menyimpan hasil pertandingan yang telah dimainkan user.

### 💡Atribut dan Fungsi:
Ada 1 atribut:   
- output: variable yang menunjuk pada file yang digunakan untuk menyimpan.

Ada 4 jenis fungsi:
- openFile: load the serial file.
- addRecords: writing the records (name, score, level) to the file.
- writeNumData: set the sum of the record each level.
- closeFile.

****
```java
package id.ac.its.trexucul.utils.helper.io;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import id.ac.its.trexucul.model.data.Score;

public class WriteSerial {
	private static ObjectOutputStream output;

	public static void openFile(String fileName) {
		try {
//			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("score_data.ser"), true));
			output = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	public static void addRecords(ArrayList<Score> itemArr, String fileName) {		
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
	
	public static void writeNumData(int[] numData) {
		openFile("score_data.txt");
		
		try {
			for(int i = 0; i < 3; i++)
				output.writeInt(numData[i]);
		} catch (EOFException endOfFileException) {
			System.out.printf("%nNo more records%n");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
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
```
