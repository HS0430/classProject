package chapter06.exam;

public class StudentMain {

	public static void main(String[] args) {

		// Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
		// 학생 10명의 정보를 저장하는 배열
		Student[] students = new Student[10];
		
		// Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		// 점수 초기화
		for(int i=0; i<students.length; i++) {	// students 배열의 크기가 10 (0~9) students < 10
			students[i] = new Student("학생"+(i+1), (int)(Math.random()*51)+50, (int)(Math.random()*51)+50, (int)(Math.random()*51)+50);
			// students[0~9] 총 10개
			// Math.random 0.0 ~ 1 -> *51 -> 0 ~ 50 -> +50 -> 최소 50점부터 100점까지 사이에 랜덤 / 101보다 작은 값 까지, 실제 정수형으로는 100점까지 나옴 
		}
		
		int korTotalScore = 0;
		int engTotalScore = 0;
		int matTotalScore = 0;
		
		System.out.println("성적표");
		System.out.println("-------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		
		// 배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다
		for(Student s : students) {
			s.printData();		// 점수 데이터 출력
			
			//totalScore에 각 과목별 점수를 더함
			korTotalScore += s.getKorScore();
			engTotalScore += s.getEngScore();
			matTotalScore += s.getMatScore();
		}
		
		System.out.println("-------------------------------------------------");
		System.out.printf("과목총점\t%d \t%d \t%d \n", korTotalScore, engTotalScore, matTotalScore);
		// 과목평균 = 과목총점 / 학생 수 => avg = korTotalScore / students.length (float은 소수점 까지 표현하기 위해 사용, .1f 소수점 1자리)
		System.out.printf("과목평균\t%.1f \t%.1f \t%.1f \n", korTotalScore/(float)students.length, engTotalScore/(float)students.length, matTotalScore/(float)students.length);
		System.out.println("-------------------------------------------------");
	}

}
