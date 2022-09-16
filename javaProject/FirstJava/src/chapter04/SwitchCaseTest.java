package chapter04;

public class SwitchCaseTest {

	public static void main(String[] args) {
		
		int key = 2;
		
		// switch case : 특정 값 하나를 비교해서 분기하는 조건문
		// key 값과 case 다음에 오는 값을 비교해서 실행
		switch (key) {
		case 1:
			System.out.println("1의 결과 !!!!!");
			//DB
			//변수
			//연산
			//메소드 호출
			//객체 생성
			break;	// 브레이크가 없을 경우 해당 case부터 아래에 존재하는 모든 케이스를 무조건 처리함 (단 break가 있으면 빠져나감)

		case 2:
			System.out.println("2일 때 처리");
			break;
			
		default:	//앞의 정의된 case의 조건에 맞지 않는 나머지
			System.out.println("default의 결과 !!!!!");
			break;
		}
	}

}
