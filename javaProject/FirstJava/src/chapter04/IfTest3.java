package chapter04;

import java.util.Scanner;

public class IfTest3 {

	public static void main(String[] args) {

		// 점수에 따라서 학점 표기를 합시다
		// 100~97	: A+
		// 94~96	: A
		// 90~93	: A-
		// 80점 대 	: B+, B, B-
		// 70점 대	: C+, C, C-
		// 나머지		: F
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 입력 >>> ");
		int score=sc.nextInt();
		String result ="F";		//학점 기본 값 F 90점이상, 80점이상, 70점이상 조건에 해당하지 않으면 디폴트 F값을 출력
		
		if(score >= 90) {	// A, A+, A- 90점보다 크거나 같음
			result = "A";	// 아래 97보다 크거나 93보다 작거나 두가지의 조건에 해당하지 않으면 A
			
			if(score >=97) {	// 97보다 크거나 같음
				result += "+";
			}
			if(score <= 93) {	//93보다 작거나 같음
				result += "-";
			}
		}
		
		else if(score >= 80){	// B, B+, B-
			result = "B";
			
			if(score >= 87) {
				result += "+";
			}
			else if(score <= 83) {
				result += "-";
			}
		}
		
		else if(score >= 70){	// C, C+, C-
			result = "C";
			
			if(score >= 77) {
				result += "+";
			}
			else if(score <= 73) {
				result += "-";
			}
		}
		
//		else {
//			result = "F";
//		}
		
		System.out.println("학점 : " + result);
		
	}

}
