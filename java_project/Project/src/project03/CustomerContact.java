package project03;

public class CustomerContact extends Contact {

	private String customerName;	// 거래처 이름
	private String item;		// 거래품목
	private String rank;		// 직급
	
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
	
	public void showInfo() {
		super.showInfo();
		System.out.println("거래처: " + this.customerName);
		System.out.println("품목: " + this.item);
		System.out.println("직급: " + this.rank);
	}
	
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("거래처: " + this.customerName);
	}
	
}
