package chapter13.exam;

import java.io.File;
import java.util.Scanner;

public class FileCopyExam extends Thread{
//	① 복사할 대상 파일의 경로와 복사해올 위치 경로를 받는 메인 스레드는 멈춤 없이 실행하고 데이터의 복사는 스레드로 처리하는 프로
//	그램을 만들어 봅시다.
//	② 파일이 복사가 완료되면 완료 메시지를 콘솔에 출력합시다.
	
	public static void main(String[] args) {
		FileCopyExam t1 = new FileCopyExam();
		
		t1.start();
	}

	@Override
	public void run() {
		String targetPath = "";
		String targetName = "";
		String copyPath = "";
		String copyName = "";
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("복사할 대상 파일의 경로 입력 : ");
			targetPath = sc.nextLine();
			
			if(targetPath.equals("exit")) {
				sc.close();
				break;
			}
			
			System.out.println("복사할 대상 파일의 이름 입력 : ");
			targetName = sc.nextLine();
			System.out.println("복사 할 경로 입력 : ");
			copyPath = sc.nextLine();
			
			
			FileCopySub t2 = new FileCopySub(targetPath, targetName, copyPath);
			t2.start();
		}
	}
}


class FileCopySub extends Thread {
	
	String targetPath = "";
	String targetName = "";
	String copyPath = "";
			
	
	public FileCopySub(String targetPath, String targetName, String copyPath) {
		super();
		this.targetPath = targetPath;
		this.targetName = targetName;
		this.copyPath = copyPath;
	}

	@Override
	public void run() {
		File f = new File(targetPath);
		File f2 = new File(f, targetName);
		File f3 = new File(copyPath, targetName);
		
		f2.renameTo(f3);
		
		System.out.println(targetPath+targetName + " 경로의 파일을 " + copyPath + "경로로 이동 하였습니다.");
		
	}
	
	
	
}
