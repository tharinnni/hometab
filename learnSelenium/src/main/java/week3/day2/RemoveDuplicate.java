package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		String companyName = "google";
		Set<Character> dubRemoved = new LinkedHashSet<Character>(); 	 	
		char[] toChar = companyName.toCharArray();
		for (int i = 0; i < toChar.length; i++) {
			dubRemoved.add(toChar[i]);
		}
		String str=dubRemoved.toString().replace(",", ",");
		System.out.println(str.replace(" ",""));
	}

}