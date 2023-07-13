package PA;

public class SilverMember extends Member{

	private double annualFee;
	private int visitNum; //Number of visit per year
	
	//getter for annual fee
	public double getAnnualFee()
	{
		return annualFee;
	}
	
	//getter for number of visit per year
	public int getVisitNum()
	{
		return visitNum;
	}
	
	//Constructor initialize all data
	public SilverMember(String name, String memberID, double annualFee, int visitNum)
	{
		super(name, memberID); //invoke constructor of parent class
		this.annualFee = annualFee;
		this.visitNum = visitNum;
	}
	
	//Method Override from Member class to calculate fee per visit
	public double feePerVisit()
	{
		return annualFee/visitNum;
	}
	
	//Override to display details of each member
	public String toString()
	{
		return "Type: Silver Member"
				+ "\n\tMemberID: " + this.getMemberID()
				+ "\n\tName: " + this.getName()
				+ "\n\tAnnual Fee(RM): " + this.getAnnualFee()
				+ "\n\tVisit Per Year: " + this.getVisitNum()
				+ "\n\tFee Per Visit(RM): " + this.feePerVisit();
	}
	
}
