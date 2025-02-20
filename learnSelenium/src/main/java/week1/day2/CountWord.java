package week1.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountWord {
	
	public static void coundWordWithFor(String inputWord) {
		String[] strArray = inputWord.split(" "),outputArray = {"java","is","a"};
		int count = 0;
		
		for (int i = 0; i < outputArray.length; i++) {
			
			for (int j = 0; j < strArray.length; j++) {
				if(outputArray[i].equals(strArray[j])) {
					count++;
				}
			}
			System.out.println("Count of the word '"+outputArray[i]+"' and the count is "+count);
			count = 0;
		}

	}
	
	public static void coundWordWithmap(String inputWord) {
		
		String[] strArray = inputWord.split(" ");
		Map<String, Integer> outputMap = new HashMap<>();
		outputMap.put("java", 0);
		outputMap.put("is", 0);
		outputMap.put("a", 0);
		
		for (int i = 0; i < strArray.length; i++) {
			if (outputMap.containsKey(strArray[i])) {
				int key = outputMap.get(strArray[i]);
				outputMap.put(strArray[i],(key+1));
			}
		}
		
		for (Entry<String, Integer> entry : outputMap.entrySet()) {
			System.out.println(entry.getKey() +" "+entry.getValue());
		}
		System.out.println(outputMap);
	}
	
	public static void main(String[] args) {
		String input = "java is a more power full language and java is platform indipendent language and reliable one";
		//coundWordWithFor(input);
		coundWordWithmap(input);
	}

}
