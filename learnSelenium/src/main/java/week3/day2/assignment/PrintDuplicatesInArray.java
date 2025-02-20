package week3.day2.assignment;

import java.util.HashSet;
import java.util.Set;

public class PrintDuplicatesInArray {

	public static void main(String[] args) {
		//Declaration 
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		boolean isAdded = false; 
		//Declaring Set
		Set<Integer> printDupValues = new HashSet<Integer>();
		//iterate list values
		for (int i = 0; i < arr.length; i++) {
			//To get the duplicate element which is not added in the list
			isAdded = printDupValues.add(arr[i]);
			//To print duplicate values
			if (!isAdded) {
				System.out.println(arr[i]);
			}
		}
	}

}
