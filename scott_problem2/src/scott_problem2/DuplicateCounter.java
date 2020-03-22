package scott_problem2;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	private Map<String, Integer> wordCounter;
	
	DuplicateCounter()	{
		this.wordCounter = new HashMap<>();
	}
	
	void count(String dataFile)	{
		File file = new File(dataFile);
		
		try	{
			Scanner scan = new Scanner(file);
			while (scan.hasNext())	{
				String word = scan.next();
				if (wordCounter.containsKey(word))	{
					wordCounter.put(word, wordCounter.get(word) + 1);
				}
				else	{
					wordCounter.put(word, 1);
				}
			}
			scan.close();
		}
		catch (IOException e)	{
			System.out.println("Error, could not open file.");
			return;
		}
	}
	
	void write(String outputFile)	{
		File file = new File(outputFile);
		file.delete();
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Could not create new file with name: " + outputFile);
		}
		
		try	{
			PrintStream writer = new PrintStream(file);
			for (String a : this.wordCounter.keySet())	{
				writer.println(a + ": " + Integer.toString(this.wordCounter.get(a)));
			}
			writer.close();
		}
		catch (IOException e)	{
			System.out.println("Could write to file with name: " + outputFile);
		}
		
	}
}
