package week3.day1.assignment;

public class Automation implements Language,TestTool  {

	public void Selenium() {
		System.out.println("Implementation of Selenium Done Here !!");
		
	}

	public void Java() {
		System.out.println("Implementation of JAVA Done Here !!");
		
	}
	
	public static void main(String[] args) {
		Automation aut = new Automation();
		aut.Selenium();
		aut.Java();

	
	}
}
