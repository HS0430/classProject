package chapter10;

import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		
		// 사용자로 부터 숫자 두개를 받는다
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자1을 입력하세요. >>");
		int num1 = sc.nextInt();
		
		System.out.print("숫자2를 입력하세요. >>");
		int num2 = sc.nextInt();
		
		if(num2 == 0) {
			System.out.println("나누는 수는 0이 될 수 없습니다.");
		}
		else {
			System.out.println("num1/num2 => " + (num1/num2));
		}
		System.out.println("프로그램을 종료 합니다.");
	}

}
