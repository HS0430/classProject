package first;

public class Calculator {
	public static void main(String[] args) {
		/*
			숫자 두 개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합시다.
			숫자 두 개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합시다.
			숫자 두 개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합시다.
			숫자 두 개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합시다.
		*/
		
		System.out.println("10+20="+add(10,20));
		System.out.println("100-10="+substract(100,10));
		System.out.println("10*20="+multiply(100, 100));
		System.out.println("20/10="+divide(10, 2));
	}
	
//	숫자 두 개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합시다.
	public static long add(long a, long b)
	{
//		long result = a + b; 
//		return result;
		return a+b;
	}
	
//	숫자 두 개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합시다.
	public static long substract(long a, long b)
	{
//		long result = a - b;
//		return result;
		return a-b;
	}
	
//	숫자 두 개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합시다.
	public static long multiply(long a, long b)
	{
//		long result = a * b;
//		return result;
		return a*b;
	}
	
//	숫자 두 개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합시다.
	public static double divide(double a, double b)
	{
//		long result = a / b;
//		return result;
		return a/b;
	}
	
}

