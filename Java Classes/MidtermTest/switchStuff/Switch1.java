package switchStuff;

import java.util.Scanner;

public class Switch1 {
	public static void main(String[] args) {
		System.out.println("Enter in a number:");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		switch(x)
		{
		case 1:
		case 3:
		case 5:
		case 7:
			System.out.println("odd");
			break;
		case 0:
		case 2:
		case 4:
		
		case 6:
			System.out.println("even");
			break;
		default:
			System.out.println("Greater than 7");
			break;
		}
	}

}
