package ver06;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SmartPhone {

	// 기능 클래스 : 속성을 가지지 않고 메소드들로만 정의된 클래스
	// 여러개의 인스턴스가 생성될 필요 없다. => 싱글톤 패턴
	// 1. private 생성자
	// 2. 클래스 내부에서 인스턴스를 생성 static private
	// 3. 내부에서 생성한 참조값을 반환 해주는 메소드 static public

	// 요구사항
	// 이 클래스는 연락처 정보를 관리하는 클래스입니다.
	// ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
	// => 10개의 정보를 저장할 수 있다. -> 배열 인스턴스를 생성 Contact[]
	// Contact 클래스 기반의 인스턴스를 최대 10개까지 만들어서 배열에 참조값을 저장

	private Contact[] contacts;
	private int numOfContact; // 입력된 정보의 개수, 배열의 index 값으로 사용
	Scanner sc;

	SmartPhone(int size) {
		contacts = new Contact[size];
		numOfContact = 0;
		sc = new Scanner(System.in);
	}

	private static SmartPhone sp = new SmartPhone(10);

	public static SmartPhone getInstance() {

		if (sp == null) {
			sp = new SmartPhone(10);
		}

		return sp;
	}

	// 기능
	// ② 배열에 인스턴스를 저장하고,
	// 수정하고,
	// 삭제,
	// 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.

	// 배열에 인스턴스를 저장
	void insertContact() {
		// 1. 데이터 받고
		// 2. 인스턴스 생성
		// 3. 배열에 인스턴스의 참조값을 저장

		if (numOfContact == contacts.length) {
			System.out.println("최대 저장 개수는 " + contacts + "개 입니다.");
			return;
		}

		// 회사 친구 입력 ?
		// 거래처 정보 입력
		System.out.println("입력하고자 하는 친구 타입을 선택해주세요. ");
		System.out.println("1. 회사 동료 \t 2. 거래처");
		int select = Integer.parseInt(getString());

		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

		System.out.println("입력을 시작 합니다.");
		System.out.print("이름 > ");
		name = getName();

		System.out.print("전화번호 > ");
		phoneNumber = getPhoneNumber();

		System.out.print("이메일 > ");
		email = getString();

		System.out.print("주소 > ");
		address = getString();

		System.out.print("생일 > ");
		birthday = getString();

		System.out.print("그룹 > ");
		group = getString();

		Contact contact = null;
		// 분기 1. 회사 2. 거래처
		if (select == 1) {
			// CompanyContact 인스턴스 생성
			System.out.print("회사 이름 > ");
			String company = getString();
			System.out.print("부서 이름 > ");
			String division = getString();
			System.out.print("직급 > ");
			String manager = getString();
			
			// 인스턴스 생성
			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group, company, division, manager);
			
		} else {
			// CustomerContact 인스턴스 생성
			System.out.print("거래처 이름 > ");
			String cusCompany = getString();
			System.out.print("거래 품목 > ");
			String product = getString();
			System.out.print("담당자 > ");
			String cusManager = getString();
			
			// 인스턴스 생성
			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, cusCompany, product, cusManager);
		}

		// 2. 인스턴스 생성
