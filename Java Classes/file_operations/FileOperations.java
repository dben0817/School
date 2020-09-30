package file_operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

//figure out your imports
public class FileOperations
{
StringTokenizer parseCommand;
Scanner scan, scan2 = null;
PrintStream ps = null;
String nextLine;
public void delete()
{
	File delFile = getFile();
	if (delFile.exists())
	  {
// code for handling the delete command
// Make sure you check the return code from the
// File delete method to print out success/failure status
	  if (delFile.delete())
		  System.out.println(delFile + " has been deleted.");
	  else
		  System.out.println(delFile + " could not be deleted.");}
	else
		System.out.println(delFile + " does not exist, no file to delete.");
}
public void rename()
{
// code for handling the rename command
	File myFile = getFile();
	if (myFile.exists())
	  {File renFile = getFile();
// Make sure you check the return code from the
// File rename method to print out success/failure status
	  if (myFile.renameTo(renFile))
		  System.out.println(myFile + " was renamed to: " + renFile);
	  else
		  System.out.println(myFile + " could not be renamed to: " + renFile);}
	else
		System.out.println(myFile + " does not exist. Unable to rename.");
}
public void list()
{
// code for handling the list command
	File lFile = getFile();
	if (lFile.exists())
	  {String dirs[] = lFile.list();
	  for (int id = 0;id < dirs.length;id++)
	  {
		System.out.println(dirs[id]);
	  }}
	else
		System.out.println(lFile + " does not exist. Unable to get directory.");
}
public void size()
{
// code for handling the size command
	File sFile = getFile();
	if (sFile.exists())
	  {long size = sFile.length();
	  System.out.println(sFile + " is " + size + " bytes");}
	else
		System.out.println(sFile + " does not exist. Unable to get file size.");
}
public void lastModified()
{
// code for handling the lastModified command
	File lmod = getFile();
	if (lmod.exists())
	  {long time = lmod.lastModified();
      Date d = new Date(time);
      System.out.println(lmod + " was last modified on: " + d);}
	else
		System.out.println(lmod + " does not exist. Unable to get last modified.");
}
public void mkdir()
{
// code for handling the mkdir command
	File nd = getFile();
// Make sure you check the return code from the
// File mkdir method to print out success/failure status
	if (nd.mkdir())
		System.out.println(nd + " is now a Directory");
	else
		System.out.println(nd + " Directory could not be created");
}
public void createFile()
{
// code for handling the createFile command
	File nf = getFile();
	try {
		nf.createNewFile();
			System.out.println("created file for "+ nf);
			FileOutputStream nfo = new FileOutputStream(nf);
            ps = new PrintStream(nfo);
			while (parseCommand.hasMoreTokens())
				ps.println(parseCommand.nextToken());
	} catch (IOException e) {
            System.out.println("file could not be created for "+ nf.getAbsolutePath());
	}
	finally
	{
		if (ps != null)
			ps.close();
	}

}
public void printFile()
{
// code for handling the printFile command
	File pf = getFile();
	try {
		FileInputStream fis = new FileInputStream(pf);
		scan2 = new Scanner(fis);
		while(scan2.hasNext())
	      System.out.println(scan2.next());
	} catch (FileNotFoundException e) {
       System.out.println(pf + " does not exist, could not print.");
	}
    finally
    {
    	if (scan2 != null)
    		scan2.close();
    }
}

void printUsage()
{
// process the "?" command
	System.out.println("Valid commands(surrounded by []): \n[createFile] [printFile] [lastModified] [size] [rename] [mkdir] [delete] [list] [quit]");
}

// useful private routine for getting next string on the command line
private String getNextToken()
{
if (parseCommand.hasMoreTokens())

return parseCommand.nextToken();
else
return null;
}

// useful private routine for getting a File class from the next string on the command line
private File getFile()
{
File f = null;
String fileName = getNextToken();
if (fileName == null)
System.out.println("Missing a File name");
else
f = new File(fileName);
return f;
}
public boolean processCommandLine(String line)
{
// if line is not null, then setup the parseCommand StringTokenizer. Pull off the first string
	if (line != null)
		parseCommand = new StringTokenizer(line);
// using getNextToken() and treat it as the "command" to be processed.
    String command = getNextToken();
// It would be good to print out the command you are processing to make your output more readable.
	System.out.println("===>");
    System.out.println("Processing: " + line);
// If you are using at least java 1.7, you can use a switch statement on command.
	if (line != null)
	{
    	switch(command){
    	  
    	  case "?":
    	      printUsage();
    	      return true;
		case "createFile":
    	      createFile();
    	      return true;
		case "printFile":
    	      printFile();
    	      return true;
		case "lastModified":
    	      lastModified();
    	      return true;
		case "size":
    	       size();
    	       return true;
		case "rename":
    	       rename();
    	       return true;
		case "mkdir":
    	       mkdir();
    	       return true;
		case "delete":
    	       delete();
    	       return true;
		case "list":
    	       list();
               return true;
		default:
    	   return false;  
    	  
    	}
	}
// return false if command is quit or the line is null, otherwise return true.
	else
		return false;

}



void processCommandFile(String commandFile)
{
// Open up a scanner based on the commandFile file name. Read the commands from this file

	try {
         scan = new Scanner(new FileInputStream(commandFile));
// using the Scanner line by line. For each line read, call processCommandLine. Continue reading
// from this file as long as processCommandLine returns true and there are more lines in the file.
		 while (scan.hasNextLine() && processCommandLine(scan.nextLine()))
	    	{
			 nextLine = scan.nextLine();
			processCommandLine(nextLine);
	    	System.out.println("**********************************************");
		    }
	}
	 catch (FileNotFoundException e)
	{
     System.out.println(commandFile + " does not exist.");
	}
// At the end, close the Scanner.
	finally
	{
		if (scan != null)	
		scan.close();
	}


}

public static void main(String[] args)
{
FileOperations fo= new FileOperations();
for (int i=0; i < args.length; i++)
{
System.out.println("\n\n============ Processing " + args[i] +" =======================\n");
fo.processCommandFile(args[i]);
}
System.out.println("Done with FileOperations");
}
}