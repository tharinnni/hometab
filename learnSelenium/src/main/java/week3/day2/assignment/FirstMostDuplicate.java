package week3.day2.assignment;

import java.util.Map;
import org.apache.commons.collections4.map.HashedMap;

public class FirstMostDuplicate {

	public static void main(String[] args) {
		//Declaration 
		String input ="abbaba";
		int mostDuplicate = 0;
		char mostOccur = input.charAt(0);
		//Declaring Map
		Map<Character, Integer> firstMost = new HashedMap<Character, Integer>();
		//Convert String to Character array
		char[] toCharAry = input.toCharArray();
		//iterate array values
		for (int i = 0; i < toCharAry.length; i++) {
			//Add values in map if the values are present in list increase count of value
			firstMost.put(toCharAry[i], firstMost.getOrDefault(toCharAry[i], 0)+1);
			//to find first most duplicate
			if(firstMost.get(toCharAry[i])>mostDuplicate) {
				mostOccur = toCharAry[i];
				mostDuplicate = firstMost.get(toCharAry[i]);
						
			}
		}
		//printing duplicate element
		System.out.println(mostOccur);
	}

}
