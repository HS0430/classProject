package chapter05.overload;

public class SmartPhoneMain {
		
	public static void main(String[] args) {

		// SmartPhone 인스턴스 생성
		SmartPhone sp1 = new SmartPhone("RED", 4.7f, "SAMSUNG", 5);
		
		sp1.showInfo();
		
		SmartPhone sp2 = new SmartPhone("GOLD", 5f, "APPLE", 10);
		
		sp2.showInfo();
		
		SmartPhone sp3 = new SmartPhone();
		
		// SmartPhone sp3
		// new SmartPhone
		// SmartPhone()
		
		SmartPhone sp4 = new SmartPhone("APPLE", 5.0f);
		sp4.showInfo();
		
		SmartPhone sp5 = new SmartPhone("SAMSUNG");
		sp5.showInfo();
	}

}
