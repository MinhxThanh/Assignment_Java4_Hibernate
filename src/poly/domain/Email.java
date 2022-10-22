package poly.domain;

public class Email {
	private String from, to, fromPassword, content, subjectString;

	public Email() {
		
	}
	
	public Email(String from, String to, String fromPassword, String content, String subjectString) {
		this.from = from;
		this.to = to;
		this.fromPassword = fromPassword;
		this.content = content;
		this.subjectString = subjectString;
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

	public String getFromPassword() {
		return fromPassword;
	}

	public void setFromPassword(String fromPassword) {
		this.fromPassword = fromPassword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubjectString() {
		return subjectString;
	}

	public void setSubjectString(String subjectString) {
		this.subjectString = subjectString;
	}
}
