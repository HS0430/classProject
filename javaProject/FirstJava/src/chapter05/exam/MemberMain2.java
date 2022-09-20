package chapter05.exam;

public class MemberMain2 {

	public static void main(String[] args) {
	
		Member2 m1 = new Member2("Son", "010-1234-5678", "축구", 1, "abc@gmail.com", 20000101, "서울");
		
		m1.showMemberInfo();
		
		Member2 m2 = new Member2("Son", "010-8765-4321", "야구", 4, "cba@gmail.com");
		
		m2.showMemberInfo();
		
	}
	
}
