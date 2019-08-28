package net.customer.dto;

public class inquiryAnswer {
	
	private int idx;
	private String title;
	private String category;
	private String id;
	private String name;
	private String reg_date_time ;
	private String content ;
	private String qna_reply;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getReg_date_time() {
		return reg_date_time;
	}
	public void setReg_date_time(String reg_date_time) {
		this.reg_date_time = reg_date_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getQna_reply() {
		return qna_reply;
	}
	public void setQna_reply(String qna_reply) {
		this.qna_reply = qna_reply;
	}
	
	@Override
	public String toString() {
		return "inquiryAnswer [idx=" + idx + ", title=" + title + ", category=" + category + ", id=" + id + ", name="
				+ name + ", reg_date_time=" + reg_date_time + ", content=" + content + ", qna_reply=" + qna_reply + "]";
	}
	
	
			
	
}
