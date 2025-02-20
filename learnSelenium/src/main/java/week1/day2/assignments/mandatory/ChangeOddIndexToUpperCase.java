package week1.day2.assignments.mandatory;


public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {

		//Declaration 
		String test = "changeme";
		int lengthOfString=0;
		char[] toChar = test.toCharArray(); //Convert String to character array.
		System.out.print("Result Here :  ");
		for (int i = 0; i < toChar.length; i++) //To iterating through Array list.
		{ 
			lengthOfString=i+1;
			if(lengthOfString%2==0) //To find the odd index.
			{  
				System.out.print(toChar[i]); //This will print the even character  as it as. 
			}
			else
			{
				System.out.print(Character.toUpperCase(toChar[i])); //This will change the character to upper case and then print. 
			}	
		}
	}
}

