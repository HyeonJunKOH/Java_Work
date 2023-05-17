package test.main;

import test.dao.DeptDao;
import test.dto.DeptDto;

public class DeptClass01 {
	public static void main(String[] args) {
		//새로 추가할 부서정보
		int deptno=50;
		String dname="KOH";
		String loc="SEOUL";
		
		DeptDto dto=new DeptDto();
		dto.setDeptno(deptno);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		DeptDao dao=new DeptDao();
		boolean isselect=dao.insert(dto);
		if(isselect) {
			System.out.println("저장했습니다.");
		}
		
	}
}
