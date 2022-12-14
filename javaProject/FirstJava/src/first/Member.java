package first;

import java.util.*;

public class Member {
	public static void main(String[] args) {
//		// class 파일의 실행 포인트
//		printMyName("전현석");
//		printMyName("전현석");
		
		 /*
		 * ① String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다. 
		 * ② int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다. 
		 * ③ double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다. 
		 * ④ boolean 타입의 JAVA책의 보유여부를 저장할 수 있는 변수 hasBook를 정의해봅시다. 
		 * ⑤ 이름과 나이, 키, 책의 보유 여부를 출력해봅시다.
		 */

		Scanner in = new Scanner(System.in);
		
		String name = null;
		int age = 0;
		String nickName = null;
		double height = 0.0;
		boolean hasBook = false;
		
		System.out.print("이름을 입력해 주세요. >>> ");
		name = in.nextLine();
		
		System.out.print("나이를 입력해 주세요. >>> ");
//		age = Integer.parseInt(in.nextLine());
		age = in.nextInt();
		
		in.nextLine();
		
		System.out.print("별명을 입력해 주세요. >>> ");
		nickName = in.next();
		
		System.out.print("키를 입력해 주세요. >>> ");
		height = in.nextDouble();
		
		System.out.print("책 보유 여부를 입력해 주세요. >>> ");
		hasBook = in.nextBoolean();
		
//		name = "전현석";
//		age = 33;
//		height = 175.4;
//		hasBook = true;
		
		System.out.println("이름은 "+name+" 입니다.");
		System.out.println("나이는 "+age+"세 입니다.");
		System.out.println("닉네임은 "+nickName+" 입니다.");
		System.out.println("키는 "+height+"cm 입니다.");
		System.out.println("자바 책의 보유 여부 : "+hasBook);
		
		in.close();
	}

	// 자기 자신의 이름을 출력하는 메소드
	// 반환타입 : 없다 => void 
	// 매개변수 : 없다
	// 처리내용 : 자신의 이름을 출력
	
	public static void printMyName(String name) {

		System.out.println("안녕하세요! " + name + " 입니다. 반갑습니다.");
		// 반환이 있다 => return 사용해서 데이터 반환
	}
}
