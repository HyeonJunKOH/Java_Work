package test.main;
import test.mypac.Car;

public class MainClass01 {
	//run 했을때 실행의 흐름이 시작되는 특별한 main 메소드
	public static void main(String[] args) {
		
		/*
		 *  만일 달리고 싶다면 어떻게 해야할까?
		 */
		//Car 클래스로 객체를 생성하고 생성된 객체의 참조값을 car1이라는 지역변수에 담기
		Car car1 = new Car();
		//Car 객체의 참조값에 . 찍어서 메솓 호출하기
		car1.drive();
		car1.name="소나타";
		car1.price=10000;
		
		Car car2 = new Car();
		car2.drive();
		car2.name="그랜저";
		car2.price=15000;
		
		boolean result = car1 == car2; //false
		boolean result2 = car1.name == car2.name; //false
	}
}

