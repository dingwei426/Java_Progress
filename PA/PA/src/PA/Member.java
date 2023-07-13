package PA;

//parent class of Platinum and Silver Member
public abstract class Member {

	private String name, memberID;
	
	//getter for name
	public String getName()
	{
		return name;
	}
	
	//getter for member ID
	public String getMemberID()
	{
		return memberID;
	}
	
	//Constructor initialize all data
	public Member(String name, String memberID)
	{
		this.name = name;
		this.memberID = memberID;
	}
	
	//abstract method
	public abstract double feePerVisit();
}
