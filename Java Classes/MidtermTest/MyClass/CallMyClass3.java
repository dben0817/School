import MyClass.MyClass1.MyClass2;
public class CallMyClass3 {
    MyClass2 mc2;
    void tryMe()
    {
    	mc2 = new MyClass2(3);
    	mc2.doit();
    }
	public static void main(String[] args) {
        CallMyClass3 cmc = new CallMyClass3();
        cmc.tryMe();

	}

}
