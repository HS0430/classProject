package chapter06;

public class ArrayTest5 {

	public static void main(String[] args) {
		
		int[] numbers = {2, 4, 8, 16, 32};
		
		for(int num : numbers) {
//			System.out.print(num + "\t");
		}
		
		int[][] scores = {
				{100, 90, 60},
				{40, 100, 90}
		};
		
		for(int[] temp : scores) {
			for(int num : temp) {
				System.out.print(num + "\t");
			}
			System.out.println();
		}
		
	}
}
