package randoms;

public class IndexOfSubString2 {

	public static void main(String[] args) {
		String x = "0123456789";
		int index = x.indexOf('3', 5);
		if (index >= 0)
		    System.out.println(x.substring(0, index));
		else
			 System.out.println(x);


	}

}
