package chapter06.exam;

public class Student6_1 {

	public static void main(String[] args) {
		
		//국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고, 평균 점수를 출력하는 프로그램을 작성해봅시다
		int score[][] = new int[10][3];
		int korScore = 0;
		int engScore = 0;
		int matScore = 0;
		
		System.out.println("국어\t영어\t수학");
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				score[i][j] = (int)(Math.random()*51)+50;
				System.out.print(score[i][j]+"\t");
				
				if(j==0) {
					korScore += score[i][j];
				}
				if(j==1) {
					engScore += score[i][j];
				}
				if(j==2) {
					matScore += score[i][j];
				}
			}
			System.out.println();
		}
		System.out.println(korScore + "\t" + engScore + "\t" + matScore);
		System.out.println((float)korScore/score.length + "\t" + (float)engScore/score.length + "\t" + (float)matScore/score.length);
		
	}
}
