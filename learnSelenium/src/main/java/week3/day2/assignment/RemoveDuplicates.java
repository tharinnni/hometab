package week3.day2.assignment;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
	//Declaration and Implementation of method 
	public void impleRemoveDuplicates(String text) {
		//Declaration of List
		Set<String> stringList= new LinkedHashSet<String>();
		//Split text to string array
		String[] textStr = text.split(" ");
		//iterate String Array 
		for (int i = 0; i < textStr.length; i++) {
			//Adding String to set
			stringList.add(textStr[i]);
		}
		//iterate set to print the values
		for (String s : stringList)
		{
			System.out.print(s+" ");
		}
	}

	public static void main(String[] args) {
		//Creating object to access the method
		RemoveDuplicates obj = new RemoveDuplicates();
		//Calling method by object
		obj.impleRemoveDuplicates("We learn java basics as part of java sessions in java week1");

	}
}
