package randoms;

class Data2 
{
    String name = "Sam";
}
class ParameterPassing3
{
	void func(String x, Data2 d)
	{
		x += " is good";
		d.name += " is good";
	}
	public static void main(String[] args) 
	{
		String Nick = "Nick";
		Data2 d = new Data2();
		ParameterPassing3 p = new ParameterPassing3();
		p.func(Nick, d);
		System.out.println(Nick + " " + d.name);
    }

}
