package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 	세명의 회원정보를 HashMap 객체에 각각 담아서
		 * 	
		 * 	ArrayList 객체에 누적 시켜 보세요.
		 * 
		 * 	반복문 돌면서 ArrayList 객체에 누적된 회원정보를 콘솔창에 순서대로 출력해보세요.
		 * 
		 * (HashMap 객체3개,ArrayList 객체1개가 생성이 되어야 합니다.)
		 * 
		 *  ArrayList 객체 안에 HashMap을 담을 예정이니
		 *  
		 *  List<HashMap<String,Object>>type이 필요합니다.
		 */
		
		List<HashMap<String,Object>>members=new ArrayList<>();
		HashMap<String,Object>mem1=new HashMap<>();
		mem1.put("num",1);
		mem1.put("name", "김구라");
		mem1.put("addr", "노량진");
		HashMap<String,Object>mem2=new HashMap<>();
		mem2.put("num",2);
		mem2.put("name", "해골");
		mem2.put("addr", "응암동");
		HashMap<String,Object>mem3=new HashMap<>();
		mem3.put("num",3);
		mem3.put("name", "원숭이");
		mem3.put("addr", "개포동");
		
		members.add(mem1);
		members.add(mem2);
		members.add(mem3);
		
		for(HashMap<String, Object> tmp:members) {
			//번호
			int num=(int)tmp.get("num");
			//이름
			String name=(String)tmp.get("name");
			//주소
			String addr=(String)tmp.get("addr");
			System.out.println("num:"+num+",name:"+name+",addr:"+addr);
		}
	}
}
