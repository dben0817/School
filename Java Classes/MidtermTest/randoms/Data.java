package randoms;


public class Data 
{
    int age = 15;
}
class ParameterPassing2 
{
	void func(int x, Data d)
	{
		x += 1;
		d.age += 1;
	}
	public static void main(String[] args) {

        int num = 1;
        Data d = new Data();
        ParameterPassing2 p = ParameterPassing2();
        p.func(num, d);
        System.out.println(num + " " + d.age);
	}

}
