package week3.day2;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SingleOccurance {

	public static void main(String[] args) {
		Character[] nums = {'f','a','b','c','e','d','a','q','f'};
		//Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < nums.length; i++) {
			//map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
			
			if(map.containsKey(nums[i])) {
				int c = map.get(nums[i]);
				map.put(nums[i], c+1);
				
			}else
			{
				map.put(nums[i], 1);
			}
			
			
		}

	}
}
