package scott_problem1;

import java.util.Set;
import java.util.HashSet;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;


public class DuplicateRemover {
	private Set<String> uniqueWords;
	
	DuplicateRemover()	{
		this.uniqueWords = new HashSet<>();
	}
	
	void remove(String dataFile)	{
		File file = new File(dataFile);
		
		try	{
			Scanner scan = new Scanner(file);
			while (scan.hasNext())	{
				this.uniqueWords.add(scan.next());
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
			for (String a : this.uniqueWords)	{
				writer.println(a);
			}
			writer.close();
		}
		catch (IOException e)	{
			System.out.println("Could write to file with name: " + outputFile);
		}
		
	}
}
