import java.util.Scanner;


public class MoneyCounting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mysingles;
		int myfives;
		int mytens;
		int mymoney;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many 1 dollar bills do you have?");
		
		mysingles = keyboard.nextInt();
		System.out.println("How many 5 dollar bills do you have?");
		myfives = keyboard.nextInt();
		System.out.println("How many 10 dollar bills do you have?");
		mytens = keyboard.nextInt();
		
		mymoney = mysingles + myfives * 5 + mytens * 10;
		System.out.println("You have a total of " + mymoney + " dollars");
		
	}

}
