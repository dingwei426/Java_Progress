package PA;

public class PlatinumMember extends Member{

	private double monthlyFee;
	
	//getter for monthly fee
	public double getMonthlyFee()
	{
		return monthlyFee;
	}
	
	//Constructor initialize all data
	public PlatinumMember(String name, String memberID, double monthlyFee)
	{
		super(name, memberID); //invoke constructor of parent class
		this.monthlyFee = monthlyFee;
	}
	
	//Method Override from Member class to calculate fee per visit
	public double feePerVisit()
	{
		return monthlyFee/12;
	}
	
	//Override to display details of each member
	public String toString()
	{
		return "Type: Platinum Member"
				+ "\n\tMemberID: " + this.getMemberID()
				+ "\n\tName: " + this.getName()
				+ "\n\tMonthly Fee(RM): " + this.getMonthlyFee()
				+ "\n\tFee Per Visit(RM): " + this.feePerVisit();
	}
	
}
