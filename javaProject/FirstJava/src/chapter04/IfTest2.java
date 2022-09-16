package chapter04;

public class IfTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//짝수 홀수 판별
		int num1 = 16;
		
		if(num1%2 ==0) {	//num1을 2르 나누어 나머지가 0인 조건 (짝수)
			System.out.println("짝수");
		}
		else {	//위 조건에 해당하지 않은 수 (홀수)
			System.out.println("홀수");
		}
		
		int num2 = -10;
		// 0, 음수, 양수
		if(num2 > 0) {	// num2가 0보다 크다 (양수)
			System.out.println("양수");
		}
		else if(num2 == 0) {	//위 조건에 해당하지 않음,  num2가 0
			System.out.println("0");
		}
		else {		// num2가 0보다 크거나 0인 경우를 제외한 나머지 (음수)
			System.out.println("음수");
		}
	}

}
