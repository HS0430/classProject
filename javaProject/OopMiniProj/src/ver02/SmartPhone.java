package ver02;

import java.util.Scanner;

public class SmartPhone {

	private Contact[] con;
	Scanner sc;
	private int contactCnt;
	
	SmartPhone(int size){
		con = new Contact[size];
		sc = new Scanner(System.in);
		contactCnt = 0;
	}
	
	private static SmartPhone sp = new SmartPhone(10);
	
	public static SmartPhone getInstance() {
		
		if(sp == null) {
			sp = new SmartPhone(10);
		}
		
		return sp;
	}
		
	
	public void insertContact() {
		
		System.out.println("---------- INSERT ----------");
		if (contactCnt == con.length) {
			System.out.println("최대 저장 개수는 " + con + "개 입니다.");
			return;
		}
		
		System.out.println("입력을 시작 합니다.");
		System.out.print("이름 >");
		String name = sc.nextLine();

		System.out.print("전화번호 >");
		String phoneNumber = sc.nextLine();
		
		System.out.print("이메일 >");
		String email = sc.nextLine();
		
		System.out.print("주소 >");
		String address = sc.nextLine();

		System.out.print("생일 >");
		String birthday = sc.nextLine();
		
		System.out.print("그룹 >");
		String group = sc.nextLine();

		// 2. 인스턴스 생성
		Contact contact = new Contact(name, phoneNumber, email, address, birthday, group);

		// 3. 배열에 저장
		// 처음 입력 : numOfContact => 0
		con[contactCnt++] = contact;
		
		System.out.println("----------------------------");
	}
	
	public void updateContact() {
		
		System.out.println("---------- UPDATE ----------");

		int searchIndex = -1;
		System.out.println("수정을 시작 합니다.");
		System.out.println("수정할 이름을 입력해 주세요.");
		String name = sc.nextLine();
		
		for(int i=0; i<contactCnt; i++) {
			if(con[i].getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}
		
		if(searchIndex < 0 ) {
			System.out.println(name + "에 대한 검색 결과가 없습니다.");
			return;
		}
		
		Contact cont = con[searchIndex];
		System.out.println("데이터 수정을 진행 합니다.");

		System.out.print("변경하고자 하는 이름을 입력해 주세요. 변경하지 않으려면 엔터를 치세요. \n (현재 값 : " + cont.getName() + ")\n");
		String uptName = sc.nextLine();
		if (uptName != null && uptName.trim().length() > 0) {
			cont.setName(uptName);
		}
		
		System.out.print("변경하고자 하는 전화번호를 입력해 주세요. 변경하지 않으려면 엔터를 치세요. \n (현재 값 : " + cont.getPhoneNum() + ")\n");
		String uptPhoneNum = sc.nextLine();
		if (uptPhoneNum != null && uptPhoneNum.trim().length() > 0) {
			cont.setPhoneNum(uptPhoneNum);
		}
		
		System.out.print("변경하고자 하는 이메일를 입력해 주세요. 변경하지 않으려면 엔터를 치세요. \n (현재 값 : " + cont.getEmail() + ")\n");
		String uptEmai = sc.nextLine();
		if (uptEmai != null && uptEmai.trim().length() > 0) {
			cont.setEmail(uptEmai);
		}
		
		System.out.print("변경하고자 하는 주소를 입력해 주세요. 변경하지 않으려면 엔터를 치세요. \n (현재 값 : " + cont.getAddress() + ")\n");
		String uptAddress = sc.nextLine();
		if (uptAddress != null && uptAddress.trim().length() > 0) {
			cont.setAddress(uptAddress);
		}
		
		System.out.print("변경하고자 하는 생일을 입력해 주세요. 변경하지 않으려면 엔터를 치세요. \n (현재 값 : " + cont.getBirthday() + ")\n");
		String uptBirthday = sc.nextLine();
		if (uptBirthday != null && uptBirthday.trim().length() > 0) {
			cont.setBirthday(uptBirthday);
		}
		
		System.out.print("변경하고자 하는 그룹을 입력해 주세요. 변경하지 않으려면 엔터를 치세요. \n (현재 값 : " + cont.getGroup() + ")\n");
		String uptGroup = sc.nextLine();
		if (uptGroup != null && uptGroup.trim().length() > 0) {
			cont.setGroup(uptGroup);
		}
		System.out.println(name + "에 대한 정보가 수정 되었습니다.");
		
		System.out.println("----------------------------");
	}
	
	public void deleteContact() {

		System.out.println("---------- DELETE ----------");
		
		System.out.println("삭제를 시작 합니다.");
		System.out.println("삭제할 이름을 입력해 주세요.");
		String name = sc.nextLine();
		int delIndex = -1;
		for(int i=0; i<contactCnt; i++) {
			if(con[i].getName().equals(name)) {
				delIndex = i;
				break;
			}
		}
		
		if(delIndex < 0 ) {
			System.out.println(name + "에 대한 검색 결과가 없습니다.");
		}
		else {
			for(int i=delIndex; i<contactCnt; i++) {
				con[i] = con[i+1];
		}
			contactCnt--;
			System.out.println(name + "에 대한 정보가 삭제 되었습니다.");
			
		}
		System.out.println("----------------------------");
	}
	
	public void searchContact() {
		System.out.println("---------- SEARCH ----------");
		Contact contact = null;
		
		System.out.println("검색을 시작 합니다.");
		System.out.println("검색할 이름을 입력해 주세요.");
		String name = sc.nextLine();
		
		for(int i=0; i<contactCnt; i++) {
			if(con[i].getName().equals(name)) {
				contact = con[i];
				break;
			}
		}
		
		if(contact == null) {
			System.out.println(name + "에 대한 검색 결과가 없습니다.");
		}
		else {
			contact.showContactInfo();
		}
		
		System.out.println("----------------------------");
	}
	
	public void listContact() {
		System.out.println("----------  LIST  ----------");
		System.out.println("전체 정보를 출력 합니다.");
		
		if(contactCnt == 0) {
			System.out.println("저장된 정보가 없습니다.");
			return;
		}
		else {
			for(int i=0; i<contactCnt; i++) {
				con[i].showContactInfo();
			}
		}
	}
	
}
