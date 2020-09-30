import java.util.StringTokenizer;

public class StringTokenizer1 {

	public static void main(String[] args)
	{
		StringTokenizer parse= new StringTokenizer("Brave new world");
		while(parse.hasMoreTokens())System.out.print(parse.nextToken() + "*");
	}

}
