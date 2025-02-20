package week1.day2;

public class FindCharCount {

	public static void main(String[] args) {
		char findChar = 'a';
		int count=0;
		String companyName = "cognizant";
		char[] toChar = companyName.toCharArray();
		for (int i = 0; i < toChar.length; i++) {
			if(toChar[i] == findChar) {
				count++;
			}

		}
		System.out.println("Count of Character : " +count);
	}

}
