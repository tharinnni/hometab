package week1.day1;

public class Fibbinocci {

	public static void main(String[] args) {
		int firstNum = 0, secNum = 1, sum = 0;
		System.out.print(firstNum+"  "+secNum+"  ");
		for (int i = 1; i < 10; i++) {
			sum=firstNum+secNum;
			firstNum=secNum;
			secNum=sum;
			System.out.print(sum+"  ");

		}
	}

}
