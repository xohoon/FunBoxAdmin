package net.customer.dto;

import java.util.Date;

// 태훈 추가 - notice board VO
public class NoticeBoard {
	
	private int idx;
	private String title;
	private String content;
	private Date reg_date_time;
	private String mb_name;
	private int status;
	private String uploadfile;
	private String alias_uploadfile;
	private String real_path;
	
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getAlias_uploadfile() {
		return alias_uploadfile;
	}
	public void setAlias_uploadfile(String alias_uploadfile) {
		this.alias_uploadfile = alias_uploadfile;
	}
	public String getReal_path() {
		return real_path;
	}
	public void setReal_path(String real_path) {
		this.real_path = real_path;
	}
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
		return "NoticeBoard [idx=" + idx + ", title=" + title + ", content=" + content + ", reg_date_time="
				+ reg_date_time + "]";
	}
	
	

}
