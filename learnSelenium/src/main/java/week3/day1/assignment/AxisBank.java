package week3.day1.assignment;

public class AxisBank {
	//Implementation methods
	public void deposit() {
		System.out.println("This is Deposit Acc from Axis Bank");
	}
	
	public static void main(String[] args) {
		//Create Object for Axisbank and access method
		AxisBank axis = new AxisBank();
		axis.deposit();
		//Create Object for BankInfo and access method
		BankInfo bankin = new BankInfo();
		bankin.deposit();
	}


}
