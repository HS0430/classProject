package chapter04;

public class ForLoopTest2 {

	public static void main(String[] args) {

		// 2단
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		// 2 x 9 = 18
		
		// 2단
		// 3 x 1 = 3
		// 3 x 2 = 6
		// ...
		// 3 x 9 = 27
		// ...
		
		// 9단
		// 9 x 1 = 9
		// 9 x 2 = 18
		// ...
		// 9 x 9 = 81
		
//		int num = 2;
//		for(int num=2; num<10; num++) {		//단 2,3,...,9
//			System.out.println("--- "+num +"단 ---");
//			for(int i=1; i<10; i++) {
//				int sum=0;
//				sum = num*i;
////				System.out.println(num + " * " + i +" = "+ sum);
//				System.out.println(num + " * " + i +" = "+ (num*i));
//			}
//		}
		
		// 단의 반복 : 2~9
		for(int a=2; a<=9; a++) {
			System.out.println(a + "단");
			System.out.println("--------");
			for(int b=1; b<=9; b++) {
				System.out.println(a + " X " + b + " = " + (a*b));
			}
			System.out.println("--------");
		}
	}

}
