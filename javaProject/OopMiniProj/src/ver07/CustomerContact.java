package ver07;

public class CustomerContact extends Contact{
//	② CustomerContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
//	- 거래처회사이름, 거래품목, 직급 변수 추가
//	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
	private String cusCompany;
	private String product;
	private String cusManager;
	
	public CustomerContact(String name, String phoneNumber, String email, String address, String birthday, String group,
			String cusCompany, String product, String cusManager) {
		super(name, phoneNumber, email, address, birthday, group);
		this.cusCompany = cusCompany;
		this.product = product;
		this.cusManager = cusManager;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println("거래처 이름 : " + this.cusCompany);
		System.out.println("거래 품목 : " + this.product);
		System.out.println("담당자 : " + this.cusManager);
	}

	public String getCusCompany() {
		return cusCompany;
	}

	public void setCusCompany(String cusCompany) {
		this.cusCompany = cusCompany;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCusManager() {
		return cusManager;
	}

	public void setCusManager(String cusManager) {
		this.cusManager = cusManager;
	}

	@Override
	public void ShowData() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
