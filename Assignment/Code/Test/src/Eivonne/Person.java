package Eivonne;


public class Person {

	private String name;
	private String dob;
	
	public Person(String name, String dob)
	{
		this.name = name;
		this.dob = dob;
	}
	
	public Person()
	{
		
	}
	public String getName()
	{
		return name;
	}
	
	public String getDob()
	{
		return dob;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setDob(String Dob)
	{
		this.dob = Dob;
	}
	
	
}
