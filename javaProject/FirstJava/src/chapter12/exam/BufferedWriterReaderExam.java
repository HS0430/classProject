package chapter12.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BufferedWriterReaderExam {

	public static void main(String[] args) {
		
		File f = null;
		BufferedWriter fin = null;
		BufferedReader fout = null;
		Scanner sc = null;
		String title = null;
		String nowDate = null;
		String contents = null;
		Date date = null;
		SimpleDateFormat sdf = null;
		String fileName = null;
		String readContents = null;
		
//		① File 클래스를 이용해서 저장 폴더 생성
		f = new File("c:\\test\\notepad");
		f.mkdir();
		
//		② 문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
//		③ 파일의 이름은 날짜와 메모의 제목을 이용해서 생성
		
		// 날짜 구하기
		date = new Date();
		sdf = new SimpleDateFormat("yyyyMMdd");
		nowDate = sdf.format(date);
				
		// 제목 입력받기
		sc = new Scanner(System.in);
		System.out.print("제목을 입력해 주세요. >> ");
		title = sc.nextLine();
		System.out.println("내용을 입력해 주세요. >> ");
		contents = sc.nextLine();
		
		fileName = f+"\\"+ nowDate + "_";
//		④ 메모리스트와 파일 읽기 기능을 구현해봅시다
		try {
			fin = new BufferedWriter(new FileWriter(fileName + title +".txt", true));
			fin.write(contents);
			fin.newLine();
			fin.flush();
			
			File[] list = f.listFiles();
			
			System.out.println("저장된 메모 목록 ==========");
			for(int i=0; i<list.length; i++) {
				System.out.println(list[i].getName());
			}
			
			System.out.println("확인하고자 하는 메모 제목을 입력하세요. >>");
			String cTitle = sc.nextLine();
			
			fout = new BufferedReader(new FileReader(fileName+cTitle+".txt"));
			while(true) {
				readContents = fout.readLine();
				
				if(readContents == null) {
					break;
				}
				System.out.println(readContents);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			if(fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
