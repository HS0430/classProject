package ver07_map;

public class SmartPhoneMain {

	public static void main(String[] args) {

		SmartPhone sp = SmartPhone.getInstance();

		while (true) {

			printMenu();
			try {
			int select = sp.getMenuNum();

			switch (select) {
			case 1:
				sp.insertContact();
				break;
			case 2:
				sp.searchInfoPrint();
				break;
			case 3:
				sp.editContact();
				break;
			case 4:
				sp.deleteContact();
				break;
			case 5:
				sp.printAllData();
				break;
			case 6:
				System.out.println("프로그램을 종료 합니다.");
				return;
			}
			}catch(NumberFormatException ne) {
				System.out.println("숫자만 입력 가능 합니다.");
			}catch(Exception e) {
				System.out.println("입력이 정상적이지 않습니다.");
			}
		}
	}

	public static void printMenu() {

		System.out.println("==============================");
		System.out.println("# 전화번호부");
		System.out.println("1. 연락처 저장");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체 출력");
		System.out.println("6. 프로그램 종료");
		System.out.println("==============================");
		System.out.println("원하시는 메뉴 번호를 입력해주세요.");

	}
}
