package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		InputStream is=System.in;
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		*/
		
		//위의 3줄을 한줄로 표현하면 아래와 같다.
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자열 한줄 입력:");
		try {
			//BufferedReader 객체의 readLine()메소드를 이용해서 문자열 한줄을 읽어 들이기
			String line=br.readLine();
			System.out.println("line:"+line);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
