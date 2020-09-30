package reading_with_exceptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
public class Reading_With_Exceptions {
	void process(String inputFilename)
	{
		Scanner scan = null;
		FileOutputStream fo = null;
		PrintStream ps = null;
		int numIntsToRead = 0;
		String outputName = "";
		try {                                                                    //try to read the file of the current arg
			FileInputStream fi = new FileInputStream(inputFilename);             //pulls into FileInputStream to scan
			scan = new Scanner(fi);
			   outputName = scan.next();                                        //scans the first entry as output variable
			if (scan.hasNextInt())                                              //checks for number of entries to scan for within the document
				{numIntsToRead = scan.nextInt();}                               //records number of entries requested when there is one, otherwise stays the default of 0
				fo = new FileOutputStream(outputName);
				ps = new PrintStream(fo);
				copyNumbers(scan, ps, numIntsToRead);                          //calls the copyNumbers function to write to file

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
		printToScreen(outputName);
	}//end of process
	void copyNumbers(Scanner scan, PrintStream ps, int numIntsToRead)
	{
		int a = 0;
		int i = 0;
		for (int in = 0;in < numIntsToRead;in++)                          //runs through checking numbers as many times as numIntsToRead states
        	 {
			   
			    if (scan.hasNextInt())                                  
        	        {a = scan.nextInt();                                 
                  if (i < 9)  {
                	  ps.print(a + " ");
                	  i++;}
                	  else
                		  {ps.println(a);
                          i =0;}
        	        }                             //if entry is a number, prints it to the file
                else if (scan.hasNext())
        	        {scan.next();                                            //if the entry is not a number, skips it and moves on to the next
        	        }
			    }
             
	}//end of copyNumbers

	public static void main(String[] args) {
		Reading_With_Exceptions rwe = new Reading_With_Exceptions();
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