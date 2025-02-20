package week3.day1.assignment.org.student;

import week3.day1.assignment.org.department.Department;

public class Student extends Department {
	//Implementation of methods
	public void studentName() {
		System.out.println("Krithvik Ramdutya");
	}
	
	public void studentDept() {
		System.out.println("Aerospace Engineering");		
	}
	
	public void studentId() {
		System.out.println("AU410001");
	}
	
	public static void main(String[] args) {
		Student MultiLevSdu = new Student();
		//Calling Method from Class College
		MultiLevSdu.collegeName();
		MultiLevSdu.collegeCode();
		MultiLevSdu.collegeRank();
		//Calling Method from Class Department
		MultiLevSdu.deptName();
		//Calling Method from Student 
		MultiLevSdu.studentName();
		MultiLevSdu.studentDept();
		MultiLevSdu.studentId();
	}

}
