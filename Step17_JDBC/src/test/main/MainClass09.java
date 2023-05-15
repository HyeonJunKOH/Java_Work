package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.dto.MemberDto;

public class MainClass09 {
	public static void main(String[] args) {
		String name="에이콘";
		String addr="강남역";
		
		//아래의 insert()메소드를 활용해서 위의 회원정보가 DB에 저장되도록 해보세요.
		MemberDto m = new MemberDto();
		m.setName(name);
		m.setAddr(addr);
		MainClass09.insert(m);
		
		
	}
	
	public static void insert(MemberDto dto) {
		//인자로 전달된 MemberDto 객체에 담긴 내용을 이용해서 DB에 회원 정보가 저장되도록 해보세요.
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
	    	pstmt.setString(1,dto.getName());//1번째 ?에 문자열 바인딩
	    	pstmt.setString(2,dto.getAddr());//2번째 ?에 문자열 바인딩
	    	//sql 문 실행하기
	    	pstmt.executeUpdate();
	    	System.out.println("회원 정보를 수정했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
