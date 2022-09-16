package chapter04.exam;

public class Chapter4_exam6 {

	public static void main(String[] args) {

		/*문제 6.
		1 부터 99까지의 합을 구하는 프로그램 작성
		while문, for문, do while 문을 각각 사용*/
	
		int num = 1;
		int sum = 0;
		
		while(num < 100) {
			sum += num;
			num++;
		}
		System.out.println("while 문을 이용한 1~99까지의 합 : " + sum);
		
		sum = 0;
		for(num=1; num<100; num++) {
			sum += num;
		}
		System.out.println("for 문을 이용한 1~99까지의 합 : " + sum);
		
		num = 1;
		sum = 0;
		do {
			sum += num;
			num++;
		}while(num < 100);
		System.out.println("do while 문을 이용한 1~99까지의 합 : " + sum);
		
	}

}
