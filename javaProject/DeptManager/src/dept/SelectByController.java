package dept;

import java.util.List;

import dept.domain.Dept;
import dept.service.SelectByService;
import dept.service.SelectService;

public class SelectByController {
	
	SelectByService service = new SelectByService();
		
	public void process() {
		
		// 사용자의 요청을 처리할 서비스로 처리 요청
		// 부서 전체 리스트를 출력
		// List<Dept>
		
		System.out.println("검색 부서 번호 >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		Dept dept = service.selectByDeptno(deptno);
		
		System.out.println("검색 결과");
		if(dept != null) {
			
				System.out.println(dept);
			}
		else {
			System.out.println("검색한 부서의 정보가 없습니다.");
		}
		
	}

}
