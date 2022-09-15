package chapter04;

public class IfTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int score = 69;
		
		// 60점 이상이면 PASS 출력
		if (score >= 60) {
			//조건식의 결과가 true 일 때 처리되는 구문
			System.out.println("PASS");
		}
		
		// 60점 이상이면 PASS 출력,  60점 미만이면 FAIL 출력
		if(score >= 60) {
			//조건식의 결과가 true 일 때 처리되는 구문
			System.out.println("PASS");
		}
		else {
			//조건식의 결과가 false 일 때 처리되는 구문
			System.out.println("FAIL");
		}
		
		//90점 이상이면 A 출력
		//90점 미만 80점 이상 B 출력,
		//80점 미만 70점 이상 C 출력,
		//70점 미만 나머지 FAIL
		if(score >= 90) {
			System.out.println("A");
		}
		else if(score >= 80) {	// 80 <= score < 90
			System.out.println("B");
		}
		else if(score >= 70) {	// 70 <= score < 80
			System.out.println("C");
		}
		else {	// score < 70
			System.out.println("FAIL");
		}
	}

}
