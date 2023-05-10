package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 나온 참조값을 Object type p3라는 지역변수에 담아 보세요
		Object p3 = new HandPhone();
		//Object type p3 변수에 담긴 값을 Phone type p2 라는 변수에 담기
		Phone p2 = (Phone)p3; // casting
		//Object type p3 변수에 담긴 값을 HandPhone type p1이라는 변수에 담기
		HandPhone p1 = (HandPhone)p3;
		
	}
}
