package week3.day2.assignment;

import java.util.Map;
import java.util.TreeMap;

public class FindNumbersOccurances {

	public static void main(String[] args) {
		//Declaration of integer Array
		int[] inputArr = {2,3,5,6,3,2,1,4,2,1,6,-1};
		//Declaring Tree Map
		Map<Integer, Integer> findOccurances = new TreeMap<Integer, Integer>();
		//iterate array values
		for (int i = 0; i < inputArr.length; i++) {
			//Add values into Tree Map if the value present in the map key than incress the values
			findOccurances.put(inputArr[i], findOccurances.getOrDefault(inputArr[i], 0)+1);
		}
		//itrate map to print the occurance
		for(java.util.Map.Entry<Integer, Integer> entry : findOccurances.entrySet()) {
			System.out.print(entry.getKey()+"->"+entry.getValue()+"   ");
		}
	}
}
