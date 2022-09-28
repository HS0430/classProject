package chapter09;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTest {

	public static void main(String[] args) {
		
		// jdk 1.8 : LocalDate, LocalDateTime, LocalTime
		// 현재 날짜를 가져오자
		LocalDate now = LocalDate.now();
		System.out.println(now);
		System.out.println(now.getYear());
		System.out.println(now.getMonth());			// 월 영문 표시 ex) SEPTEMBER
		System.out.println(now.getMonthValue());	// 월 (숫자표시)
		System.out.println(now.getDayOfWeek());		// 이번주의 몇번쨰 날짜 (요일)
		System.out.println(now.getDayOfMonth());	// 이번달의 몇번쨰 날짜
		System.out.println(now.getDayOfYear());		// 이번해의 몇번째 날자
		LocalDate nextDay = now.plusDays(1).plusMonths(1).plusYears(1);
		System.out.println(nextDay);
		
		System.out.println("===========================================================================");
		
		LocalTime now1 = LocalTime.now();
		System.out.println(now1);
		System.out.println(now1.getHour());
		System.out.println(now1.getMinute());
		System.out.println(now1.getSecond());
		System.out.println(now1.getNano());
		
		System.out.println("===========================================================================");
		
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		
		System.out.println(now2.getYear());
		
		System.out.println("===========================================================================");
		
		LocalDate day = LocalDate.of(2022, 12, 25);
		System.out.println(day);
		LocalTime time = LocalTime.of(15, 30, 35);
		System.out.println(time);
		LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 10, 17, 05);
		System.out.println(localDateTime);
		
		
	}
}
