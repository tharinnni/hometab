package week3.day1.assignment;

public class Students {
	public void getStudentInfo() {
		System.out.println("Student Info");
	}
	
	public void getStudentInfo(String studentID) {
		System.out.println("Student Id: " +studentID);
	}
	
	public void getStudentInfo(String studentID, String name) {
		System.out.println("Student ID :"+studentID + " Student Name: " +name);
	}
	public void getStudentInfo(String email, long mobileNumber ) {
		System.out.println("Student E-mail :"+mobileNumber+" Student Phone Number: "+mobileNumber);
	}
	public static void main(String[] args) {
		Students info = new Students();
		info.getStudentInfo();
		info.getStudentInfo("080775");
		info.getStudentInfo("080775 ", "Kabir");
		info.getStudentInfo("kabir@gmail.com ", 9791920077L);

	}

}
