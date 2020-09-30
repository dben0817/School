package file_server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileServer extends EchoServer
{
	PrintStream clientPS = null; 
    StringTokenizer parseCommand;


    public void delete()
    {
        File f = getFile();
        if (f != null)
        {
            clientPS.println("deleting "+ f.getAbsolutePath());
            if (f.delete())
                clientPS.println(" Successful delete");
            else
                clientPS.println(" unSuccessful delete");
        }
    }
    public void rename()
    {
        File f = getFile();
        if (f != null)
        {
            clientPS.println("renaming "+ f.getAbsolutePath());
            File f2 = getFile();
            if (f.renameTo(f2))
                clientPS.println(" Successful rename");
            else
                clientPS.println(" unSuccessful rename");
        }

    }
    public void list()
    {
        File f = getFile();
        if (f != null)
        {
            clientPS.println("Listing files for "+ f.getAbsolutePath());
            if (f.exists())
            {
                String[] files = f.list();
                if (files != null)
                {
                    for (int i=0; i < files.length; i++)
                        clientPS.println(files[i]);
                }
            }
            else
                clientPS.println("list error -  Non-existent:" + f.getAbsolutePath());
        }
    }
    public void size()
    {
        File f = getFile();
        if (f != null)
        {
            if (f.exists())
            {
                clientPS.print("size for "+ f.getAbsolutePath());
                long len = f.length();
                clientPS.println(" is = "+len);
            }
            else
                clientPS.println("size error -  Non-existent:" + f.getAbsolutePath());
        }

    }
    public void lastModified()
    {
        File f = getFile();
        if (f != null)
        {
            if (f.exists())
            {
                clientPS.println("lastModified for "+ f.getAbsolutePath());
                long date = f.lastModified();
                clientPS.println(" date="+new Date(date));
            }
            else
                clientPS.println("lastModified error Non-existent:" + f.getAbsolutePath());
        }
    }
    public void mkdir()
    {
        File f = getFile();
        if (f != null)
        {
            if (f.mkdir())
                clientPS.println("mkdir successful: " + f.getAbsolutePath());
            else
                clientPS.println("mkdir unsuccessful: " + f.getAbsolutePath());
        }
    }
    public void createFile()
    {
        File f = getFile();
        if (f!= null)
        {
            try {
                PrintWriter pw = new PrintWriter(f);
                String token = getNextToken();
                while (token != null)
                {
                    pw.println(token);
                    token = getNextToken();
                }
                pw.close();
                clientPS.println("created file for "+ f.getAbsolutePath());
            } catch (FileNotFoundException e) {
                clientPS.println("createFile can't create: "+ f.getAbsolutePath());
            }
        }
    }

    public void printFile()
    {
        File f = getFile();
        if (f != null)
        {
            try {
                Scanner scan = new Scanner(f);
                while (scan.hasNextLine())
                {
                    clientPS.println(scan.nextLine());
                }
                scan.close();
                clientPS.println("printed file for "+ f.getAbsolutePath());
            } catch (FileNotFoundException e) {
                clientPS.println("printFile can't open: "+ f.getAbsolutePath());
            }
        }
    }

    void printUsage()
    {
        clientPS.println("?");
        clientPS.println("quit");
        clientPS.println("delete filename");
        clientPS.println("rename oldFilename newFilename");
        clientPS.println("size filename");
        clientPS.println("lastModified filename");
        clientPS.println("list dir");
        clientPS.println("printFile filename");
        clientPS.println("createFile filename <remaining tokens written to file>");
        clientPS.println("mkdir dir");
    }

    private String getNextToken()
    {
        if (parseCommand.hasMoreTokens())
            return parseCommand.nextToken();
        else
            return null;
    }
    public File getFile()
    {
        File f = null;
        String fileName = getNextToken();
        if (fileName == null)     
            clientPS.println("Missing a File name");                  
        else
            f = new File(fileName);      

        return f;
    }


    public boolean processCommandLine(String line)    
    {
        if (line == null)
            return false;

        boolean retval = true;
        parseCommand = new StringTokenizer(line);
        String cmd = getNextToken();
        if (cmd == null)
        {
            clientPS.println("No command specified");                
        }
        else
        {  
            System.out.println("Executing Command: " + line);
            switch(cmd)
            {
            case "?":
                printUsage();
                break;

            case "quit":                    
                retval = false;
                clientPS.println("Quitting Session, Goodbye.");
                break;
            case "delete":
                delete();
                clientPS.println("File Deleted");
                break;
            case "rename":
                rename();
                break;
            case "size":
                size();
                break;
            case "lastModified":
                lastModified();
                break;
            case "list":
                list();
                break;
            case "printFile":
                printFile();
                break;
            case "createFile":
                createFile();
                break;
            case "mkdir":
                mkdir();
                break;
            default:
                System.out.println("Unrecognized Command");
                clientPS.println("Unrecognized command: "+cmd);
                break;

            }
        }
        clientPS.println( );
        return retval;
    }

    public void processStream (InputStream is, OutputStream os)
	{
		System.out.println("EchoServer.processStream begins");
		Scanner input = new Scanner(is);
		clientPS = new PrintStream(os);
		
		while (input.hasNextLine())
		{
			processCommandLine(input.nextLine());
		}
		input.close();
		clientPS.close();
		System.out.println("Exitting processStream");
	} 
    
	public static void main(String[] args) {
		FileServer fs = new FileServer();
		fs.monitorServer();
		System.out.println("Exitting EchoServer");
	}
    
   /* void processCommandFile(String commandFile)
    {
        File f = new File(commandFile);
        Scanner inputScan = null;
        try {
            inputScan = new Scanner(f);
        } catch (FileNotFoundException e) {
            clientPS.println("command file does not exist: "+f.getAbsolutePath());
            return;
        }
        
        String command;
        do
        {
            clientPS.println("===>");
            if (inputScan.hasNext())
                command = inputScan.nextLine();
            else
                break;
            clientPS.println("Processing: "+command);
        } while (processCommandLine(command));

        clientPS.println("Done with command file: "+ f.getAbsolutePath());
        inputScan.close();
    }
    public static void main(String[] args) 
    {
        FileServer fs= new FileServer();
        for (int i=0; i < args.length; i++)
        {
            //clientPS.println("\n\n============  Processing " + args[i] +" =======================\n"); //need to find a way to fix this
            fs.processCommandFile(args[i]);
        }

       // clientPS.println("Done with FileOperations"); //need to find a way to fix this
    }*/
}