package chapter04;

public class WhileLoop2 {

	public static void main(String[] args) {
		
		int cnt = 0;
		
		while(true) {
			//무한 반복을 이용해서 5번 출력
			System.out.println("JAVA");
		
			if(++cnt > 4) {	// 4보다 작으면 break지만 while문은 무한루프이므로 실제 5번(0,1,2,3,4) 프린트되고 종료됨
				break;
			}
		}
		
		// 짝수이면서  : num%2 == 0
		// 7의 배수인 수 : num%7 == 0
		
		int num = 1;
		
		while(true) {
			
			if(num%2==0 && num%7==0) {	//num을 2로 나눈 나머지 0인, 짝수 이면서 num을 7로 나눈 나머지가 0인 7의 배수 
										//> 2가지 조건에 해당되는 수 중 0에 가장 가까운 수  
				System.out.println("짝수 이면서 7의 배수인 0과 가장 가까운 수 : " + num);
				break;
			}
			else {
				num++;
			}
			
		}
	}

}
