package project08;

// ② CustomerContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
//	- 거래처회사이름, 거래품목, 직급 변수 추가
//	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
public class CustomerContact extends Contact {

	private String customerName;	// 거래처 이름
	private String item;			// 거래품목
	private String job;			// 직급
	
	public CustomerContact() {
		super();
		this.customerName = "";
		this.item = "";
		this.job = "";
	}
	
	public CustomerContact(String name, String phoneNumber, String eMail, String address, String birthday, String group,
						String customerName, String item, String job) {
		super(name, phoneNumber, eMail, address, birthday, group);
		this.customerName = customerName;
		this.item = item;
		this.job = job;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("거래처: " + customerName);
		System.out.println("품목: " + item);
		System.out.println("직급: " + job);
	}
	
	@Override
	public void showBasicData() {
		System.out.println("[" + customerName + "] " + getName());
	}
	
}
