package ver01;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {

		Contact con = new Contact();

		while (true) {

			Scanner sc = new Scanner(System.in);
			System.out.print("이름을 입력해 주세요 >> ");
			con.setName(sc.nextLine());

			System.out.print("전화번호를 입력해 주세요 >> ");
			con.setPhoneNum(sc.nextLine());

			System.out.print("이메일을 입력해 주세요 >> ");
			con.setEmail(sc.nextLine());

			System.out.print("주소를 입력해 주세요 >> ");
			con.setAddress(sc.nextLine());

			System.out.print("생일을 입력해 주세요 >> ");
			con.setBirthday(sc.nextLine());

			System.out.print("그룹을 입력해 주세요 >> ");
			con.setGroup(sc.nextLine());

			// 저장할 데이터를 콘솔에서 사용자의 입력 값으로 인스턴스를 생성, 연락처 데이터를 저장하는 인스턴스를 생성
			con = new Contact(con.getName(), con.getPhoneNum(), con.getEmail(), con.getAddress(), con.getBirthday(), con.getGroup());

			System.out.println("연락처 정보 ------------print");
			System.out.println("이름 : " + con.getName());
			System.out.println("전화번호 : " + con.getPhoneNum());
			System.out.println("E-mail : " + con.getEmail());
			System.out.println("주소 : " + con.getAddress());
			System.out.println("생일 : " + con.getBirthday());
			System.out.println("그룹 : " + con.getGroup());
			
			System.out.println();
			
			// 생성된 인스턴스의 정보 출력 메소드를 호출
			con.showContactInfo();

			System.out.print("계속 진행 1, 종료 0 입력해주세요 >>>");
			if (Integer.parseInt(sc.nextLine()) == 0) {
				sc.close();
				break;
			}

		}

		// 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정합니다.
		con.setName("가나다");
		con.setPhoneNum("010-9999-8888");

		con.showContactInfo();

	}

}
