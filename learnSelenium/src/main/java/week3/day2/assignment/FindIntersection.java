package week3.day2.assignment;

import java.util.HashSet;
import java.util.Set;

public class FindIntersection {

	public static void main(String[] args) {
		//Declaring two Arrays
		int[] firstArr = {3,2,11,4,6,7};
		int[] secndArr = {1,2,8,4,9,7};
		//Declaring new Array with length of first dwo arrary
		int[] finalArr = new int[firstArr.length+secndArr.length];
		//Declaring Set
		Set<Integer> findIntersection = new HashSet<Integer>();
		//Copy valuese into third Array
		System.arraycopy(firstArr, 0, finalArr, 0, firstArr.length);
		System.arraycopy(secndArr, 0, finalArr, firstArr.length, secndArr.length);
		System.out.println("Result Here");
		//iterate array values
		for (int i = 0; i < finalArr.length; i++) {
			//To get the duplicate element which is not added in the list
			boolean isAdded = findIntersection.add(finalArr[i]);
			//Printing intersection values
			if(!isAdded) {
				System.out.print(finalArr[i]+"  ");
			}
		}
	}
}


