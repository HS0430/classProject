package chapter04;

public class SwitchCaseTest3 {

	public static void main(String[] args) {

			String grade = "admin";
			//	admin	/	manager	/	member	/	anyone
			//	쓰기	/	읽기	/	회원승인	/	지표보기
			
			if(grade.equals("admin")) {	// equals는 문자열 비교 grade의 문자열과 "admin"일 비교 
				System.out.println("지표보기 기능 가능");
				System.out.println("회원승인 기능 가능");
				System.out.println("쓰기 기능 가능");
				System.out.println("읽기 기능 가능");
			}
			
			else if(grade.equals("manager")) {	// 예) !grade.equals("manager") << grade의 문자열이 manager가 아닐 경우 이런 처리 방식도 존재함 
				System.out.println("회원승인 기능 가능");
				System.out.println("쓰기 기능 가능");
				System.out.println("읽기 기능 가능");
			}
			
			else if(grade.equals("member")) {
				System.out.println("쓰기 기능 가능");
				System.out.println("읽기 기능 가능");
			}
			
			else {
				System.out.println("읽기 기능 가능");
			}
			
			switch(grade) {	//break가 없으면 해당되는 case아래 조건도 수행하는 원리를 이용하여 권한 설정
			case "admin":	//admin의 경우 모든 권한
				System.out.println("지표보기 기능 가능");
			case "manager":	//admin의 권한을 뺀 모든 권한
				System.out.println("회원승인 기능 가능");
			case "member": //admin, manager의 권한을 뺀 모든 권한
				System.out.println("쓰기 기능 가능");
			default:	//위 3가지 권한을 뺀 나머지 권한
				System.out.println("읽기 기능 가능");
			}
	}

}
