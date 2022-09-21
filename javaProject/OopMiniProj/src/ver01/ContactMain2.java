package ver01;

import java.util.Scanner;

public class ContactMain2 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		// Contact 인스턴스 생성 : 생성자를 이용한 데이터 초기화
		Contact2 c1 = new Contact2("전현석", "010-1234-5678", "abcdefg@gmail.com", "서울시 강동구", "2022-09-11", "기타");
		
		// 변수 값을 반환하는 각각의 메소드를 호출해서 각 데이터를 출력문으로 출력합니다
//		System.out.println("이름 : " + c1.getName());
//		System.out.println("전화번호 : " + c1.getPhoneNumber());
//		System.out.println("E-Mail : " + c1.getEmail());
//		System.out.println("주소 : " + c1.getAddress());
//		System.out.println("생일 : " + c1.getBirthday());
//		System.out.println("그룹 : " + c1.getGroup());
		
		System.out.println();
		
		// 생성된 인스턴스의 정보 출력 메소드를 호출합니다.
//		c1.printInfo();
		
		// 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정합니다.
		c1.setName("박지성");
		c1.setPhoneNumber("010-8888-9999");
//		c1.setEmail(null);
//		c1.setAddress(null);
//		c1.setBirthday(null);
//		c1.setGroup(null);
		System.out.println();
		
//		c1.printInfo();
		
		/////////////////////////////////////
		while(true) {
		
			System.out.println("1. 입력시작 | 0. 종료");
			String select = in.nextLine();
			if(select.equals("0")) {
				System.out.println("포로그램을 종료 합니다.");
				in.close();
				break;
			}
			else if(!select.equals("1")) {
				System.out.println("올바른 요청이 아닙니다.");
				continue;
			}
			
			System.out.println("데이터 입력을 시작합니다.");
			
			System.out.print("이름 >>> ");
			String name = in.nextLine();
			
			System.out.print("전화번호 >>> ");
			String phoneNumber = in.nextLine();
			
			System.out.print("이메일 >>> ");
			String email = in.nextLine();
			
			System.out.print("주소 >>> ");
			String address = in.nextLine();
			
			System.out.print("생일 >>> ");
			String birthday = in.nextLine();
			
			System.out.print("그룹 >>> ");
			String group = in.nextLine();
			
			Contact2 c = new Contact2(name, phoneNumber, email, address, birthday, group);
			
			c.printInfo();
		}
	}

}
