package test.main;


import test.mypac.Weapon;

public class MainClass06 {
	public static void main(String[] args) {
		
		//아래에 있는 useWeapon() 메소드를 호출하려면 Weapon type의 참조값이 필요하다
		//익명의 Local Inner Class 를 이용해서 Weapon type 의 참조값을 얻어내서
		Weapon w1 = new Weapon(){

			@Override
			public void attack() {
				System.out.println("아무나 공격하자!");
			}
			
		};
		//사용하기
		useWeapon(w1);
		
		//메소드를 호출할때 바로 익명클래스를 이용해서 Weapon type의 참조값을 얻어내서 사용하기
		useWeapon(new Weapon() {

			@Override
			public void attack() {
				System.out.println("너만 공격한다!");
			}
			
		});
	}
	//Weapon type의 참조값을 전달 받아서 사용하는 static 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.attack();
	}
}
