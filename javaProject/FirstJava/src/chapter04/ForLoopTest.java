package chapter04;

public class ForLoopTest {

	public static void main(String[] args) {

			// "JAVA" 출력을 5번
		for(int i=0; i<5; i++) {
			
			System.out.println("JAVA" + i);
			
		}
		
		// 1~10까지의 숫자중 짝수만 출력
//		for(int i=1; i<=10; i++) {
//			if(i%2==0) {
//				System.out.println(i);
//			}
//		}
		
		for (int i=0; i<=10; i+=2) {
			System.out.println(i);
		}
	}

}
