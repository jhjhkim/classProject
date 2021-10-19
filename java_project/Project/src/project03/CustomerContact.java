package project03;

// ② CustomerContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
//	- 거래처회사이름, 거래품목, 직급 변수 추가
//	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
public class CustomerContact extends Contact {

	private String customerName;	// 거래처 이름
	private String item;			// 거래품목
	private String rank;			// 직급
	
	public CustomerContact() {
		super();
		this.customerName = "";
		this.item = "";
		this.rank = "";
	}
	
	public CustomerContact(String name, String phoneNumber, String eMail, String address, String birthday, String group,
						String customerName, String item, String rank) {
		super(name, phoneNumber, eMail, address, birthday, group);
		this.customerName = customerName;
		this.item = item;
		this.rank = rank;
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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("거래처: " + this.customerName);
		System.out.println("품목: " + this.item);
		System.out.println("직급: " + this.rank);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.print("[" + this.customerName + "] ");
		super.showBasicInfo();
	}
	
}
