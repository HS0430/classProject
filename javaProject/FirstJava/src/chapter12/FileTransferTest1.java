package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTransferTest1 {

	public static void main(String[] args) {

		// 파일 복사
		// 특정 파일의 데이터를 읽어서 다른 위치에 파일에 쓰면 -> 복사

		InputStream in = null; // 원본 파일
		OutputStream out = null; // 복사 파일

		try {
			in = new FileInputStream("c:\\test\\testfile2.txt");
			out = new FileOutputStream("c:\\test\\testfile2Copy.txt");

			while (true) {
				int data = in.read();

				if (data == -1) {
					break;
				}

				out.write(data);		// 새로운 파일에 데이터 쓰기
			}

			System.out.println("복사 완료");
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
