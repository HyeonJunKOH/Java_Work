package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/*
 * JDBC(Java DataBase Connectivity)
 * 
 * DataBase에 연결해서 SELECT, INSERT, UPDATE, DELETE작업하기
 * 
 * Oracle에 연결하기 위해서는 드라이버 클래스가 들어있는 ojdbc6.jar파일을
 * 사용할 수 있도록 설정해야 한다.
 * 
 * 프로젝트에 마우스 우클릭 => Build Path => Configure Build Path => Libraries 탭 선택
 * => classpath 선택 => 우측 Add External jar 버튼을 누른 후  => ojdbc6.jar파일을 찾은 다음=>apply;
 */
public class MainClass01 {
   public static void main(String[] args) {
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
      //SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역 변수 미리 만들기
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         //실행할 sql문
         String sql = "SELECT num, name, addr"
               + " FROM member"
               + " ORDER BY num DESC";
         //PrepareStatement 객체의 참조값 얻어오기
         pstmt=conn.prepareStatement(sql);
         //select 문 실행하고 결과 값을 ResultSet으로 얻어내기
         rs=pstmt.executeQuery();
         while(rs.next()) {
            int num = rs.getInt("num");
            String name = rs.getString("name");
            String addr = rs.getString("addr");
            //콘솔창에 출력해보기
            System.out.println(num+" | "+name+" | "+addr);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}