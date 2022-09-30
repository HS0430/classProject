package chapter10.exam;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Exam1Main {
	
	public static void main(String[] args) {
		// 1.콘솔에서 사용자 아이디를 입력 받아 
		//   정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다.
		// ① 사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
		// ② 예외 클래스 이름은 BadIdInputException이라고 정의합시다.

		// 1.콘솔에서 사용자 아이디를 입력 받아 
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		
//		정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인
		boolean chk1 = Pattern.matches("^[a-z0-9A-Z]*$", id);
		
		try {
			if(!chk1) {
				// 사용자 예외 클래스를 정의 예외 클래스 이름은 BadIdInputException
				throw new BadIdInputException("영문 대소문자 또는 숫자만 입력 가능합니다.");
			}
		} catch(BadIdInputException e) {
			System.out.println(e.getMessage());
		}
	}
}
