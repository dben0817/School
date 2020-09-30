
public class PrimitiveParameterPassing1 {
	public static void convertCode(int inv)
	{
		inv = inv + 100000;
	}

	public static void main(String[] args) {
		int code = 237;
		convertCode(code);
		System.out.println(code);

	}

}
