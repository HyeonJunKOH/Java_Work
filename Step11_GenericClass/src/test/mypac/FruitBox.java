package test.mypac;
/*
 * 	클래스 안에서 사용하는 특징 type 을 고정하지 않고
 * 
 * 	클래스를 사용하는 시점에 type 을 정할 수 있게 해준다.
 * 
 * 	- 아래 선언한 T는 마음대로 스펠링이나 단어를 정할 수 있다.
 * 	- 보통 type 이라는 의미에서 T라고 많이 정한다.
 * 	- T를 포괄 클래스(Generic Class)라고 한다.
 * 
 */

//가상의 과일 박스
public class FruitBox<T> {
	//필드
	private T item;
	
	//과일을 포장하는 메소드
	public void pack(T item) {
		this.item=item;
	}
	//과일을 리턴하는 메소드
	public T unPack() {
		return item;
	}
} 
