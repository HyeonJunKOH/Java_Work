package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass13 {
	public static void main(String[] args) {
		//새로 추가할 회원정보
		String name="누구게";
		String addr="어디게";
		
		//위의 정보를 DB에 저장하고 저장이 성공되었다면 "저장했습니다"를 콘솔창에 출력하는 기능을 만들고 싶다면?
		
		//추가할 회원의 이름과 주소를 dto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setAddr(addr);
		dto.setName(name);
		//MemberDao 객체를 이용해서 회원정보를 저장하고 성공여부를 리턴 받는다.
		MemberDao dao = new MemberDao();
		boolean isSuccess=dao.insert(dto);
		if(isSuccess) {
			System.out.println("저장했습니다.");
		}
	}
}
