package test.main;

import java.util.Random;

public class QuizMain2 {
	public static void main(String[] args) {
		/*
		 * 	 2. run 했을때
		 * 	    5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
		 * 	    예) cherry | apple | cherry
		 * 	       7 | apple | melon
		 * 
		 */
		String[]items = {"cherry","apple","banana","melon","7"};
		Random ran = new Random();
		//랜덤한 숫자를 얻어내기 위한 객체
		for(int i=0; i<3; i++) {
			int ranNum = ran.nextInt(5);
			System.out.print(items[ranNum]);
			if(i<2) {
			System.out.print("|");
			}
		}
		
	}
}
