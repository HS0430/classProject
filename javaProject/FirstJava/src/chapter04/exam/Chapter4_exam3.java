package chapter04.exam;

public class Chapter4_exam3 {

	public static void main(String[] args) {

		/*
		 * 구구단의 짝수 단(2,4,8)만 출력하는 프로그램 작성.
		 * 
		 * 단, 2단은 2x2까지, 4단은 4x4까지, 8단은 8x8 까지 출력
		 */
		
		for(int i=2; i<10; i*=2) { //i=2 부터 시작 i가 10보다 작을 때 까지 반복, i는 *2만큼 증가
			System.out.println(i);
			
			for(int j=1; j<=i; j++) {	// j=1 부터 시작, i보다 작거나 같을 때 까지 반복, j는 1씩 증가
				System.out.println(i + " X " + j);
			}
		}
	}

}
