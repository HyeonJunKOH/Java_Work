package test.main;

import test.mypac.Car;

public class MainClass07 {
	public static void main(String[] args) {
		//개발자가 코딩하는 위치
		
		//달리기는 하지만...
		useCar(new Car());
		//조금더 빨리 달릴수는 없을까?
		//그렇다고해서 누군가 미리 만들어 놓은 Car 클래스의 drive()메소드를 수정하는 것은 불가능하다
		//방법이 없을까?
		useCar(new Car() {
			@Override
			public void drive() {
				System.out.println("졸라 빨리 달려요!");
			}
		});
	}
	
	//누군가가 미리 만들어 놓은 메소드
	public static void useCar(Car c) {
		c.drive();
		c.drive();
	}
}
