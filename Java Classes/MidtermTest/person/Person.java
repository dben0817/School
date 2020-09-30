package person;


public class Person 
{
	private String name;
	private int age;
	
	public Person(String n, int a)
	{
		name = n;
		age = a;
	}
	public Person(Person p)
	{
		name = p.name;
		age = p.age;
	}
	public void setPerson(String n, int a)
	{
		name = n;
		age = a;
	}
	public String toString()
	{
		return name +" : "+ age;
	}
	boolean equals(Person p)
	{
		if (age ==p.age && name.equals(p.name))
			return true;
		else return false;
	}
}
