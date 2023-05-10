package test.main;

import java.util.Random;

import test.mypac.WowException;
/*
 * 	[예외를 발생시키는 방법]
 * 
 * 	throw 예약어와 함께 예외 객체를 생성하면 된다.
 */
public class MainClass06 {
	public static void main(String[] args) {
		Random ran=new Random();
		//0~4 사이의 랜덤한 정수 얻어내기
		int ranNum=ran.nextInt(5);
		//우연히 가장 큰수가 나오면 WowException을 발생시키기
		if(ranNum==4) {
			//throw 예약어와 함께 예외 객체를 생성하면 예외가 발생한다.
			throw new WowException("놀랍네 이거 ㄷㄷ");
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
