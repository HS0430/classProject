package chapter03;

public class AssignmentOperator {

		public static void main(String[] args) {
			
			int num = 10;
			
			num += 5;	// num = num + 5; => num = 10 + 5 => 15
			System.out.println("num : " + num);
			
			num -= 3;	// num = num - 3; => num = 15 - 3 => 12
			System.out.println("num : " + num);
			
			num *= 3;	// num = num * 3; => num = 12 * 3 => 36
			System.out.println("num : " + num);
			
			num /= 6;	// num = num / 6; => num = 36 / 6 => 6
			System.out.println("num : " + num);
			
			num %= 4;	// num = num % 4; => num = 6 % 4 => 2
			System.out.println("num : " + num);
			
			String str = "안녕하세요.";
			str += " 저는 전현석 입니다.";	// "안녕하세요." + " 저는 전현석 입니다."
			str += " 축구선수 입니다.";
			
			System.out.println(str);
					
		}
}
