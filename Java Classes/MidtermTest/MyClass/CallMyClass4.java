package MyClass;

import MyClass.MyClass1.MyClass2;

public class CallMyClass4 {
MyClass2 mc2;
void tryMe()
{
	mc2 = new MyClass2();
	mc2.doit();
}
	public static void main(String[] args) {
		CallMyClass4 cmc = new CallMyClass4();
		cmc.tryMe();

	}

}
