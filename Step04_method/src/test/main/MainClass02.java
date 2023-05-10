package test.main;

import test.mypac.AirPlane;
import test.mypac.Test;

public class MainClass02 {
	public static void main(String[] args) {
		Test t = new Test();
		t.send();
		t.send(10);
		t.send("xxx");
		t.send(new AirPlane());
		
		//참조되는 값을 전달 할 수도 있다.
		int a = 999;
		t.send(a);
		
		AirPlane c = new AirPlane();
		t.send(c);
		
	}
}