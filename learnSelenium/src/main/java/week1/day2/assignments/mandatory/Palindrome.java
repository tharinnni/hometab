package week1.day2.assignments.mandatory;

public class Palindrome {

	public static void main(String[] args) {
		//Declaration
		String checkPalindrome = "madam";
		String revString = "";
		char toChar;
		for (int i = checkPalindrome.length()-1; i >=0; i--) { // To iterate the String
			//This block used to reverse the given string.
			toChar = checkPalindrome.charAt(i); 
			revString=revString+toChar;
		}
		if(checkPalindrome.equalsIgnoreCase(revString)) //Compare both reversed string and inputed string are same.
		{
			System.out.println("Inputed String is Palindrome");
		}
		else
		{
			System.out.println("Inputed String is not Palindrome");

		}
	}

}
