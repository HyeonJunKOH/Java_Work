package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		PrintStream ps=System.out;
		//학습을 위해서 PrintStream 객체를 부모type OutputStream으로 받아보기
		//OutputStream도 1byte처리 스트림이다.
		OutputStream os=ps;
		//2byte처리 스트림
		OutputStreamWriter osw=new OutputStreamWriter(os);
		try {
			osw.write(48148);
			osw.write(48148);
			osw.write(48148);
			osw.write("아니야");
			osw.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
