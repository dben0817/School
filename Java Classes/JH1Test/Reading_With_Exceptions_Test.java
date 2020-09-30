package JH1Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Reading_With_Exceptions_Test {
	void process(String inputFilename)
	{
		Scanner scan = null;
		FileOutputStream fo = null;
		PrintStream ps = null;
		int numIntsToRead = 0;
		String outputName = "";
		try {
			FileInputStream fi = new FileInputStream(inputFilename);
			scan = new Scanner(fi);
			   outputName = scan.next();
			if (scan.hasNextInt())
				{numIntsToRead = scan.nextInt();}
				fo = new FileOutputStream(outputName);
				ps = new PrintStream(fo);
				copyNumbers(scan, ps, numIntsToRead);

		}
		catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
		}

		finally
		{
			if (scan != null)
				scan.close();
			if (ps != null)
				ps.close();
		}
		printToScreen(outputName); //?
	}
	void copyNumbers(Scanner scan, PrintStream ps, int numIntsToRead)
	{
		int a = 0;
		for (int in = 0;in < numIntsToRead;in++)
        	 {if (scan.hasNextInt())
        	   {a = scan.nextInt();
                ps.print(a + " ");}
           else if (scan.hasNext())
        	    {scan.next();
        	    }
             }
	}

	public static void main(String[] args) {
		Reading_With_Exceptions_Test rwe = new Reading_With_Exceptions_Test();
		for (int i=0; i < args.length; i++)
		{
			System.out.println("\n\n=========== Processing "+ args[i] + " ==========\n");
			rwe.process(args[i]);
		}
	}
	// For the last step, we Copy the contents of the file to the screen
	private void printToScreen(String filename)
	{
		Scanner scan = null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			scan = new Scanner(fis);
			System.out.println(filename + " created with the following output:");
			while (scan.hasNextLine())
			{
				System.out.println(scan.nextLine());
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("printToScreen: can't open: " + filename);
		}
		finally
		{
			if (scan != null)
				scan.close();
		}
	}// end of printToScreen
} // end of class


// Here is where your work goes ... Steps that you will need to do:
// 1.) Create a Scanner from the inputFilename. Catch exceptions from errors.
// 2.) Read the first String from the file and use it to create a PrintStream
// catching appropriate exceptions
// 3.) Using hasNextInt and nextInt, carefully read the count integer.
// I recommend -1 for a count value if it is bad to indicate reading ALL
// 4.) Use copyNumbers method described below to complete the job
// 5.) Close Scanner and PrintStream objects
// 6.) Call printToScreen to copy the output file to the screen

// The following routine is called to complete the job of copying integers to
// the output file:
// scan - a Scanner object to copy integers from
// ps - A PrintStream to write the integers to
// numIntsToRead - number of integers to read. A value of -1 ==> read all integers


// hasNext() can be used to see if the scan object still has data
// Note that hasNextInt() can be used to see if an integer is present
// nextInt() will read an integer
// next() can be used to skip over bad integers
