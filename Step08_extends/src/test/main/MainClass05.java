package test.main;

import test.mypac.AndroidPhone;

public class MainClass05 {
	public static void main(String[] args) {
		//AndroidPhone 객체를 생성해서 참조값을 AndroidPhone type p1이라는 지역변수에 담기
		AndroidPhone p1 = new AndroidPhone();
		//메소드 호출해 보기
		p1.call(); //Phone 객체의 기능
		p1.mobileCall(); //HandPhone 객체의 기능
		p1.takePicture(); //HandPhone 객체의 기능
		p1.doInternet(); //AndroidPhone 객체의 기능
		p1.showPlatform(); //AndroidPhone 객체의 기능
	}
}
