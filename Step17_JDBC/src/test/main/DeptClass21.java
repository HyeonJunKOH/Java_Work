package test.main;


import java.util.Scanner;

import test.dao.DeptDto;
import test.dto.DeptDao;

public class DeptClass21 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 부서번호 입력");
		int deptno=scan.nextInt();
		
		DeptDto dto=new DeptDao().getData(deptno);
		if(dto!=null) {
			System.out.println(deptno+"번 부서의 이름은:"+dto.getDname()+"주소는:"+dto.getLoc());
		}else {
			System.out.println(deptno+"번 부서는 존재하지 않습니다.");
		}
	}
}
