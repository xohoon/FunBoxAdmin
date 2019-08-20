package net.customer.dto;

import java.util.Date;

public class FaqBoard {

	private int idx;
	private int mb_idx;
	private int category; //faq 구분(1:입출금, 2:투자, 3:기타)
	private String title;
	private String content;
	private Date reg_date_time;
	private String mb_name;
	private int status;
		
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getMb_idx() {
		return mb_idx;
	}
	public void setMb_idx(int mb_idx) {
		this.mb_idx = mb_idx;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date_time() {
		return reg_date_time;
	}
	public void setReg_date_time(Date reg_date_time) {
		this.reg_date_time = reg_date_time;
	}
	@Override
	public String toString() {
		return "FaqVO [idx=" + idx + ", category=" + category + ", title=" + title + ", content=" + content
				+ ", reg_date_time=" + reg_date_time + "]";
	}
}
