package chapter05.exam;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {

		/*
		 * ① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소 
		 * ② 위에서 정의한 정보를 출력하는 메소드 정의 
		 * ③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의 
		 * ④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
		 */
		
		infoWrite();
		
//		Member mem = new Member("전현석", "010", "컴퓨터", 4, "firstmind");
//		mem.showMemberInfo();
//		
//		Member mem2 = new Member("전현석", "010", "컴퓨터", 4, "firstmind", "1125", "서울시");
//		mem2.showMemberInfo();
	}

	public static void infoWrite() {
		
		Member mem = new Member();
				
		while(true) {
			Scanner in = new Scanner(System.in);
			
			System.out.print("이름을 입력해주세요 >> ");
//			String name = in.nextLine();
			mem.setName(in.nextLine());
			
			System.out.print("전화번호를 입력해주세요 (숫자만) >> ");
//			String phoneNum = in.nextLine();
			mem.setPhoneNum(in.nextLine());
			
			System.out.print("전공을 입력해주세요 >> ");
//			String major = in.nextLine();
			mem.setMajor(in.nextLine());
			
			System.out.print("학년을 입력해주세요 >> ");
//			int grade = Integer.parseInt(in.nextLine());
			mem.setGrade(Integer.parseInt(in.nextLine()));
			
			System.out.print("e-mail을 입력해주세요 >> ");
//			String eMail = in.nextLine();
			mem.seteMail(in.nextLine());
			
			System.out.print("생일을 입력해주세요 (숫자만) >> ");
//			String birth = in.nextLine();
			mem.setBirth(in.nextLine());
			
			System.out.print("주소를 입력해주세요 >> ");
//			String address = in.nextLine();
			mem.setAddress(in.nextLine());

			if((mem.getBirth().equals("") || mem.getBirth() == null) && (mem.getAddress().equals("") || mem.getBirth() == null)) {
//				mem = new Member(name, phoneNum, major, grade, eMail);
				mem = new Member(mem.getName(), mem.getPhoneNum(), mem.getMajor(), mem.getGrade(), mem.geteMail());
			}
			else {
//				mem = new Member(name, phoneNum, major, grade, eMail, birth, address);
				mem = new Member(mem.getName(), mem.getPhoneNum(), mem.getMajor(), mem.getGrade(), mem.geteMail(), mem.getBirth(), mem.getAddress());
			}
			
			mem.showMemberInfo();
			
			System.out.print("계속 하시려면 1, 종료하시려면 0 입력 >>>");
			if(in.nextInt() == 0) {
				break;
			}
			
			
		}
		
	}
}
