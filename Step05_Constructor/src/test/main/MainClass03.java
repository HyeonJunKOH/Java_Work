package test.main;

import test.mypac.Cpu;
import test.mypac.HardDisk;
import test.mypac.MacBook;
import test.mypac.Memory;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * 	MacBook 객체를 생성해서 참조값을 mac1이라는 지역변수에 담아보세요.
		 * 
		 * 	주의!!
		 * 	- MacBook 클래스를 절대 수정하지 마세요
		 * 	- MainClass03 은 test.main 패키지에 있고 Cpu, Memory, HardDisk, MacBook 클래스는
		 * 	test.mypac 패키지에 있기 때문에 4개의 클래스는 모두 import 되어야한다.
		 */
		
		 MacBook book = new MacBook(new Cpu(),new Memory(),new HardDisk());

		 MacBook book2 = new MacBooK(null,null,null);
		 
		 book.doGame();
		 book2.doGame();
		 
		 Cpu c = new Cpu();
		 Memory m = new Memory();
		 HardDisk h = new HardDisk();
		 //생성자의 인자로 전달할 값이 지역변수에 있는 경우 지역변수를 참조해서 전달할수도 있다.
		 MacBook book3 = new MacBook(c,m,h);
		 book3.doGame();
	}
}
