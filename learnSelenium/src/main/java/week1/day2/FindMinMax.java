package week1.day2;

import java.util.Arrays;

public class FindMinMax {

	public static void main(String[] args) {
		int[] num = {22, 3981, -19, 82, 0, 45, 37};
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			//System.out.println(num[i]);
		}
		System.out.println("Maximum value in the array is : "+num[num.length-1]);
		System.out.println("Minimum Value in the array is : "+num[0]);

	}

}
