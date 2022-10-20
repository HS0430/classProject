package dept.controller;

import dept.Main;
import dept.domain.Dept;
import dept.service.InsertService;

public class InsertController implements Controller{

	InsertService service = new InsertService();
	
	public void process() {
		
		System.out.println("부서 정보 입력을 시작합니다.");
		System.out.print("부서 번호 >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		System.out.print("부서 이름 >> ");
		String dname = Main.sc.nextLine();
		
		System.out.print("부서 위치 >> ");
		String loc = Main.sc.nextLine();
		
		int result = service.insert(new Dept(deptno, dname, loc));
		
		if(result > 0) {
			System.out.println("입력되었습니다.");
		}else {
			System.out.println("입력 실패");
		}
		
		
	}
}
