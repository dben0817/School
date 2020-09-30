package randoms;

public class IndexOf1 {

	public static void main(String[] args) {
		String a = "Java is great.";
		int len = a.length();
		int index = a.indexOf('.');
		if (index < 0)
			System.out.println("index is negative");
		else if (index > len)
			System.out.println("index is greater than len");
		else if (index < len)
			System.out.println("index is less than len");
		else
			System.out.println("index is equal to len");

	}

}
