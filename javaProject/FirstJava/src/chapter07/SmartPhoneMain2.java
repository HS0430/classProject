package chapter07;

public class SmartPhoneMain2 {

	public static void main(String[] args) {
		
		AndroidPhone androidPhone = new AndroidPhone("010-9999-5555");
		IPhone iPhone = new IPhone("010-8888-6666");
		GooglePhone googlePhone = new GooglePhone("010-7777-3333");
		
		callByPhone(androidPhone);
		callByPhone(iPhone);
		callByPhone(googlePhone);
		
	}
	
	static void callByPhone(Phone phone) {
		// 메소드의 매개변수
//		Phone phone = androidPhone;
		phone.call();
	}
	
//	// 안드로이드 폰
//	static void callByPhone(AndroidPhone phone)
//	{
//		phone.call();
//	}
//	
//	// 아이폰
//	static void callByPhone(IPhone phone)
//	{
//		phone.call();
//	}
//	
//	static void callByPhone(GooglePhone phone) {
//		phone.call();
//	}
	
}
