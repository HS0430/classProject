package chapter04.exam;

public class Chapter4_exam5 {

	public static void main(String[] args) {

		/*
		 * n=1 일 때  “현재 인원은 1명 입니다.”
		 * n=2 일 때  “현재 인원은 2명 입니다.”
		 * n=3 일 때  “현재 인원은 3명 입니다.”
		 * n>3 일 때  “현재 많은 사람들이 있습니다.”
		 * 위의 내용이 출력 되는 프로그램을 작성. 각각 If 문과 switch 문 사용
		 */

		int n = 1;
		
		if(n == 1) {	//if else if else로 조건 구분
			System.out.println("현재 인원은 1명 입니다.");
		}
			
		else if(n == 2) {
			System.out.println("현재 인원은 2명 입니다.");
		}
		
		else if(n == 3) {
			System.out.println("현재 인원은 3명 입니다.");
		}
		
		else {
			System.out.println("현재 많은 사람들이 있습니다.");
		}
		
		
		if(n>3) {	// if와 else로 3명보다 많거나 그 외에 구분 후, else 내에서 1,2,3명일 때 구분
			System.out.println("현재 많은 사람들이 있습니다.");
		}
		else {
			if(n==1) {
				System.out.println("현재 인원은 1명 입니다.");
			}
			else if(n==2) {
				System.out.println("현재 인원은 2명 입니다.");
			}
			else if(n==3) {
				System.out.println("현재 인원은 3명 입니다.");
			}
		}
		
		switch(n) {	//스위치 문으로 1,2,3,default(3보다 큼)으로 구분
		case 1:
			System.out.println("현재 인원은 1명 입니다.");
			break;
		case 2:
			System.out.println("현재 인원은 2명 입니다.");
			break;
		case 3: 
			System.out.println("현재 인원은 3명 입니다.");
			break;
		default :
			System.out.println("현재 많은 사람들이 있습니다.");
		}
		
	}

}
