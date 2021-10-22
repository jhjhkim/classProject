package project05.first;

// ① CompanyContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
//	- 회사이름, 부서이름, 직급 변수 추가
//	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
public class CompanyContact extends Contact {

	private String company;	// 회사이름
	private String team;	// 부서이름
	private String rank;	// 직급
	
	public CompanyContact() {
		super();
		this.company = "";
		this.team = "";
		this.rank = "";
	}
	
	public CompanyContact(String name, String phoneNumber, String eMail, String address, String birthday, String group,
						String company, String team, String rank) {
		super(name, phoneNumber, eMail, address, birthday, group);
		this.company = company;
		this.team = team;
		this.rank = rank;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("회사: " + this.company);
		System.out.println("부서: " + this.team);
		System.out.println("직급: " + this.rank);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.print("[" + this.company + "] [" + this.team + "] ");
		System.out.println("이름: " + super.getName());
		System.out.println("전화번호: " + super.getPhoneNumber());
	}
	
}
