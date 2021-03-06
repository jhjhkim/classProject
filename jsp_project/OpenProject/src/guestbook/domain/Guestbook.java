package guestbook.domain;

public class Guestbook {

	private int idx;
	private String subject;
	private String content;
	private String regdate;
	private String updatedate;
	private int memberidx;
	
	public Guestbook() {}

	public Guestbook(int idx, String subject, String content, String regdate, String updatedate, int memberidx) {
		super();
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.memberidx = memberidx;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public int getMemberidx() {
		return memberidx;
	}

	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}

	@Override
	public String toString() {
		return "Guestbook [idx=" + idx + ", subject=" + subject + ", content=" + content + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + ", memberidx=" + memberidx + "]";
	}	
	
}
