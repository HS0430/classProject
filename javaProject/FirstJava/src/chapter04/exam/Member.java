package chapter04.exam;

import java.text.SimpleDateFormat;
import java.util.*;

public class Member {
	public static void main(String[] args) {
		
		 /*
		  * ① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
			- 매개변수로 태어난 해(년도)를 전달받습니다.
			- 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
			- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.
			② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
			- 매개변수로 태어난 해(년도)를 전달받습니다.
			- 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
			- 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
			- 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.
		 */

		Scanner in = new Scanner(System.in);
		
		String name = null;
		int age = 0;
		String nickName = null;
		double height = 0.0;
		boolean hasBook = false;
		String strHasBook = null;
		
		System.out.print("이름을 입력해 주세요. >>> ");
		name = in.nextLine();	//문자열 입력받기
		
		System.out.print("나이를 입력해 주세요. >>> ");
//		age = Integer.parseInt(in.nextLine());
		age = in.nextInt();	//정수형 입력받기
		
		in.nextLine();
		
		System.out.print("별명을 입력해 주세요. >>> ");
		nickName = in.nextLine();
		
		System.out.print("키를 입력해 주세요. >>> ");
		height = in.nextDouble();
		
		System.out.print("책 보유 여부를 입력해 주세요. >>> ");
		hasBook = in.nextBoolean();
		in.nextLine();
		if(hasBook == true) // 책 보유여부 확인
			strHasBook = "보유 O";
		else
			strHasBook = "보유 X";
		
		System.out.println("이름은 "+name+" 입니다.");
		System.out.println("나이는 "+age+"세 입니다.");
		System.out.println("닉네임은 "+nickName+" 입니다.");
		System.out.println("키는 "+height+"cm 입니다.");
		System.out.println("자바 책의 보유 여부 : "+strHasBook);
		
		System.out.print("출생년도 4자리를 입력해주세요. >>>");
		int year = Integer.parseInt(in.nextLine());	//문자열 입력받은 후 정수형으로 변환
		
		flu(year);	//독감예방 접종이 가능한지 여부
		healthScreening(year);	//건강검진 대상 여부
		
		in.close();
	}
	
	public static void flu(int date) {
		
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));	//현재 연도 구하기 'yyyy'
		int targetYear = (year-date)+1;	//현재연도 - 입력연도 +1 나이 구하기
		
		if((targetYear < 15 && targetYear > 0) || targetYear >= 65)	// 1살 이상 15세 미만, 65세 이상 무료접종 대상자 조건문 
			System.out.println("무료예방접종이 가능합니다.");
		else 
			System.out.println("무료접종 대상이 아닙니다.");
	}
	
	public static void healthScreening(int date) {
//		- 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
//		- 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
//		- 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.
		
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));	//현재 연도 구하기 'yyyy'
//		int year = 2023;
		int targetYear = (year-date)+1;	//현재연도 - 입력연도 +1 나이 구하기
		
		if(targetYear >= 20) {	//20세 이상
			if(date%2==0 && year%2==0)	//현재 연도 및 태어난연도 짝수 확인 
				System.out.println("20세 이상 짝수 해 / 짝수년이므로 건강검진 대상자 입니다.");
			else if(date%2 !=0 && year%2 !=0)//현재 연도 및 태어난연도 홀수 확인
				System.out.println("20세 이상 홀수 해 / 홀수년이므로 건강검진 대상자 입니다.");
			else
				System.out.println("이번 해 건강검진 대상자가 아닙니다.");
			
			if(targetYear >= 40) {	//40세 이상
				System.out.println("40세 이상, 무료 암 검사 대상자 입니다.");
			}
		}
	}
}
