package week1.day2;

import java.util.Arrays;

public class FindDups {

	public static void main(String[] args) {
		int[] num = {22, 3981, -19, 82, 0, 45, 37,22,45};
		int temp=0;
		Arrays.sort(num);
		for (int i = 1; i < num.length; i++) {
			if(num[temp] == num[i])
			{
				System.out.println("The dublicate values are : "+ num[temp] );

			}
			temp=i;
		}

	}

}
