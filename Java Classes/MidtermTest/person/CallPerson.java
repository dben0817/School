package person;

public class CallPerson {

	public static void main(String[] args) {
		Person p = new Person("Joe", 50);
		Person p2;
		p2 = new Person(p);
		p2.setPerson("Jane", 25);
		System.out.println(p);

	}

}
