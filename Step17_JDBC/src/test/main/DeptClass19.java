package test.main;

import test.dao.DeptDto;
import test.dto.DeptDao;

public class DeptClass19 {
	public static void main(String[] args) {
		//수정할 부서의 정보
		int deptno=10;
		String loc="BUSAN";
		//수정할 회원의 정보를 DeptDto 객체에 담는다.
		DeptDto dto=new DeptDto();
		dto.setDeptno(deptno);
		dto.setLoc(loc);
		//DeptDao 객체를 생성해서 update()메소드를 이용해 수정하고 성공여부 리턴 받기
		DeptDao dao=new DeptDao();
		boolean isupdate=dao.update(dto);
		if(isupdate) {
			System.out.println("수정했습니다.");
		}
	}
}
