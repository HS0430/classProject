package dept;

import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Controller controller = new Controller();
		
		while(true) {
			menu();
			System.out.print("메뉴를 입력하세요	>> ");
//			int select = Integer.parseInt(controller.sc.nextLine());
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1:
				new SelectController().process();
//				controller.select();
				break;
			case 2:
				new SelectByController().process();
//				controller.selectByDeptno();
				break;
			case 3:
//				controller.insert();
				break;
			case 4:
//				controller.update();
				break;
			case 5:
//				controller.delete();
				break;
			case 6:
//				controller.exit();
				break;
			
			}
			
		}
	}

	
	public static void menu() {
		System.out.println("---------------- 부서 관리 프로그램 ----------------");
		System.out.println(" 1. 부서 리스트");
		System.out.println(" 2. 부서 검색");
		System.out.println(" 3. 부서 정보 저장");
		System.out.println(" 4. 부서 정보 수정");
		System.out.println(" 5. 부서 정보 삭제");
		System.out.println(" 6. 종료");
		System.out.println("------------------------------------------------");

	}
}
