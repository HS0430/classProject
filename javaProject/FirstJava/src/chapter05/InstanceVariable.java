package chapter05;

public class InstanceVariable {
	// 인스턴스 변수는 인스턴스 생성 시에 생성해서 인스턴스 소멸할 때 까지의 생명주기
	// 인스턴스 변수 클래스 멤버들(변수, 메소드)이 참조 가능하다.
	int iv; // 인스턴스 변수는 자동 초기화
	int iv2 = iv;

	void instanceMethod(int num) {
		System.out.println(iv);
		// 참조변수.변수
	}

	void instanceMethod2(int num) {
		System.out.println(iv);
		// 참조변수.변수
	}

	public static void main(String[] args) {
		InstanceVariable iv = new InstanceVariable();
		System.out.println(iv.iv);

		System.out.println(iv.iv);
	}

}
