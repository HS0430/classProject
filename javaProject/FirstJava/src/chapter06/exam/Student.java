package chapter06.exam;

public class Student {
	
	// 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다
	private String name;
	private int korScore;
	private int engScore;
	private int matScore;

	public Student() {
	}

	public Student(String name, int korScore, int engScore, int matScore) {
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.matScore = matScore;
	}

	// 변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMatScore() {
		return matScore;
	}

	public void setMatScore(int matScore) {
		this.matScore = matScore;
	}

	
	//총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
	// 총점을 구해서 반환하는 메소드
	public int sum() {
		int result = 0;
		
		result = korScore + engScore + matScore;
		
		return result;
	}
	
	// 평균값을 구해서 반환하는 메소드
	public float avg() {
		
		return sum()/3f;
	}
	
	// 행 단위로 출력
	public void printData() {
		
		System.out.print(this.name + "\t" + this.korScore + "\t" + this.engScore + "\t" + this.matScore + "\t" + sum() + "\t" + avg() + "\n");
		
	}
	
//	public static void main(String[] args) {
//		
//		Student s = new Student("학생1", 100, 91, 80);
//		
//		s.printData();
////		System.out.println("합 : "+ s.sum());
////		System.out.println("평균 : " + s.avg());
//		
//	}
}
