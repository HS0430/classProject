package chapter09.exam;

public class CalTimeChk {

	public static void main(String[] args) {

//		1~100,000,000까지 더하기하는 연산의 실행 시간을 측정하는 프로그램을 만들어봅시다. 
		long startTime = System.currentTimeMillis();
		long sTime = System.nanoTime();
		System.out.println(startTime);
		System.out.println(sTime);
		int sum = 0;
		for (int i = 1; i <= 100000000; i++) {
			sum += i;
		}
		long endTime = System.currentTimeMillis();
		long eTime = System.nanoTime();
		System.out.println(endTime);
		System.out.println(eTime);

		long checkTime = endTime - startTime;
		long chkTime = eTime - sTime;

		System.out.println("실행 시간 : " + checkTime);
		System.out.println("실행 시간 : " + chkTime);

		System.out.println(sum);
	}
}
