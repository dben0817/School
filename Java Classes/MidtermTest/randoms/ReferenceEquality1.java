package randoms;

public class ReferenceEquality1 {
	
	int value = 5;
	void add(int x)
	{
		value += x;
	}

	public static void main(String[] args) {
		ReferenceEquality1 a = new ReferenceEquality1();
		ReferenceEquality1 b = a;
		a.add(5);
		if (a==b)
			System.out.println("a and b are the same");
		else
			System.out.println("a and b are not the same");

	}

}
