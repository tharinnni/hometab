package codereview.day1;

public class Solution2 {
	public static String reverseString(String input) {
		char[] newCharArry = input.toCharArray();
		String outPutString = "";
      for (int i=newCharArry.length;i>=0;i--)
      {
        outPutString = outPutString+newCharArry[i];
      }
	return outPutString;
      
		
	}
	
	public static void main(String[] args) {
		System.out.println(Solution2.reverseString("hello"));
	}
}
