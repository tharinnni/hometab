package week1.day2.assignments.mandatory;

public class ReverseEvenWords {

	public static void main(String[] args) {
		//Declaration
		String test = "I am a software tester";
		String[] strArray = test.split(" ");
		int indexOfArray = 0;
		//To iterating through Array list.
		for (int i = 0; i < strArray.length; i++) {
			indexOfArray=indexOfArray+1;
			if(indexOfArray%2==0) { //To find the even String
				char[] toChar=strArray[i].toCharArray();//Convert the even String to character Array 
				int arraySize=toChar.length;
				//This block used to reverse the even string
				for (int j = arraySize-1; j >=0; j--) 
				{ 
					System.out.print(toChar[j]);	
				}
				System.out.print(" ");
			}
			else{
				System.out.print(strArray[i]+" ");
			}
		}
	}
}
