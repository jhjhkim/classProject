package guestbook.domain;

public class GuestbookMessage {

	private int idx;
	private String subject;
	private String content;
	private String photo;
	private String username;
	private String regdate;
	private int memberidx;
	
	public GuestbookMessage(int idx, String subject, String content, String photo, String username, String regdate, int memberidx) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.photo = photo;
		this.username = username;
		this.regdate = regdate;
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

	public int getMemberidx() {
		return memberidx;
	}

	@Override
	public String toString() {
		return "GuestbookMessage [idx=" + idx + ", subject=" + subject + ", content=" + content + ", photo=" + photo
				+ ", username=" + username + ", regdate=" + regdate + ", memberidx=" + memberidx + "]";
	}
	
}
