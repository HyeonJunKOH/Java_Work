package test.main;

import test.dao.MemberDao;


public class MainClass15 {
	public static void main(String[] args) {
		//삭제할 회원의 정보
		int num=2;
		
		
		//위의 정보를 이용해서 회원정보를 삭제하고 성공이면 삭제했습니다.가 출력되도록 해보세요.
		
		
		boolean isdelete = new MemberDao().delete(num);
		if(isdelete) {
			System.out.println("삭제했습니다.");
		}
		
	}
}
