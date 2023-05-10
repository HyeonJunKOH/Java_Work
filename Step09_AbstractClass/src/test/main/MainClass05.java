package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	
	static class SeaWeapon extends Weapon{

		@Override
		public void attack() {
			System.out.println("바다에 있는 적들을 공격해요!");
		}
		
	}
	public static void main(String[] args) {
		//바다를 공격하는 무기를 만들어서 사용하고 싶다.
		Weapon w1 = new SeaWeapon();
		w1.prepare();
		w1.attack();
		
		//우주를 공격하는 무기를 만들어서 이용하고 싶다.
		class SpaceWeapon extends Weapon{

			@Override
			public void attack() {
				System.out.println("우주에 있는 적들을 공격해요!");
			}
		}
		Weapon w2 = new SpaceWeapon();
		w2.prepare();
		w2.attack();
	}
}
