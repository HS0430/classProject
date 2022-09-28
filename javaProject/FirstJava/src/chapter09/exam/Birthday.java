package chapter09.exam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Birthday {

	public static void main(String[] args) {

		// 자신의 생일을 기준으로 오늘까지 몇 일을 살았는지 출력하는 프로그램을 만들어봅시다.

		Scanner sc = new Scanner(System.in);
		System.out.print("생년월일을 입력해주세요. >> ");
		String birth = sc.nextLine();

		int year = Integer.parseInt(birth.substring(0, 4));
		int month = Integer.parseInt(birth.substring(4, 6));
		int day = Integer.parseInt(birth.substring(6, 8));

//		LocalDate birthDay = LocalDate.of(1990, 11, 25);
		LocalDate birthDay = LocalDate.of(year, month, day);
		LocalDate now = LocalDate.now();

		long days = ChronoUnit.DAYS.between(birthDay, now);
		System.out.println("태어난 생일 기준 " + days + "일 째");
		
		sc.close();

	}
}
