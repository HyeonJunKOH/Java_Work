package test.mypac;
/*
 * 	때로는 우리가 직접 예외 클래스를 정의하고
 * 
 * 	필요한 시점 혹은 특정 이벤트가 발생했을때 예외를 throw 해야 할때가 있다.
 * 
 * 	예외 클래스는 RuntimeException을 상속 받아서 만들면 된다.
 */
public class WowException extends RuntimeException {
	//예외메세지를 생성자의 인자로 전달 받아서 부모 생성자에 전달하는 생성자를 만들면 편리하다.
	
	public WowException(String msg) {
		super(msg);
		
	}
}
