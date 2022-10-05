package ver07;

// Contact 클래스의 용도 ? => 데이터 저장
// 인스턴스 생성 -> 변수의 메모리 생성 -> 데이터 저장
abstract class Contact implements ShowData{
	
//	전화번호부
//
//	클래스 3개
//	1. 정보를 저장하는 용도 클래스 : 인스터스 마다 각각 다른 속성을 가진다.
//	2. 기능을 처리하는 클래스 : 기능만 정의 -> 하나의 인스턴스만 생성 사용
//	3. 프로그램을 정의하는 클래스 : 

	/*
	 * 저장 정보 > 이름  전화번호  이메일  주소  생일  그룹
	 */

	// 변수들은 직접 참조를 막아 캡슐화 처리를 하도록 해봅시다.

	private String name; 			// 이름
	private String phoneNumber; 	// 전화번호
	private String email; 			// E-Mail
	private String address; 		// 주소
	private String birthday; 		// 생일
	private String group; 			// 그룹
	
	public Contact() {
	}
	
	// 인스턴스 생성과 함께 데이터를 초기화 할 수 있도록 생성자를 정의해봅시다
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	/*
	 * 기능  위 데이터를 출력하 는 기능
	 */
	public void printInfo(){
		
		System.out.println("연락처 정보 ============");
		System.out.println("이름 : " + this.name);
		System.out.println("전화번호 : " + this.phoneNumber);
		System.out.println("E-Mail : " + this.email);
		System.out.println("주소 : " + this.address);
		System.out.println("생일 : " + this.birthday);
		System.out.println("그룹 : " + this.group);
		
	}

	@Override
	public String toString() {
		return "Contact2 [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}

	// 변수의 직접 참조는 안되지만 변수의 값을 얻을 수 있는 메소드(getter)와
	// 변수에 값을 저장할 수 있는 메소드(setter)를 정의합니다
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public static void main(String[] args) {
//		Contact contact = new Contact();
	}

}
