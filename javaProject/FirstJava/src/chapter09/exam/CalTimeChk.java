package chapter09.exam;

import java.time.LocalTime;

public class CalTimeChk {

	public static void main(String[] args) {

//		1~100,000,000까지 더하기하는 연산의 실행 시간을 측정하는 프로그램을 만들어봅시다. 
		long startTime = System.currentTimeMillis();
		System.out.println("연산 시작 시간 : " + startTime);

		int sum = 0;
		for (int i = 1; i <= 100000000; i++) {
			sum += i;
		}

		long endTime = System.currentTimeMillis();
		System.out.println("연산 종료 시간 : " + endTime);

		long checkTime = endTime - startTime;

		System.out.println("실행 시간 : " + (double)checkTime/1000);
		System.out.println("연산 결과 값 : " + sum);
	}
}
