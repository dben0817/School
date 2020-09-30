package MyClass;


public class CallMyClass2 {
	 MyClass1 mc1;
    void tryMe()
    {
    mc1.doit();
    }
	public static void main(String[] args) {
        CallMyClass2 cmc = new CallMyClass2();
        cmc.tryMe();
	}
}