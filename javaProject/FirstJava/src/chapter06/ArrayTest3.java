package chapter06;

public class ArrayTest3 {

	public static void main(String[] args) {

		// 10명의 국어 점수를 저장하는 배열 선언하고 생성
		int[] korScore = new int[10];

		// 배열 요소의 초기화
		korScore[0] = 90;
		korScore[1] = 81;
		korScore[2] = 72;
		korScore[3] = 63;
		korScore[4] = 54;
		korScore[5] = 65;
		korScore[6] = 76;
		korScore[7] = 87;
		korScore[8] = 98;
		korScore[9] = 99;
		
		sum(korScore);

	}
	
	public static void sum(int arr[]) {
		// arr => korScore의 배열인스턴스 주소
		
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		System.out.println("총점 : " + sum);
		System.out.println("반 평균 : " + (float) sum / arr.length);
		
	}

}
