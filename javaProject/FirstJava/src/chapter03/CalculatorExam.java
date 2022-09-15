package chapter03;

import java.util.Scanner;

public class CalculatorExam {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의 
		 * ② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의 
		 * ③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의 
		 * ④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
		 * ⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의 원의 둘레 : 2 x π x r
		 * ⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의 월의 넓이 : π x r x r
		 * ⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.
		 * ⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드에 추가해봅시다.
		 */
		
		//7.메인 메소드 정의
//			//1.더하기 연산 후 출력
//			plus(23, 234);
//			//2.빼기 연산 후 출력
//			minus(234,2);
//			//3.곱하기 연산 후 출력
//			mul(23, 3);
//			//4.나누기 연산 후 출력
//			div(123, 4);
//			//5.원의둘레
//			circle(5);
//			//6.원의넓이
//			circle2(5);
			
		//8. 사용자에게 데이터를 받아 메소드 호출
		
			int num1 = 0;
			int num2 = 0;
			double num3 = 0;

			num1 = inNum1();
			num2 = inNum2();
			//1.더하기 연산 후 출력
			plus(num1, num2);
			//2.빼기 연산 후 출력
			minus(num1,num2);
			//3.곱하기 연산 후 출력
			mul(num1, num2);
			//4.나누기 연산 후 출력
			div(num1, num2);
			
			num3 = inNum3();
			//5.원의둘레
			circle(num3);
			//6.원의넓이
			circle2(num3);
	
	}
	
	public static int plus(int num1, int num2) 
	{
		int result = 0;
		result =  num1 + num2;
		System.out.println(num1 +"+"+ num2 +"="+ result );
		return result;
	}
	
	public static int minus(int num1, int num2) 
	{
		int result = 0;
		result = num1 - num2;
		System.out.println(num1 +"-"+ num2 +"="+ result );
		
		return result;
	}
	
	public static int mul(int num1, int num2) 
	{
		int result = 0;
		result = num1 * num2;
		System.out.println(num1 +"*"+ num2 +"="+ result );
		
		return result;
	}
	
	public static int div(int num1, int num2) 
	{
		int result = 0;
		result = num1 / num2;
		System.out.println(num1 +"/"+ num2 +"="+ result );
		
		return result;
	}
	
	public static double circle(double num1) {
		double result =0;
		result = 2*3.14*num1;
		System.out.println("2 * 3.14 *"+ num1 +"="+ result );
		return result;
	}
	
	public static double circle2(double num1) {
		double result =0;
		result = 3.14*num1*num1;
		System.out.println("3.14 *"+ num1 +"*"+num1+"="+ result );
		return result;
	}
	
	public static int inNum1() {
		int num = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력해주세요 >>>");
		num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	public static int inNum2() {
		int num = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두번째 숫자를 입력해주세요 >>>");
		num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	public static double inNum3() {
		double num = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반지름을 입력해주세요 >>>");
		num = Integer.parseInt(sc.nextLine());
		return num;
	}

}
