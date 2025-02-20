package codereview.day1;

public class Solution3 {
	public static String reverseEvenWords(String str) {
		String[] stringArys=str.split(" ");
		int evenWord=0;
		String newStr = null,revstr = null;
		for (int i = 0; i < stringArys.length; i++) {
			evenWord=evenWord+i;
			if(evenWord%2==0) {
				revstr=new StringBuilder(stringArys[i]).reverse().toString();
			}else
			{
				newStr=stringArys[i];
			}
			
			newStr=newStr+revstr;
		}
		return newStr;
		
	}

	public static void main(String[] args) {
		System.out.println(Solution3.reverseEvenWords("I am a Software Tester"));

	}

}
