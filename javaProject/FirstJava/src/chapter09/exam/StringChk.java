package chapter09.exam;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringChk {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.print("이름을 입력하세요 >> ");
			String name = sc.nextLine();
			if (name != null && !name.isEmpty()) {
				if (chkName(name)) {
					System.out.println("입력된 이름 : " + name);
					sc.close();
					break;
				} else {
					System.out.println("이름에는 한글 또는 영문만 입력 가능합니다.");
					System.out.println("다시 입력해주세요.");
				}
			} else {
				System.out.println("이름이 입력되지 않았습니다.");
				System.out.println("다시 입력해주세요.");
			}
		}
	}

	static boolean chkName(String name) {
		boolean result = Pattern.matches("^[ㄱ-ㅎ가-힣|a-zA-Z]*$", name);
		return result;
	}
}
