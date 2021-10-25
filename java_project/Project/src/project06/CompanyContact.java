package project06;

// ① CompanyContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
//	- 회사이름, 부서이름, 직급 변수 추가
//	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
public class CompanyContact extends Contact {

	private String companyName;	// 회사이름
	private String teamName;	// 부서이름
	private String job;	// 직급
	
	public CompanyContact() {
		super();
		this.companyName = "";
		this.teamName = "";
		this.job = "";
	}
	
	public CompanyContact(String name, String phoneNumber, String eMail, String address, String birthday, String group,
						String companyName, String teamName, String job) {
		super(name, phoneNumber, eMail, address, birthday, group);
		this.companyName = companyName;
		this.teamName = teamName;
		this.job = job;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
		System.out.println("회사: " + companyName);
		System.out.println("부서: " + teamName);
		System.out.println("직급: " + job);
	}
	
	@Override
	public void showBasicData() {
		System.out.println("[" + companyName + "] [" + teamName + "] " + getName());
	}
	
}
