package guestbook.domain;

public class GuestbookMessage {

	private int idx;
	private String subject;
	private String content;
	private String photo;
	private String username;
	private String regdate;
	private String updatedate;
	private int memberidx;
	
	public GuestbookMessage(int idx, String subject, String content, String photo, String username, String regdate, String updatedate, int memberidx) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.photo = photo;
		this.username = username;
		this.regdate = regdate;
		this.updatedate =updatedate;
		this.memberidx = memberidx;
	}

	public int getIdx() {
		return idx;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public String getPhoto() {
		return photo;
	}

	public String getUsername() {
		return username;
	}

	public String getRegdate() {
		return regdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public int getMemberidx() {
		return memberidx;
	}

	@Override
	public String toString() {
		return "GuestbookMessage [idx=" + idx + ", subject=" + subject + ", content=" + content + ", photo=" + photo
				+ ", username=" + username + ", regdate=" + regdate + ", updatedate=" + updatedate + ", memberidx="
				+ memberidx + "]";
	}

}
