package randoms;

public class Function2 {
	int func(int n)
	{
		int oldest = 0;
		int previous = 1;
		int answer = n;
		
		if (n >=2)
		{
			for (int i = 2; i <= n; i++)
			{
				answer = oldest + previous;
				oldest = previous;
				previous = answer;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
         Function2 f2 = new Function2();
         
         System.out.print(f2.func(1) + " ");
         System.out.print(f2.func(3) + " ");

	}

}
