package codereview.day1;

public class LengthOfLastWord {
	public void findCharinWord(String input) {
		String[] strAry = input.split(" ");
		int wordCount = strAry[strAry.length-1].length();	
		System.out.println("The last word is "+strAry[strAry.length-1]+" with length "+wordCount);
	}

	public static void main(String[] args) {
		LengthOfLastWord objAss = new LengthOfLastWord();
		objAss.findCharinWord("   fly me   to   the moon  ");

	}

}
