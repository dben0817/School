
public class ReferenceEquality2 {

	public static void main(String[] args) {
		String a = "New";
		String b = a;
		a += "t";
		if (a == b)
			System.out.println("a and b are the same");
		else
			System.out.println("a and b are not the same");

	}

}
