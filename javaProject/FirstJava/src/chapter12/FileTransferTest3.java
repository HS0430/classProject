package chapter12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTransferTest3 {

	public static void main(String[] args) {

		// 파일 복사
		// 특정 파일의 데이터를 읽어서 다른 위치에 파일에 쓰면 -> 복사

		InputStream in = null; // 원본 파일
		OutputStream out = null; // 복사 파일
		
		// 보조 스트림 (필터 스트림) : 기본 스트림에 보조적인 역할을 하는 스트림
		// 보조 스트림을 이용하기 위해서는 기본 스트림이 먼저 생성되어야 한다.
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		
		try {
//			in = new FileInputStream("c:\\test\\test.zip");
//			bin = new BufferedInputStream(in);
			bin = new BufferedInputStream(new FileInputStream("c:\\test\\test.zip"));
			
//			out = new FileOutputStream("c:\\test\\testCopy2.zip");
//			bout = new BufferedOutputStream(out);
			bout = new BufferedOutputStream(new FileOutputStream("c:\\test\\testCopy2.zip"));

			System.out.println("복사가 시작 되었습니다.");
			while (true) {
				int data = bin.read();
				
				if(data == -1) {
					break;
				}
				
				bout.write(data);
			}

			System.out.println("복사 완료");
//			System.out.println("복사한 파일의 size : " + copyByte);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				// TODO Auto-generated catch block
			}

			if (out != null) {
				try {
					out.close();
					// TODO Auto-generated catch block
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
