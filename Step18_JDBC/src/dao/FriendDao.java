package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.DBConnect;
import dto.FriendDto;



/*
 *  Data Access Object 만들어 보기
 *  
 *  - DB 에 insert, update, delete, select 작업을 대신해 주는 객체를 생성할 클래스 설계하기 
 */
public class FriendDao {
	
	//인자로 전달되는 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
	public FriendDto getData(int num) {
		//FriendDto 객체의 참조값을 담을 지역변수 미리 만들기
		FriendDto dto=null;
		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql 문(select 문)
			String sql = "select name,job,sal"
						+" from friend"
						+" where num=?";
			pstmt = conn.prepareStatement(sql);
			//select 문이 미완성이라면 여기서 완성한다.
			pstmt.setInt(1, num);
			//select 문 수행하고 결과를 ResultSet 으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 row 에 있는 정보를 추출한다.
			while (rs.next()) {
				//현재 커서가 존재하는 row 에 있는 정보를 추출해서 사용한다.
				String name=rs.getString("name");
				String job=rs.getString("job");
				String sal=rs.getString("sal");
				//FriendDto 객체의 회원 한명의 정보를 담는다.
				dto=new FriendDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setJob(job);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
				}
			}
			//회원 정보가 누적된 List 객체의 참조값을 리턴한다.
			return dto;
		}
	
	
	//전체 회원의 정보를 리턴하는 메소드
	public List<FriendDto> getList(){
		//회원의 정보를 누적할 객체 생성
		List<FriendDto>list=new ArrayList<>();
		
		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 sql 문
			String sql="select num,name,job,sal"
					+  " from friend"
					+  " order by num asc";
			pstmt=conn.prepareStatement(sql);
			//select 문이 미완성이라면 여기서 완성한다.
			
			//select 문 수행하고 결과를 ResultSet으로 리턴받기
			rs=pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출한다.
			while(rs.next()) {
				//현재 커서가 존재하는 row에 있는 정보를 추출해서 사용한다.
				
				//row에 있는 회원 정보를 MemberDto 객체에 담아서
				FriendDto dto=new FriendDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setJob(rs.getString("job"));
				dto.setSal(rs.getInt("sal"));
				//List에 누적시킨다.
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {}
		}
		//회원 정보가 누적된 List 객체의 참조값을 리턴한다.
		return list;
	}
	//회원 한명의 정보를 삭제하는 메소드
	   public boolean delete(int num) {
	      //필요한 객체를 담을 지역 변수를 미리 만들기
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      //insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row 의 갯수를 담을 변수
	      int rowCount = 0; //초기값을 0으로 부여한다. 
	      try {
	         //Connection 객체의 참조값 얻어오기
	         conn = new DBConnect().getConn();
	         //실행할 sql 문
	         String sql = "DELETE FROM friend"
	               + " WHERE num=?";
	         //sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
	         pstmt = conn.prepareStatement(sql);
	         //sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
	         pstmt.setInt(1, num);
	         // insert or update or delete 문을 실제 수행한다. 변화된 row 의 갯수가 리턴된다.
	         rowCount = pstmt.executeUpdate();//수행하고 리턴되는값을 변수에 담는다.
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
	         try {
	            if (pstmt != null)
	               pstmt.close();
	            if (conn != null)
	               conn.close();
	         } catch (Exception e) {
	         }
	      }
	      //변화된 row 의 갯수가 0 보다 크면 작업 성공
	      if (rowCount > 0) {
	         return true;
	      } else {//그렇지 않으면 작업 실패
	         return false;
	      }
	   }
	//회원의 정보를 수정하고 해당 작업의 성공여부를 리턴해주는 메소드
	public boolean update(FriendDto dto) {
		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		//insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row 의 갯수를 담을 변수
		int rowCount=0; //초기값을 0으로 부여한다. 
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			String sql="update friend"
					+  " set name=?, job=?, sal=?"
					+  " where num=?";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJob());
			pstmt.setInt(3, dto.getSal());
			pstmt.setInt(4, dto.getNum());
			// insert or update or delete 문을 실제 수행한다. 변화된 row 의 갯수가 리턴된다.
			rowCount=pstmt.executeUpdate();//수행하고 리턴되는값을 변수에 담는다.
		}catch(Exception e) {
			e.printStackTrace();
		}finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		//변화된 row 의 갯수가 0 보다 크면 작업 성공
		if(rowCount > 0) {
			return true;
		}else {//그렇지 않으면 작업 실패
			return false;
		}
	}
	
   //회원 한명의 정보를 저장하고 해당 작업의 성공여부를 리턴해주는 메소드
   public boolean insert(FriendDto dto) {
      
      //필요한 객체를 담을 지역 변수를 미리 만들기
      Connection conn=null;
      PreparedStatement pstmt=null;
      //insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row 의 갯수를 담을 변수
      int rowCount=0; //초기값을 0으로 부여한다. 
      try {
         //Connection 객체의 참조값 얻어오기
         conn=new DBConnect().getConn();
         String sql="insert into friend"
	    			+ " (num,name,job,sal)"
	    			+ " values(friend_seq.nextval,?,?,?)";
         //sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
         pstmt=conn.prepareStatement(sql);
         //sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
         pstmt.setString(1, dto.getName());
         pstmt.setString(2, dto.getJob());
         pstmt.setInt(3, dto.getSal());
         // insert or update or delete 문을 실제 수행한다. 변화된 row 의 갯수가 리턴된다.
         rowCount=pstmt.executeUpdate();//수행하고 리턴되는값을 변수에 담는다.
      }catch(Exception e) {
         e.printStackTrace();
      }finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
         try {
            if(pstmt!=null)pstmt.close();
            if(conn!=null)conn.close();
         }catch(Exception e) {}
      }
      //변화된 row 의 갯수가 0 보다 크면 작업 성공
      if(rowCount > 0) {
         return true;
      }else {//그렇지 않으면 작업 실패
         return false;
      }
   }
}
