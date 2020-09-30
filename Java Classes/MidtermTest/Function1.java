
public class Function1 {
    long funcCalc(int n)
    {
    	long result =1;
    	for (int i=2; i <=n;i++)
    		result *=i;
    	
    	return result;
    }
	public static void main(String[] args)
	{
		Function1 mf = new Function1();
		System.out.print(mf.funcCalc(2) + " ");
		System.out.print(mf.funcCalc(3) + " ");
		System.out.print(mf.funcCalc(4) + " ");

	}

}
