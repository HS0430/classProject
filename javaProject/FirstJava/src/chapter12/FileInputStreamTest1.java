package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest1 {
	
	public static void main(String[] args) {
	
		// 파일 읽기 : InputStream -> FileInputStream
		FileInputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream("C:\\test\\testfile1.txt");
			int data = inputStream.read();
			
			System.out.println(data);
			System.out.println((char)data);
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
