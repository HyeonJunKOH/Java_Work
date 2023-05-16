package test.main;

import test.dto.DeptDao;

public class DeptClass20 {
	public static void main(String[] args) {
		//삭제할 부서의 정보
		int deptno=50;
		
		boolean isdelete= new DeptDao().delete(deptno);
		if(isdelete) {
			System.out.println("삭제했습니다.");
		}
	}
}
