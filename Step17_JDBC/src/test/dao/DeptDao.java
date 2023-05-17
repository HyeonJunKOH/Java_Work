package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.DeptDto;
import test.util.DBConnect;

public class DeptDao {
	//인자로 전달되는 번호에 해당하는 부서번호의 정보를 리턴하는 메소드
	public DeptDto getData(int deptno) {
		//MemberDto 객체의 참조값을 담을 지역변수 미리 만들기
		DeptDto dto = null;
		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql 문(select 문)
			String sql = "select dname,loc" 
					+ " from dept" 
					+ " where deptno=?";
			pstmt = conn.prepareStatement(sql);
			//select 문이 미완성이라면 여기서 완성한다.
			pstmt.setInt(1, deptno);
			//select 문 수행하고 결과를 ResultSet 으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 row 에 있는 정보를 추출한다.
			while (rs.next()) {
				//현재 커서가 존재하는 row 에 있는 정보를 추출해서 사용한다.
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				//MemberDto 객체의 회원 한명의 정보를 담는다.
				dto = new DeptDto();
				dto.setDeptno(deptno);
				dto.setDname(dname);
				dto.setLoc(loc);
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
	
	
	//전체 부서의 정보를 리턴하는 메소드
	public List<DeptDto> getList() {
		//회원 정보를 누적할 객체 생성
		List<DeptDto> list = new ArrayList<>();

		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql 문(select 문)
			String sql = "select deptno,dname,loc"
					+	" from dept"
					+	" order by deptno desc";
			pstmt = conn.prepareStatement(sql);
			//select 문이 미완성이라면 여기서 완성한다.

			//select 문 수행하고 결과를 ResultSet 으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 row 에 있는 정보를 추출한다.
			while (rs.next()) {
				//현재 커서가 존재하는 row 에 있는 정보를 추출해서 사용한다.

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
		return list;
	}
	
	
		
		//하나의 부서 정보를 삭제하는 메소드
		public boolean delete(int deptno) {
			//필요한 객체를 담을 지역 변수를 미리 만들기
			Connection conn = null;
			PreparedStatement pstmt = null;
			//insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row 의 갯수를 담을 변수
			int rowCount = 0; //초기값을 0으로 부여한다. 
			try {
				//Connection 객체의 참조값 얻어오기
				conn = new DBConnect().getConn();
				//실행할 sql 문
				String sql = "delete from dept" 
							+ " WHERE deptno=?";
				//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
				pstmt = conn.prepareStatement(sql);
				//sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
				pstmt.setInt(1, deptno);
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
		public boolean update(DeptDto dto) {
			//필요한 객체를 담을 지역 변수를 미리 만들기
			Connection conn = null;
			PreparedStatement pstmt = null;
			//insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row 의 갯수를 담을 변수
			int rowCount = 0; //초기값을 0으로 부여한다. 
			try {
				//Connection 객체의 참조값 얻어오기
				conn = new DBConnect().getConn();
				//실행할 sql 문
				String sql = "update dept"
							+ " set dname=?, loc=?"
							+ " where deptno=?";
				//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
				pstmt = conn.prepareStatement(sql);
				//sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
				pstmt.setString(1, dto.getDname());
				pstmt.setString(2, dto.getLoc());
				pstmt.setInt(3, dto.getDeptno());
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
		
		//회원 한명의 정보를 저장하고 해당 작업의 성공여부를 리턴해주는 메소드
		public boolean insert(DeptDto dto) {

			//필요한 객체를 담을 지역 변수를 미리 만들기
			Connection conn = null;
			PreparedStatement pstmt = null;
			//insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row 의 갯수를 담을 변수
			int rowCount = 0; //초기값을 0으로 부여한다. 
			try {
				//Connection 객체의 참조값 얻어오기
				conn = new DBConnect().getConn();
				//실행할 sql 문
				String sql = "insert into dept" 
						+ " (deptno,dname,loc)" 
						+ " values(?,?,?)";
				//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
				pstmt = conn.prepareStatement(sql);
				//sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
				pstmt.setInt(1, dto.getDeptno());
				pstmt.setString(2, dto.getDname());
				pstmt.setString(3, dto.getLoc());
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
	}
