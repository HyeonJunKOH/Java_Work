package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		int num=3; //삭제할 회원의 번호라고 가정
		
		//아래의 delete() 메소드를 이용해서 회원 정보를 삭제해 보세요
		delete(num);
	}
	
	public static void delete(int num) {
		//인자로 전달된 num에 해당하는 회원정보를 삭제하는 기능을 완성해 보세요
		//DBConnect 클래스를 활용하세요
		 Connection conn=null;
	      PreparedStatement pstmt=null;
	      try {
	    	  //Connection 객체의 참조값 얻어오기
	    	  conn=new DBConnect().getConn();
	    	  //실행할 미완성의 sql문
	    	  String sql="delete from member"
	    			   + " where num=?";
	    	//미완성의 sql 문을 전달하면서 PreparedStatement 객채의 참조값 얻어내기
	    	pstmt=conn.prepareStatement(sql);
	    	//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(?에 값 바인딩하기)
	    	pstmt.setInt(1,num);//1번째 ?에 문자열 바인딩
	    	//sql 문 실행하기
	    	pstmt.executeUpdate();
	    	System.out.println("회원 정보를 수정했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
