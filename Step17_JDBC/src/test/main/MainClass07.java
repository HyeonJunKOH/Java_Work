package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.mypac.Member;

public class MainClass07 {
	public static void main(String[] args) {
		//추가할 회원 정보
		String name="주뎅이";
		String addr="봉천동";
		
		//아래의 메소드를 호출해서 위의 회원 정보가 DB에 저장되도록 프로그래밍 해 보세요.
		//위의 정보를 Member 객체에 담아서 insert()메소드의 매개 변수에 전달한다.
		Member m=new Member();
		m.name=name;
		m.addr=addr;
		
		MainClass07.insert(m);
		
		
		
	}
	
	public static void insert(Member mem) {
		//mem에 담겨진 정보를 이용해서 회원 한명의 정보를 DB에 저장되도록 해보세요.
		
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
	    	String sql="insert into member"
	    			+ " (num,name,addr)"
	    			+ " values(member_seq.nextval,?,?)";
	    	//미완성의 sql 문을 전달하면서 PreparedStatement 객채의 참조값 얻어내기
	    	pstmt=conn.prepareStatement(sql);
	    	//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(?에 값 바인딩하기)
	    	pstmt.setString(1,mem.name);//1번째 ?에 문자열 바인딩
	    	pstmt.setString(2,mem.addr);//2번째 ?에 문자열 바인딩
	    	//sql 문 실행하기
	    	pstmt.executeUpdate();
	    	System.out.println("회원 정보를 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
