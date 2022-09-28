package chapter08.exam;

// 2. Calulator 인터페이스를 상속하는 인스턴스를 생성할 수 있는 클래스를 정의해봅시다. 
public class CalculatorImpl implements Calculator{

	@Override
	public long add(long n1, long n2) {
		return n1 + n2;
	}

	@Override
	public long substract(long n1, long n2) {
		return n1 - n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		return n1 * n2;
	}

	@Override
	public double divide(double n1, double n2) {
		return n1 / n2;
	}
	
}
