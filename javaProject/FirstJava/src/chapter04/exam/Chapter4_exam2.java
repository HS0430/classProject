package chapter04.exam;

public class Chapter4_exam2 {

	public static void main(String[] args) {
		/*
		 * 문제2
		 * 자연수 1부터 시작해서 : 반복문 1부터~ 
		 * 모든 홀수와 3의 배수인 짝수를 더해 나간다. : 합을 구한다 - > 홀수 또는 3의 배수 
		 * 그리고 그 합이 언제 (몇을 더했을 때) 1000이 넘어서는지,	: break;
		 * 그리고 1000이 넘어선 값은 얼마가 되는지 계산하여 출력하는 프로그램을 작성.
		 * 
		 * 프로그램 내부에 while문을 무한 루프로 구성하여 작성.
		 */
		
		//숫자를 증가시키는 변수
		int num = 1;
		
		//합을 구하기 위한 변수
		int sum = 0;
		
		while(true) {
			
			if(num%2 == 1 || num%3 == 0) {	//num을 2로나누어 나머지가 1인 수 (홀수) 또는 num을 3으로 나누어 나머지가 0인 수 3의 배수
				sum += num;					// sum에 조건에 맞는 num 값을 더함
			}
			
			if(sum > 1000) {	//sum이 1000보다 크면 break;
				break;
			}
			num++;
			
		}
		
		System.out.println("최초 합이 1000이 넘어가는 값 : " + sum);
		System.out.println("최초 합이 1000이 넘어가는 더해준 값 : " + num);
	}

}
