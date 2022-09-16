package chapter04.exam;

import java.util.Calendar;
import java.util.Scanner;

public class Member_exam {

	public static void main(String[] args) {
//			int currYear = Calendar.getInstance().getWeekYear();
		while (true) {
//			int birthYear = 0;
			Scanner sc = new Scanner(System.in);
			System.out.print("출생년도 4자리를 입력해주세요. 종료는 (0) >>> ");

			int birthYear = sc.nextInt();	// 출생년도 입력 받음 (Scanner)

			if (birthYear == 0) {	// 출생년도 입력에 0을 입력하면 해당 조건문으로 들어옴 > Scanner 종료하고 return (main메소드 리턴은 프로그램 종료)
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;		//메소드의 종료, 반환
				//메인 메소드의 종료는 프로그램의 종료
			}

			System.out.println("조회결과");
			System.out.println("----------------");
			checkVaccine(birthYear);	// 백신 접종 가능 여부 체크 메소드
			System.out.println("----------------");
			checkMedical(birthYear);	// 무료 검진 및 암검사 가능 여부 체크 메소드
			System.out.println("----------------");

		}
	}

	/*① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
	- 매개변수로 태어난 해(년도)를 전달받습니다.
	- 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
	- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.*/
	public static void checkVaccine(int birthYear) {
		//올해년도
		int currYear = Calendar.getInstance().get(Calendar.YEAR);	//캘린더에서 Year에 대한 인스턴스를 가져옴
		
		//나이계산
		int age = currYear - birthYear +1;	// 만나이가 아니므로 현재년도 - 출생년도 + 1
		
		System.out.println("나이 : " + age);
		
		if((age > 0 && age<15) || age >= 65) {		// 1살 이상이면서 15세 미만 또는 65세 이상 
			System.out.println("무료 예방접종이 가능합니다.");
		}
		else {
			System.out.println("무료 접종 대상이 아닙니다.");
		}
		
	}
	
	/*
	 * ② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다. 
	 * - 매개변수로 태어난 해(년도)를 전달받습니다. 
	 * -대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다. 
	 * - 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사대상이 됩니다.		:태어난 해의 %2 결과값과 올해 년의 %2한 값이 일치한다. 
	 * - 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.		:if 중첩
	 */
	public static void checkMedical(int birthYear) {
		//올해년도
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		
		//나이
		int age = currYear - birthYear +1;
		
		System.out.println("나이 : " + age);
		
		if(age >= 20) {		// 20세 이상
			if(currYear %2 == birthYear %2) {	// 현재년도/2의 나머지값과 출생년도/2의 나머지 값이 같은 경우 (짝수년 짝수년출생, 홀수년 홀수년출생)
				System.out.println("무료 검진이 가능 합니다.");
				if(age >= 40) { // 40세 이상
					System.out.println("암 검사도 무료로 진행합니다.");
				}
			}
			else {
				System.out.println("무료 검진 대상이 아닙니다.");
			}
		}
		else {
			System.out.println("20세 미만은 무료 검진대상이 아닙니다.");
		}
		
	}

}
