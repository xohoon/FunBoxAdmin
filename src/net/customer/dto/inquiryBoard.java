package net.customer.dto;

public class inquiryBoard {
	
	private int idx;
	private String id;
	private String name;
	private String title;
	private String reg_date_time ;
	private String qna_reply;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReg_date_time() {
		return reg_date_time;
	}
	public void setReg_date_time(String reg_date_time) {
		this.reg_date_time = reg_date_time;
	}
	public String getQna_reply() {
		return qna_reply;
	}
	public void setQna_reply(String qna_reply) {
		this.qna_reply = qna_reply;
	}
	
	@Override
	public String toString() {
		return "inquiryBoard [idx=" + idx + ", id=" + id + ", name=" + name + ", title=" + title + ", reg_date_time="
				+ reg_date_time + ", qna_reply=" + qna_reply + "]";
	}
	
		
	
}
