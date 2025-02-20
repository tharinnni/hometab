package week3.day2.assignment;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindSecondLargest {

	public static void main(String[] args) {
		//Declaring integer array with values
		int[] data = {3,2,11,4,6,7};
		//Declaration of List
		List<Integer> resultArray = new LinkedList<Integer>();
		//iterate array values
		for (int i = 0; i < data.length; i++) {
			//Add array values into list
			resultArray.add(data[i]);
		}
		//Sort list values
		Collections.sort(resultArray);
		//iterate list values to check second largest number
		for (int j = resultArray.size()-1; j>=0; j--) {
			for (int k = j-1; k >=0;) {
				//compare values in the list
				if(resultArray.get(j)!=resultArray.get(k)) {
					System.out.println("Second Largest Value in the List: "+resultArray.get(k));
					j=1;
				}
				break;

			}
		}

	}
}