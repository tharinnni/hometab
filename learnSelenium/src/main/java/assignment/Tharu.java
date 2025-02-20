package assignment;

public class Tharu {
	
	public int one() {
		int a=7;
		return a;
	}
	
	public int two(int a) {
		int twos = a*a;
		return twos;
	}
	
	public int three(int a) {
		int threes = a*a*a;
		return threes;
	}
	
	public static void main(String[] args) {
		
		int r=10;
		Tharu x = new Tharu();
		System.out.println(x.one());
		System.out.println(x.two(r));
		System.out.println(x.three(r));
	}

}
