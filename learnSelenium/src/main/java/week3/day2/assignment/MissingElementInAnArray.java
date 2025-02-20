package week3.day2.assignment;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		//Declaring integer array with values
		int[] arr = {1,2,3,4,6,8,5,9};
		//Declaration of List
		List<Integer> newArry = new LinkedList<Integer>();
		//iterate array values
		for (int i = 0; i < arr.length; i++) {
			//Add array values into list
			newArry.add(arr[i]);
		}
		//Sort list values
		Collections.sort(newArry);
		//iterate list values
		for (int i = 0; i < newArry.size(); i++) {
			int nextNum = i+1;
			//To check missing values in the list
			if (newArry.get(i)!=nextNum) {
				//To Print missing value in the list
				System.out.println("Missing Number is : "+nextNum);
				i=newArry.size()-1;
				break;
			}
			
		}

	}

}
