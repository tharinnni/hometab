package week1.day2.assignments.mandatory;

public class RemoveDuplicates {

	public static void main(String[] args) {
		//Declaration
		String text = "We learn java basics as part of java sessions in java week1";
		int count=0;
		String[] strArry=text.split(" "); //Split the String to String Array.
		//To iterate the String Array
		for (int i = 0; i < strArry.length; i++) {
			for (int j = i+1; j < strArry.length; j++) {
				if(strArry[i].equalsIgnoreCase(strArry[j])) { //This line will compare the two Strings.
					count++; //If both are Strings are match then increasing the value of count. 
				}
			}
			if(count>0) { //if the count value greater then zero then instead of the string print " " 
				System.out.print(" ");
				count=0; //Reset the value of count.
			}
			else // if both Srings are not matching then print the String here.
			{
				System.out.print(strArry[i]+" "); 
			}
		}

	}
}


