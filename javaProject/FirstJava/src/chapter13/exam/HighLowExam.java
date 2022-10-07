package chapter13.exam;

import java.util.Scanner;

public class HighLowExam extends Thread {
//	③ 10초 카운팅은 스레드를 이용해서 처리해봅시다.
//	④ 10초 이전에 맞추면 미션 성공, 10초가 지나면 프로그램 종료하는 흐름으로 만들어봅시다.
	
	static boolean chkThread = true;
	public static void main(String[] args) {
		
		HighLowExam t = new HighLowExam();
		t.start();
		

		Scanner sc = new Scanner(System.in);
		
//		① 1~100 사이의 랜덤 한 숫자를 추출합니다.
		int a = (int)(Math.random()*100)+1;
		while(chkThread) {
			System.out.print("1 ~ 100 사이에 숫자를 입력해주세요 >> ");
			
	//		사용자에게 숫자를 입력 받고
			int b = sc.nextInt();
			
	//		랜덤 숫자와 비교, 높은 숫자인지 낮은 숫자인지 출력
			if(a == b) {
				System.out.println("정답");
				break;
			}
			else if(a > b) {
				System.out.println("High");
			}
			else if(a < b) {
				System.out.println("Low");
			}
		}
	}
	
	@Override
	public void run() {
		
		try {
			for(int i=1; i<=10; i++) {
				sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chkThread = false;
	}	
}
