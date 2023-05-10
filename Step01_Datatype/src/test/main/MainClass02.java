package test.main;
/*
 * 	주석에 표기된 것 대로 코딩을 완성해 보세요.
 */
public class MainClass02 {
	public static void main(String[] args) {
		//1. 콘솔창에 "main 메소드가 시작 되었습니다." 를 출력해 보세요.
			System.out.println("main 메소드가 시작 되었습니다.");
			//Syso cntl+enter 하면 바로 만들어진다.
		//2. 국어점수 95 를 kor이라는 변수에 담아보세요.
			int kor=95;
		//3. 영어점수 100을 eng라는 변수에 담아보세요.
			int eng=100;
		//4. 국어점수와 영어 점수의 평균을 구해서(연산자 활용) avg라는 변수에 담아보세요.
			double avg = (double)(kor+eng)/2;
			//정수+정수가 만나면 정수가 나온다 변수 type이 실수여도
			//따라서 casting (double)를 해줘서 수소점이 나오도록 설정해준다.
		//5. 콘솔창에 avg 변수안에 담긴 내용을 출력해 보세요.
			System.out.println(avg);
	}
}
