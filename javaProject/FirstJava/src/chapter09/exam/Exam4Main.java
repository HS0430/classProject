package chapter09.exam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exam4Main {

	public static void main(String[] args) {
		
		// 자신의 생일을 기준으로 오늘까지 몇 일을 살았는지 출력하는 프로그램을 만들어봅시다.
		LocalDate birthDay = LocalDate.of(1999, 10, 10);
		LocalDate now = LocalDate.now();
		
		long days = ChronoUnit.DAYS.between(birthDay, now);
		System.out.println("태어난 생일 기준 " + days + "일 째");
		
		LocalDate cDay = LocalDate.of(2022, 12, 25);
		
		long days2 = ChronoUnit.DAYS.between(now, cDay);
		System.out.println(days2);
		
		LocalDate dDay = now.plusDays(88);
		System.out.println(dDay);
		
		
	}
	
}
