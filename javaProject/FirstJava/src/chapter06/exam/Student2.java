package chapter06.exam;

public class Student2 {
	
//	학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다
	private String name;
	private int korScore;
	private int engScore;
	private int matScore;

	
	public Student2(String name, int korScore, int engScore, int matScore) {
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.matScore = matScore;
	}
	
	public void printData() {
		System.out.print(this.name + "\t" + this.korScore + "\t" + this.engScore + "\t" + this.matScore + "\t" + sum() + "\t" + avg() +"\n");
	}

//	변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
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
	
	public int sum() {
		int result = 0;
		result = korScore + engScore + matScore;
		return result;
	}
	
	public float avg() {
		return sum()/3;
	}
}
