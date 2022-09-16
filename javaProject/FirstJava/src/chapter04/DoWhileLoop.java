package chapter04;

public class DoWhileLoop {

	public static void main(String[] args) {

			// do while : 먼저 한번을 반드시 처리한 후 반복해야할 경우
		int cnt = 0;
		
		do {		// 최소 1번은 무조건 do안에 내용을 실행
			//반복할 문장
			System.out.println("JAVA" + cnt);
			cnt++;
		}
		
		while(cnt < 0);		// cnt가 0보다 작을 경우에 반복 (현재 cnt =0 이므로 do에서 1회 실행 후 동작 종료)
	}

}
