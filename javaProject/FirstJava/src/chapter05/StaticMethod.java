package chapter05;

public class StaticMethod {

	static int num1 = 10;	// 클래스 변수
	int num2;	// 인스턴스 변수
	
	static void staticMethod() {
		
		System.out.println("staticMethod");
//		System.out.println(num2);	// 인스턴스 생성 없이 사용이 불가
		// 클래스 멤버에 인스턴스 멤버는 사용 불가
		
		
//		instanceMethod(); // 인스턴스 생성없이 사용 불가
		StaticMethod sm = new StaticMethod();	// 사용을 위해서 인스턴스 생성
		sm.instanceMethod();
		
	}
	
	void instanceMethod() {
		
		System.out.println("instanceMethod");
		System.out.println(num1);
		staticMethod();
		
	}
}
