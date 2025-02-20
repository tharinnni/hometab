package week1.day2;

public class ReverseString {

	public static void main(String[] args) {
		String str = "hello";
		char[] chrs = str.toCharArray();
		for (int i = chrs.length-1; i >= 0; i--) {
			System.out.print(chrs[i]);
		}

	}

}
