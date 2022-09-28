package chapter10;

import java.util.Scanner;

public class ExceptonTryCatchTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자1을 입력하세요. >>");
		int num1 = sc.nextInt();

		System.out.print("숫자2를 입력하세요. >>");
		int num2 = sc.nextInt();

		try {
			System.out.println("num1 / num2 = " + (num1 / num2)); // <= 예외가 발생 할 수 있는 위치

			String str = null;
//			System.out.println(str.length());
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나누는 것은 불가합니다.");
			ae.printStackTrace();
			System.out.println(ae.getMessage());
			return;
		} catch (NullPointerException ne) {
			System.out.println("null!");
		} catch (Exception e) {
			System.out.println("예외 발생");
		}
		finally {
			System.out.println("무조건 실행");
		}
		System.out.println("프로그램 처리 완료.");
	}
}
