package test.auto;

public class Bus extends Car {
	//부모 생성자에서 필요한 값을 자식 생성자에서 받아서 전달해 주는 코드가 있어야 문법이 완성된다.
	public Bus(Engine engine) {
		//super() 호출 이전에 다른 코드를 한줄이라도 실행하면 안된다.
		//int num = 10; X
		
		// super ( ) 는 부모 생성자를 가리키는 표현식이다.
		super(engine);
	}
	//메소드
	public void powerDrive() {
		if(this.engine==null) {
			System.out.println("Engine 객체가 없어서 달릴수가 없어요");
			return; // 메소드 끝내기
		}
		System.out.println("승객을 태우고 달려요");
	}
}
