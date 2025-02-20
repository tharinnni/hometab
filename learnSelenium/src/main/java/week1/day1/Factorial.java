package week1.day1;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length=5,faValue = 1;
		for (int i = length; i >= 1; i--) {
			faValue=faValue*i;
		}
		System.out.println(faValue);
	}

}
