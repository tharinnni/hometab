package week3.day1.assignment.org.system;

public class Desktop extends Computer{

	public  static void desktopSize() {
		System.out.print(" 24 inch with M1 chip");
	}

	public static void main(String[] args) {
		Computer.computerModel();
		Desktop.desktopSize();
	}
}
