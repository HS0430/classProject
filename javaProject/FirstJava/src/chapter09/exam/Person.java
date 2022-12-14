package chapter09.exam;

public class Person {
	String name;
	String personNumber;

	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person) {
			Person p = (Person) obj;
			if (this.personNumber.equals(p.personNumber)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		1. 위 Person 클래스의 equals() 메소드를 오버라이딩해서 주민등록번호가 같으면 인스턴스로 판별하는 프로그램을 만들어봅시다. 

		Person p1 = new Person("일이삼", "911234-1234567");
		Person p2 = new Person("이삼사", "901234-1234567");
		Person p3 = new Person("삼사오", "901234-1234567");

		System.out.println("Person1의 이름 : " + p1.name + " 번호 : " + p1.personNumber);
		System.out.println("Person2의 이름 : " + p2.name + " 번호 : " + p2.personNumber);
		System.out.println("Person3의 이름 : " + p3.name + " 번호 : " + p3.personNumber);
		System.out.println("Person1 equals Person2 >> " + p1.equals(p2)); // false
		System.out.println("Person1 equals Person3 >> " + p1.equals(p3)); // true

	}
}
