package guestbook.domain;

public class GuestEditRequest {

	private String subject;
	private String content;
	private int idx;
	
	public GuestEditRequest(String subject, String content, int idx) {
		this.subject = subject;
		this.content = content;
		this.idx = idx;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public Guestbook getGuestbook() {
		return new Guestbook(0, this.subject, this.content, null, null, this.idx);
	}
}
