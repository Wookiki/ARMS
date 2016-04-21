package arms.web.chat.vo;

public class ChatRoom {
	private	int ch_num;
	private String ch_memberId;
	private String ch_memberName;
	private String message;
	public int getCh_num() {
		return ch_num;
	}
	public void setCh_num(int ch_num) {
		this.ch_num = ch_num;
	}
	public String getCh_memberId() {
		return ch_memberId;
	}
	public void setCh_memberId(String ch_memberId) {
		this.ch_memberId = ch_memberId;
	}
	public String getCh_memberName() {
		return ch_memberName;
	}
	public void setCh_memberName(String ch_memberName) {
		this.ch_memberName = ch_memberName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
