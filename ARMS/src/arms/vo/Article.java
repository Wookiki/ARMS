package arms.vo;

import java.sql.Timestamp;

public class Article {
	private String ar_writer;
	private int ar_num;
	private String ar_subject;
	private Timestamp ar_date;
	private int ar_readCount;
	private String ar_content;
	private String ar_articleName;
	private int ar_Ref;
	private int ar_re_step;
	private int ar_re_level;
	
	public String getAr_writer() {
		return ar_writer;
	}
	public void setAr_writer(String ar_writer) {
		this.ar_writer = ar_writer;
	}
	public int getAr_num() {
		return ar_num;
	}
	public void setAr_num(int ar_num) {
		this.ar_num = ar_num;
	}
	public String getAr_subject() {
		return ar_subject;
	}
	public void setAr_subject(String ar_subject) {
		this.ar_subject = ar_subject;
	}
	public Timestamp getAr_date() {
		return ar_date;
	}
	public void setAr_date(Timestamp ar_date) {
		this.ar_date = ar_date;
	}
	public int getAr_readCount() {
		return ar_readCount;
	}
	public void setAr_readCount(int ar_readCount) {
		this.ar_readCount = ar_readCount;
	}
	public String getAr_content() {
		return ar_content;
	}
	public void setAr_content(String ar_content) {
		this.ar_content = ar_content;
	}
	public String getAr_articleName() {
		return ar_articleName;
	}
	public void setAr_articleName(String ar_articleName) {
		this.ar_articleName = ar_articleName;
	}
	public int getAr_Ref() {
		return ar_Ref;
	}
	public void setAr_Ref(int ar_Ref) {
		this.ar_Ref = ar_Ref;
	}
	public int getAr_re_step() {
		return ar_re_step;
	}
	public void setAr_re_step(int ar_re_step) {
		this.ar_re_step = ar_re_step;
	}
	public int getAr_re_level() {
		return ar_re_level;
	}
	public void setAr_re_level(int ar_re_level) {
		this.ar_re_level = ar_re_level;
	}
}
