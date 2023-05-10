package test.main;

import java.util.Random;

public class QuizMain {
	public static void main(String[] args) {
		/*
		 * 	1. run 했을때
		 * 	   cherry, apple, banana, melon, 7
		 * 	   5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요.
		 */
		
		Random ran = new Random();
		String[]ran2 = {"cherry","apple","banana","melon","7"};
		int ranNum = ran.nextInt(5);
		System.out.println(ran2[ranNum]);
	}
}
