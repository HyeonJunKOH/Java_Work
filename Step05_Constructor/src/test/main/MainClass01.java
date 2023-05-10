package test.main;

import test.mypac.Student;

public class MainClass01 {
	public static void main(String[] args) {
		new Student();
		
		new Student().study();
		
		Student s1=new Student();
		s1.study();
		s1.study();
	}
}
