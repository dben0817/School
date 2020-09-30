package stack_indent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

class BadIndentationException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	BadIndentationException(String error)
	{
		super(error);
	}
}



public class IndentChecker {
	Stack<Integer> indentStack = new Stack<Integer>();

	private int findFirstNonBlank(String line)
	{
		int start = -1;
		for (int charLocation = 0;charLocation < line.length();charLocation++)
		{
			char c = line.charAt(charLocation);
		  if (!Character.isSpaceChar(c)) {
			  start = charLocation;
		      return start;
		  }
		  
		}
		return start;
	}

	private void processLine(String line, int lineNumber)
	{
		int index = findFirstNonBlank(line);

		if (index >=0)
		{
			if (indentStack.empty())
			{
				indentStack.push(index);
			}
			if (index > indentStack.peek())
			{
				indentStack.push(index);
			}
			while (index < indentStack.peek())
			{ 
				indentStack.pop();
			}
			if (!indentStack.empty())
			{
				if (index != indentStack.peek())
				   System.out.println("Bad Indentation " + line.charAt(index) + " at Line: " + lineNumber);
			}
		}
	}

	public void checkIndentation(String fileName)
	{
		indentStack.clear();

		Scanner input = null;
		try {
			input = new Scanner (new File(fileName));
			// read through the file line by line
			// for each line, call processLine to check indentation
			int lineNumber = 1;
			while (input.hasNextLine())
			{
				processLine(input.nextLine(), lineNumber++);
			}
		} 
		catch (BadIndentationException error)
		{
			System.out.println(error);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Can't open file:"+fileName);
		}
		finally
		{
			if (input != null)
				input.close();
		}
	}


	public static void main(String[] args) {
		IndentChecker indentChecker = new
				IndentChecker();

		for (int i=0; i < args.length; i++)
		{
			System.out.println("Processing file: " +
					args[i]);
			indentChecker.checkIndentation(args[i]);
		}
	}
}