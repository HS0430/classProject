package chapter05;

// 기능만 제공하는 클래스 : 사칙연산
public class Calculator {
	
	long add(long num1, long num2) {
		return num1 + num2;
	}
	
	// 메소드의 오버로딩 : 같은 이름의 메소드를 정의하는 것
	// 오버로딩의 조건 : 매개변수의 타입이 다르거나, 매개변수의 개수가 다를 때 가능하다.
	// 메소드의 구분은 메소드 호출시에 정의되는 매개변수 인자값에 따라 메소드가 선택된다.
	// 메소드 이름 (문자열 값, 정수 값, 정수 값)
	
	// 오버로딩 메소드 정의
	float add(float num1, float num2) {
		return num1+num2;
	}
	
	int add(int num1, int num2) {
		return num1+num2;
	}
	
	long add(int num1, long num2) {
		return num1+num2;
	}
	
	long multiply(int num1, int num2) {
		return num1*num2;
	}
}
