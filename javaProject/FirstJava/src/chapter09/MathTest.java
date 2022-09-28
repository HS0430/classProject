package chapter09;

public class MathTest {

	public static void main(String[] args) {
	
		// PI
		System.out.println(Math.PI);
		
		// 난수 생성
		System.out.println(Math.random());
		// 1 ~ 45
		int num = (int)(Math.random()*45)+1;		// *45 = 0 ~ 44 > +1 = 1 ~ 45
		System.out.println(num);
		System.out.println((int)(Math.random()*45)+1);
		
		// 절사
		System.out.println(Math.floor(3.6002));		// double이라 3.0
		
		// 반올림
		System.out.println(Math.round(3.4002));
		
		System.out.println(Math.max(10, 20));
		System.out.println(Math.min(10, 20));
		
	}
	
}
