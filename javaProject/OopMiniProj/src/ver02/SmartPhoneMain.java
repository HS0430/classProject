package ver02;

public class SmartPhoneMain {
	
	public static void main(String[] args) {
		
		SmartPhone sp = SmartPhone.getInstance();
		
		while(true) {

			printMenu();
			String selectNum = sp.sc.nextLine().trim();
			
			if(selectNum.equals("1"))
				sp.insertContact();
			else if(selectNum.equals("2"))
				sp.searchContact();
			else if(selectNum.equals("3")) 
				sp.updateContact();
			else if(selectNum.equals("4")) 
				sp.deleteContact();
			else if(selectNum.equals("5")) 
				sp.listContact();
			else if(selectNum.equals("6")) {
				System.out.println("----- 프로그램을 종료합니다 ------");
				break;
			}
			else {
				System.out.println("----- 잘못 입력 하셨습니다 ------");
			}
		}
		
	}
	
	static void printMenu() {

		System.out.println("----------------------------");
		System.out.println("--------- 전화번호부 ----------");
		System.out.println("1. 연락처 저장");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체 출력");
		System.out.println("6. 프로그램 종료");
		System.out.println("----------------------------");
		System.out.print("원하시는 메뉴 번호를 입력해주세요. >>> ");
		
	}

}
