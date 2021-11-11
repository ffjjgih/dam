package Model;

public class Gmail {

	private String from,to,content,subject,frompassword;
	public Gmail() {
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFrompassword() {
		return frompassword;
	}
	public void setFrompassword(String frompassword) {
		this.frompassword = frompassword;
	}
	public Gmail(String from, String to, String content, String subject, String frompassword) {
		this.from = from;
		this.to = to;
		this.content = content;
		this.subject = subject;
		this.frompassword = frompassword;
	}
}
