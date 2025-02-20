package aatest;

public class Test {

	public static void main(String[] args) {
		String input = "a2b3";
		String output = "";

		for (int i = 0; i < input.length(); i++) {
			if(Character.isAlphabetic(input.charAt(i))) {
				//System.out.print(input.charAt(i));
			 	output = output+input.charAt(i);
			}else //if(Character.isDigit(input.charAt(i))) 
				{
				int a = Character.getNumericValue(input.charAt(i));
				for (int j = 0; j < a-1; j++) {
					//System.out.print(input.charAt(i-1));
					output = output+input.charAt(i-1);
				}
			}
		}
		System.out.println(output);
	}
}
