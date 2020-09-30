package person;

public class CallPerson3 {

	public static void main(String[] args) {
		Person p = new Person("Joe", 50);
		Person p2;
		p2 =p;
		p2.setPerson("Jane", 25);
		System.out.println(p);
	}

}
