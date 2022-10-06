package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {
	
	public static void main(String[] args) {
	
		// 파일 읽기 : InputStream -> FileInputStream
		FileInputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream("C:\\test\\testfile2.txt");
			
			while(true) {
				int data = inputStream.read();
				
				if(data == -1) {
					System.out.println();
					System.out.println("읽기 완료");
					break;
				}
				
				System.out.print((char)data);
			}
			System.out.println("데이터 읽기 성공");
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
