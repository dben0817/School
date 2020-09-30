import java.util.Scanner;


public class BillsNeeded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myDollars;
		int my10s;
		int my5s;
		int my1s;
		int myChange;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How much money will you be carrying?");
	    myDollars = keyboard.nextInt(); 
	    
	    my10s = myDollars / 10;
	    myChange = myDollars % 10;
	    
	    my5s = myChange / 5;
	    my1s = myChange % 5;
	    
	    System.out.println("You should have:");
	    System.out.println(my10s + " ten dollar bills");
	    System.out.println(my5s + " five dollar bills");
	    System.out.println(my1s + " one dollar bills");
	}

}
