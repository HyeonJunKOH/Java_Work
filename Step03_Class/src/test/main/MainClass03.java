package test.main;

import test.mypac.Car;
public class MainClass03 {
	public static void main(String[] args) {
		//Car 객체를 생성해서 사용하지 않고 버림
		new Car();
		
		//Car 객체를 생성해서 1번 사용하고 버림(객체를 1회용으로 사용)
		new Car().drive();
		
		//Car 객체를 생성해서 나온 참조값을 c1 이라는 Car type 지역변수에 담아놓고
		Car c1=new Car();
		//필요할때 마다 c1에 . 찍어서 여러번 사용 할 수 있다.
		c1.drive();
		c1.drive();
		
		//drive() 메소드는 리턴 type이 void 이기 때문에 아래의 코드는 성립하지 않는다.
		//Car c2=new Car().drive();
	}
}
