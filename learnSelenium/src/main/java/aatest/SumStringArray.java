package aatest;

import java.util.Iterator;

public class SumStringArray {

	public static void main(String[] args) {

		String[] input = {"ab453c1","444gdc2","3f5g"};
		char[] converInput;
		int temp=0;

		for (int i = 0; i < input.length; i++) {
			converInput = input[i].toCharArray();

			for (int j = 0; j < converInput.length; j++) {
				if(Character.isDigit(converInput[j])) {
					int t1 = Integer.parseInt(Character.toString(converInput[j]));
					temp = temp + t1;
				}

			}
		}

		System.out.println(temp);

	}

}
