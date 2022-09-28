package chapter10;

public class ExceptionClassTest {

	public static void main(String[] args) throws ClassNotFoundException {

		try {
			Class cl = Class.forName("Test");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}

		try {
			int num = 10 / 0;
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
		}
		try {
			int[] arr = new int[3];
			arr[3] = 10;
		} catch (ArrayIndexOutOfBoundsException aoe) {
			aoe.printStackTrace();
		}

		try {
			String[] names = new String[-1];
		} catch (NegativeArraySizeException nas) {
			nas.printStackTrace();
		}

		String str = null;
		try {
			System.out.println(str.toString());
		} catch (NullPointerException ne) {
			ne.printStackTrace();
		}
	}
}
