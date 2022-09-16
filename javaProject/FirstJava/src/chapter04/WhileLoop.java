package chapter04;

public class WhileLoop {

	public static void main(String[] args) {
		
		//5번 "JAVA"를 출력하는 코드 작성
		int count = 0;	// 반복 체크할 변수
		while(count++ < 5) {	// count +1씩 증가시키며, 5보다 작을 때 까지 반복
			System.out.println("JAVA");
//			count = count +1;
//			count++;
		}
	}

}
