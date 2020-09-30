package file_client;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FileClient extends EchoClient {

	void communicate(InputStream is, OutputStream os)
	{

		@SuppressWarnings("resource")
		Scanner scanSocket = new Scanner(is);

		PrintStream psSocket = new PrintStream(os, true);


		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Start entering text to echo ....");
		String fromKeyboard = keyboard.nextLine();
		
		while (!fromKeyboard.equals("quit"))
		{
			psSocket.println(fromKeyboard);  //write to socket
			while (scanSocket.hasNextLine())
			{
				String sFromSocket = scanSocket.nextLine(); //read from socket
				if (sFromSocket.length() > 0)
			      System.out.println("received from server: " + sFromSocket);
				else
					break;
			}
			fromKeyboard = keyboard.nextLine();
		}
	}
	
	
	public static void main(String [] args) {

		FileClient fileClient = new FileClient();
		fileClient.startup(args);
		System.out.println("Exitting main");
	}
}
