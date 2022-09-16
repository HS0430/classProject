package chapter04;

public class ContinueTest {

	public static void main(String[] args) {

		// 1~9 사이에 홀수 만 출력
		
		int num = 0;
		
		while(num++ < 10) {		// num이 10보다 작을 떄 까지 
			
			if(num%2 == 0)		//num을 2로 나누어 나머지가 0인 경우 (짝수)
			{
				continue;		//홀수를 프린트 하기 위해 짝수인 경우 continue 하여 다시 while문으로 이동
			}
			System.out.println(num);	// 위 조건문에서 해당하지 않은 경우 출력 (홀수)
		}
	}

}
