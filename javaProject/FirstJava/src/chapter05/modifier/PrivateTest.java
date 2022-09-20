package chapter05.modifier;

public class PrivateTest {

	String name;
	int age;
	
	public PrivateTest() {
		this.name = "전현석";
		this.age = 99;
	}

	public void showInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
	}
}
