package week1.day2.assignments.mandatory;

public class FindIntersectio {

	public static void main(String[] args) 
	{
		//Declaration of integer array
		int[] firstArray = {3,2,11,4,6,7};
		int[] secndArray = {1,2,8,4,9,7};
		//Nexted for loop to iterating both integer arrays
		for (int i = 0; i < firstArray.length; i++) 
		{
			for (int j = 0; j < secndArray.length; j++) 
			{
				if(firstArray[i]==secndArray[j]) //To find common values in firstArray and secndArray  
				{
					System.out.print(firstArray[i]+" "); //This will print the Intersection values in both integer array.
				}
			}
		}
	}
}
