package week1.day2;

public class Solution2 {
	public static boolean isAnagram(String input1, String input2) {
		char[] s1=input1.toCharArray();
		char[] s2=input2.toCharArray();
		int n1=s1.length,n2=s2.length;
		char temp;
		if(n1!=n2) {
			return false;
		}
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				if(s1[i]>s1[j]) {
					temp=s1[i];
					s1[i]=s1[j];
					s1[j]=temp;
				}
				if(s2[i]>s2[j]) {
					temp=s1[i];
					s2[i]=s2[j];
					s2[j]=temp;
				}
				
			}
			
		}
		for (int k = 0; k< n1;) {
			if(s1[k]==s2[k])
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		return false;
				
	}
	public static void main(String[] args) {
		System.out.println(isAnagram("stop", "post"));
	}
}
