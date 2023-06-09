package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.mypac.Member;

public class MainClass08 {
	public static void main(String[] args) {
		//수정할 회원의 정보라고 가정하자
		int num=1;
		String name="이정호";
		String addr="아현동";
		
		//아래의 update()메소드를 이동해서 회원정보가 수정되도록 해보세요.
		Member m=new Member();
		m.num=num;
		m.name=name;
		m.addr=addr;
		MainClass08.update(m);
		
	}
	
	public static void update(Member mem) {
		//Member 객체에 담긴 정보를 이용해서 회원 정보를 수정하도록 해보세요.
		
		
		//DB연결객체를 담을 지역 변수 만들기
	      Connection conn=null;
	      
	      try {
	         //오라클 드라이버 로딩
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         //접속할 DB의 정보@아이피주소 : port번호 :db이름
	         String url="jdbc:oracle:thin:@localhost:1521:xe";
	         conn=DriverManager.getConnection(url, "scott", "tiger");
	         System.out.println("Oracle DB접속 성공");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      PreparedStatement pstmt=null;
	      try {
			//실행할 미완성의 sql문
	    	String sql="update member"
	    			+ " set name=?,addr=?"
	    			+ " where num=?";
	    	//미완성의 sql 문을 전달하면서 PreparedStatement 객채의 참조값 얻어내기
	    	pstmt=conn.prepareStatement(sql);
	    	//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(?에 값 바인딩하기)
	    	pstmt.setString(1,mem.name);//1번째 ?에 문자열 바인딩
	    	pstmt.setString(2,mem.addr);//2번째 ?에 문자열 바인딩
	    	pstmt.setInt(3,mem.num);//3번째 ?에 문자열 바인딩
	    	//sql 문 실행하기
	    	pstmt.executeUpdate();
	    	System.out.println("회원 정보를 수정했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
