package test.mypac;
/*
 * 	새로운 스레드 만드는 방법
 * 
 * 	1. Thread 클래스를 상속 받은 클래스를 정의 한다.
 * 	2. run()메소드를 오버라이드 한다.
 * 	3. run()메소드 안에서 새로운 스레드에서 해야 할 작업을 코딩한다
 * 	4. 만든 클래스로 객체를 생성하고 해당 객체의 start()메소드를 호출하면 새로운 스레드가 
 * 	   시작된다. ex) new AnotherThread().start();
 * 
 */
public class AnotherThread extends Thread {//1.
	//2.
	@Override
	public void run() {
		System.out.println("작업을 시작합니다.");
		//10 초가 걸리는 작업이라고 가정 하자
		try {
			Thread.sleep(10000);
		}catch(InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("작업이 종료 됩니다.");
	}
}
