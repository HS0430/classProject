package chapter04.exam;

public class Chapter4_exam1 {

	public static void main(String[] args) {
		//	문제1. for 문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성
		
		int result = 1;
		
		for(int num=1; num<=10; num++) {
			result *= num;
			System.out.println(num + " * " + result + " = " + result*num + "\n");
		}
	}

}
