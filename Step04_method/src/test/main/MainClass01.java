package test.main;
import test.mypac.AirPlane;
import test.mypac.Test;

public class MainClass01 {
	public static void main(String[] args) {
		Test t = new Test();
		//return type이 void 인 메소드 호출
		t.walk();
		//return type이 int 인 메소드 호출하고 리턴되는 값을 a라는 int type 지역변수에 담기
		int a = t.getNumber();
		//return type이 String인 메소드 호출하고 리턴되는 값을 b라는 String type 지역변수에 담기
		String b = t.getGreeting();
		//return type이 AirPlane 인 메소드 호출하고 리턴되는 값을 c 라는 AirPlane type 지역변수에 담기
		AirPlane c = t.getPlane();
		c.fly();
		
		// 위에서 생성한 객체의 setNum()메소드를 호출해 보세요.
		t.setNum(10);
		// 위에서 생성한 객체의 setName()메소드를 호출해 보세요.
		t.setName("김구라");
		// 위에서 생성한 객체의 setPlane() 메소드를 호출해보세요
		t.setPlane(new AirPlane());
		
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
