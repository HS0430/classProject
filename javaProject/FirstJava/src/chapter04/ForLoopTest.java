package chapter04;

public class ForLoopTest {

	public static void main(String[] args) {

			// "JAVA" 출력을 5번
		for(int i=0; i<5; i++) {	// i=0 부터 5보다 작을 때까지 +1씩 증가하며 동작 -> 0 1 2 3 4 총 5번 반복
			
			System.out.println("JAVA" + i);
			
		}
		
		// 1~10까지의 숫자중 짝수만 출력
//		for(int i=1; i<=10; i++) {
//			if(i%2==0) {
//				System.out.println(i);
//			}
//		}
		
		for (int i=0; i<=10; i+=2) {		// i=0부터 10보다 작거나 같을 때 까지 2씩 증가하며 반복 -> 0 2 4 6 8 10
			System.out.println(i);
		}
	}

}
