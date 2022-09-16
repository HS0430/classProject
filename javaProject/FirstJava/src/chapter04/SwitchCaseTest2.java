package chapter04;

public class SwitchCaseTest2 {

	public static void main(String[] args) {

		//90점 이상 : A	90~100	=> score / 10 = 9, 10
		//80점 이상 : B	80~89	=> score / 10 = 8
		//70점 이상 : C	70~79	=> score / 10 = 7
		//70점 미만 : F	  ~69
		
		int score = 80;
		
		// key : int 가능한 숫자, String
		// key : byte, short, int, char
		switch(score / 10) {	// score를 10으로 나누어 소수점 자리를 떼고 판단함
//		case 10:
//			System.out.println("A");
//			break;
		case 10: // score/10의 값이 10과 9가 같은 grade에 해당하여 case10과 9가 같은 처리
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default : // 위 모든 케이스들에 해당 하지 않은 경우 if문의 else와 비슷
			System.out.println("F");
			break;
		}
	}

}