//		Contact contact = new Contact(name, phoneNumber, email, address, birthday, group);

		// 3. 배열에 저장
		// 처음 입력 : numOfContact => 0
		contacts[numOfContact++] = contact;

	}

	// 이름 검색 후 데이터 수정
	void editContact() {
		// 검색어 받기
		System.out.println("데이터 수정이 진행됩니다.");
		System.out.print("수정하고자 하는 이름을 입력해주세요 >");
		
		int searchIndex = getIndex();

		if (searchIndex < 0) {
			System.out.println("찾으시는 데이터가 존재하지 않습니다.");
			return;
		}

		Contact contact = contacts[searchIndex];

		System.out.println("데이터 수정을 진행 합니다.");

		System.out.print("변경하고자 하는 이름을 입력해 주세요. (현재 값 : " + contact.getName() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
		String newName = sc.nextLine();
		if (newName != null && newName.trim().length() > 0) {
			contact.setName(newName);
		}

		System.out.print("변경하고자 하는 전화번호를 입력해 주세요. (현재 값 : " + contact.getPhoneNumber() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
		String newPhoneNumber = sc.nextLine();
		if (newPhoneNumber != null && newPhoneNumber.trim().length() > 0) {
			contact.setPhoneNumber(newPhoneNumber);
		}

		System.out.print("변경하고자 하는 이메일을 입력해 주세요. (현재 값 : " + contact.getEmail() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
		String newEmail = sc.nextLine();
		if (newEmail != null && newEmail.trim().length() > 0) {
			contact.setEmail(newEmail);
		}

		System.out.print("변경하고자 하는 주소를 입력해 주세요. (현재 값 : " + contact.getAddress() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
		String newAddress = sc.nextLine();
		if (newAddress != null && newAddress.trim().length() > 0) {
			contact.setAddress(newAddress);
		}

		System.out.print("변경하고자 하는 생일을 입력해 주세요. (현재 값 : " + contact.getBirthday() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
		String newBirthday = sc.nextLine();
		if (newBirthday != null && newBirthday.trim().length() > 0) {
			contact.setBirthday(newBirthday);
		}

		System.out.print("변경하고자 하는 그룹을 입력해 주세요. (현재 값 : " + contact.getGroup() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
		String newGroup = sc.nextLine();
		if (newGroup != null && newGroup.trim().length() > 0) {
			contact.setGroup(newGroup);
		}
		
		if(contact instanceof CompanyContact) {
			CompanyContact companyContact = (CompanyContact) contact;
//			companyContact.setCompany(newGroup);
			
			System.out.print("변경하고자 하는 회사이름을 입력해 주세요. (현재 값 : " + companyContact.getCompany() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
			String company = sc.nextLine();
			if (company != null && company.trim().length() > 0) {
				companyContact.setCompany(company);
			}
			
			System.out.print("변경하고자 하는 부서이름을 입력해 주세요. (현재 값 : " + companyContact.getDivision() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
			String division = sc.nextLine();
			if (division != null && division.trim().length() > 0) {
				companyContact.setDivision(division);
			}
			
			System.out.print("변경하고자 하는 직급을 입력해 주세요. (현재 값 : " + companyContact.getManager() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
			String manager = sc.nextLine();
			if (manager != null && manager.trim().length() > 0) {
				companyContact.setManager(manager);
			}
		}
		else if(contact instanceof CustomerContact) {
			CustomerContact cusContact = (CustomerContact) contact;
			
			System.out.print("변경하고자 하는 거래처 이름을 입력해 주세요. (현재 값 : " + cusContact.getCusCompany() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
			String cusCompany = sc.nextLine();
			if (cusCompany != null && cusCompany.trim().length() > 0) {
				cusContact.setCusCompany(cusCompany);
			}
			
			System.out.print("변경하고자 하는 거래 품목을 입력해 주세요. (현재 값 : " + cusContact.getProduct() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
			String product = sc.nextLine();
			if (product != null && product.trim().length() > 0) {
				cusContact.setProduct(product);
			}
			
			System.out.print("변경하고자 하는 담당자를 입력해 주세요. (현재 값 : " + cusContact.getCusManager() + ")\n" + "변경하지 않으려면 엔터를 치세요 >");
			String cusManager = sc.nextLine();
			if (cusManager != null && cusManager.trim().length() > 0) {
				cusContact.setCusManager(cusManager);
			}
			
		}
		else {
			System.out.println("오류");
		}
			

		System.out.println("정보가 수정되었습니다.");
		System.out.println();

	}

	// 삭제 (이름으로 검색)
	void deleteContact() {
		// 검색어 받기
		System.out.println("데이터 삭제가 진행됩니다.");
		System.out.print("삭제하고자 하는 이름을 입력해주세요 >");

		// 삭제하고자 하는 index 찾아야 함 -> 시프트
		int searchIndex = getIndex(); // 현재 검색의 결과는 없다.

		// 검색한 index 값으로 분기 : 시프트를 하거나 검색 결과 이름이 존재하지 않는다.
		if (searchIndex < 0) {
			System.out.println("삭제하고자 하는 이름의 데이터가 존재하지 않습니다.");
		} else {
			for (int i = searchIndex; i < numOfContact; i++) {
				contacts[i] = contacts[i + 1];
			}
			numOfContact--;
			System.out.println("데이터가 삭제 되었습니다.");
		}
	}

	// 검색 후 결과 출력(이름으로 검색)
	void searchInfoPrint() {
		// 1. 사용자에게 검색할 키워드 입력 받는다.
		// 2. 배열에서 이름 검색
		// 3. 결과 출력 : "검색한 이름의 정보가 없습니다." || 정보 출력

		System.out.println("검색을 시작합니다.");
		System.out.print("검색할 이름을 입력하세요. > ");
		
		int searchIndex = getIndex();

		Contact	contact = contacts[searchIndex];

		// 3. 결과 출력 : "검색한 이름의 정보가 없습니다." || 정보 출력
		System.out.println("검색의 결과 ===============");
		if (contact == null) {
			System.out.println("검색한 이름의 정보가 없습니다.");
		} else {
			contact.printInfo();
		}

	}

	// 전체 입력 데이터의 출력
	void printAllData() {
		System.out.println("전체 데이터를 출력합니다. ==============");
		if (numOfContact == 0) {
			System.out.println("입력된 정보가 없습니다.");
			return;
		}

		// 배열에 저장된 데이터를 모두 출력
		for (int i = 0; i < numOfContact; i++) {
			contacts[i].printInfo();
		}
	}
	
	private String getString() {
		String str = null;
		
		while(true) {
			str = sc.nextLine();
			if(str != null && str.trim().length()!=0) {
				break;
			}
			else {
				System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요.");
			}
		}
		return str;
	}
	
	// 이름을 입력받고 배열에 해당 이름의 Contact 객체가 있는 index 반환
	private int getIndex() {
		String name = getString();

		// 이름 검색하는 index 찾기
		int searchIndex = -1; // 현재 검색의 결과는 없다.

		// 데이터 찾기
		for (int i = 0; i < numOfContact; i++) {
			if (contacts[i].getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}
	
	// 이름 정보를 받아서 중복 여부 체크
	private String getName() {
		String name = null;
		
		while(true) {
			name = sc.nextLine();
			if(name != null && name.trim().length()!=0) {
				// 배열 요소에 같은 이름의 요소가 있는 지 체크
				boolean check = false;
				
				if(!Pattern.matches("^[ㄱ-ㅎ가-힣|a-zA-Z]*$", name)){
					System.out.println("한글과 영문자만 입력 가능 합니다. 다시 입력해주세요.");
					continue;
				}
				// 이름 검색
				for(int i=0; i<numOfContact; i++) {
					if(name.equals(contacts[i].getName())) {
						check = true;
						break;
					}
				}
				if(check) {
					System.out.println("같은 이름의 데이터가 존재 합니다.\n 다시 입력하세요.");
					continue;
				}
				else {
					break;
				}
			}
			else {
				System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요.");
			}
		}
		
		return name;
	}
	
	// 전화번호를 받아서 중복 여부 체크
	private String getPhoneNumber() {
		String phoneNumber = null;
		while(true) {
			phoneNumber = sc.nextLine();
			if(phoneNumber != null && phoneNumber.trim().length()>0) {
				// 배열 요소에 같은 전화번호의 요소가 있는 지 체크
				boolean check = false;
				
				if(!Pattern.matches("\\d{3}-\\d{4}-\\d{4}", phoneNumber)){
					System.out.println("010-1234-5678 형식의 숫자만 입력이 가능 합니다. 다시 입력해주세요.");
					continue;
				}
				
				// 전화번호로 검색
				for(int i=0; i<numOfContact; i++) {
					if(phoneNumber.equals(contacts[i].getPhoneNumber())) {
						check = true;
						break;
					}
				}
				if(check) {
					System.out.println("같은 전화번호의 데이터가 존재 합니다.\n 다시 입력하세요.");
					continue;
				}
				else {
					break;
				}
			}
			else {
				System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요.");
			}
		}
		return phoneNumber;
	}
	
	public int getMenuNum() {
		String menuNum = null;
		
		try {
		menuNum = sc.nextLine();
		}
		catch(Exception e) {
			System.out.println("입력이 올바르지 않습니다. 다시 입력해주세요.");
		}
		if(menuNum != null && menuNum.trim().length() != 0) {
			if(Pattern.matches("^[1-6]{1}$", menuNum)) {
				return Integer.parseInt(menuNum);
			}
			else {
				System.out.println("1 - 6까지 숫자만 입력 가능합니다.");
			}
		}
		else {
			System.out.println("입력이 올바르지 않습니다. 다시 입력해주세요.");
		}
		return 0;
	}
}
