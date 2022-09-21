package chapter06.exam;

import java.util.Scanner;

public class StudentMain2 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Student2[] st = new Student2[3];
		
		for(int i=0; i<st.length; i++) {
			int kor = 0;
			int eng = 0;
			int mat = 0;
			
			System.out.printf("--------------------학생%d--------------------\n", i+1);
			System.out.print("국어 점수를 입력하세요. >>");
			kor = Integer.parseInt(in.nextLine());
			
			System.out.print("영어 점수를 입력하세요. >>");
			eng = Integer.parseInt(in.nextLine());
			
			System.out.print("수학 점수를 입력하세요. >>");
			mat = Integer.parseInt(in.nextLine());
			
			st[i] = new Student2("학생" + (i+1), kor, eng, mat);
		}
		
		int korTotalScore = 0;
		int engTotalScore = 0;
		int matTotalScore = 0;
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균" );
		System.out.println("-------------------------------------------");
		for(Student2 student : st) {
			student.printData();
			korTotalScore += student.getKorScore();
			engTotalScore += student.getEngScore();
			matTotalScore += student.getMatScore();
		}
		
		System.out.println("--------------------------------------------");
		System.out.println("과목총점\t" + korTotalScore + "\t" + engTotalScore +"\t"+ matTotalScore);
		System.out.printf("과목평균\t%.1f\t%.1f\t%.1f", (float)korTotalScore/st.length, (float)engTotalScore/st.length, (float)matTotalScore/st.length);
//		System.out.println("과목평균\t" + (float)korTotalScore/st.length + "\t" + (float)engTotalScore/st.length +"\t"+ (float)matTotalScore/st.length);
		
	}
	
}
