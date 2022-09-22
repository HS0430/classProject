package ver02;

import java.util.Scanner;

public class SmartPhone {

	private Contact[] con;
	Scanner sc;
	private int contactCnt;
	
	SmartPhone(int size){	// 생성자 int Size = 10
		con = new Contact[size];	// Contact[size]로 초기화 
		sc = new Scanner(System.in);	// Scanner 초기화
		contactCnt = 0;					// contactCnt = 0으로 초기화
	}
	
	//SmartPhone 인스턴스 생성 매개변수 값 10 _ 외부 참조 못하게 private, 프로그램 실행 시 존재할 수 있께 static
	private static SmartPhone sp = new SmartPhone(10);
	
	public static SmartPhone getInstance() {	// 외부에서 참조할 수 있게함 getInstance
		
		if(sp == null) {	// 위에서 sp가 제대로 생성이 안된 경우
			sp = new SmartPhone(10);	// 여기서 다시 생성
		}
		
		return sp;
	}
		
	// 전화번호부 저장
	public void insertContact() {
		
		System.out.println("---------- INSERT ----------");
		if (contactCnt == con.length) {	//저장 및 삭제 등 Contact 배열의 index contactCnt와 con.length(배열의 크기)가 같은 경우
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
		con[contactCnt++] = contact;	// con[i]배열에 contact 인스턴스 저장
		
		System.out.println("----------------------------");
	}
	
	public void updateContact() {
		
		System.out.println("---------- UPDATE ----------");

		int searchIndex = -1;		// 검색한 index 값을 저장하기 위한 변수 (-1로 초기화 하여 찾지 못한 경우 처리)
		System.out.println("수정을 시작 합니다.");
		System.out.println("수정할 이름을 입력해 주세요.");
		String name = sc.nextLine();
		
		for(int i=0; i<contactCnt; i++) {
			if(con[i].getName().equals(name)) {		//con 배열의 name값과 입력받은 name 비교
				searchIndex = i;
				break;
			}
		}
		
		if(searchIndex < 0 ) {		// -1로 초기화하여 검색하지 못하면 처리
			System.out.println(name + "에 대한 검색 결과가 없습니다.");
			return;
		}
		
		Contact cont = con[searchIndex];
		System.out.println("데이터 수정을 진행 합니다.");

		System.out.print("변경하고자 하는 이름을 입력해 주세요. 변경하지 않으려면 엔터를 치세요. \n (현재 값 : " + cont.getName() + ")\n");
		String uptName = sc.nextLine();
		if (uptName != null && uptName.trim().length() > 0) {		//입력받은 값이 널이 아니거나 length가 0보다 크면 입력받은 값을 set
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
		int delIndex = -1;		// 검색과 같은 로직 (실제 검색 하여 삭제할 대상을 찾아야하므로 동일함)
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
			for(int i=delIndex; i<contactCnt; i++) {	// 해당하는 대상을 찾으면 해당 index 값부터 배열의 마지막 index 처리
				con[i] = con[i+1];						// 5번째 => con[5] = con[6]을 저장 위와 같이 배열 마지막까지 적용 (실제 삭제라기보단 참조주소값을 바꿔버림)
		}
			contactCnt--;		// contactCnt 현재 저장된 index의 값 -1 
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
				contact = con[i];					// contact 객체에 con[i]값을 저장
				break;
			}
		}
		
		if(contact == null) {	// 아무 값도 찾지 못한 경우 contact가 위에 초기화한 값인 null이므로 아래와 같이 처리
			System.out.println(name + "에 대한 검색 결과가 없습니다.");
		}
		else {
			contact.showContactInfo();		// 위에서 저장된 값을 출력 (해당 이름에대한 연락처 정보)
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
				con[i].showContactInfo();	// con[i]배열에 저장된 연락처 정보 출력
			}
		}
	}
	
}
