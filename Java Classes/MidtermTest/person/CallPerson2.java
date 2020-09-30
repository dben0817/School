package person;

public class CallPerson2 {

	public static void main(String[] args) {
		Person p = new Person("Joe", 50);
		Person p2;
		p2 = new Person(p);
		if (p == p2) System.out.println("true for ==");
		else  System.out.println("false for ==");
		
		if (p.equals(p2)) System.out.println("true for equals");
		else  System.out.println("false for equals");

	}

}
