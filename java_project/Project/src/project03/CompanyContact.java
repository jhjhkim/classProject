package project03;

public class CompanyContact extends Contact {

	private String companyName;	// 회사이름
	private String team;		// 부서이름
	private String rank;		// 직급
	
	public CompanyContact() {
		super();
		this.companyName = "";
		this.team = "";
		this.rank = "";
	}
	
	public CompanyContact(String name, String phoneNumber, String eMail, String address, String birthday, String group,
						String companyName, String team, String rank) {
		super(name, phoneNumber, eMail, address, birthday, group);
		this.companyName = companyName;
		this.team = team;
		this.rank = rank;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	
	public void showInfo() {
		super.showInfo();
		System.out.println("회사: " + this.companyName);
		System.out.println("부서: " + this.team);
		System.out.println("직급: " + this.rank);
	}
	
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("부서: " + this.team);
	}
	
}
