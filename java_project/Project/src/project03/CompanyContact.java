package project03;

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
	
	public void showInfo() {
		super.showInfo();
		System.out.println("회사: " + this.company);
		System.out.println("부서: " + this.team);
		System.out.println("직급: " + this.rank);
	}
	
	public void showBasicInfo() {
		System.out.print("[" + this.company + "] [" + this.team + "] ");
		super.showBasicInfo();
	}
	
}
