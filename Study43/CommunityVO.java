package com.mome.myapp.vo;

import java.util.List;

public class CommunityVO {
	private int no;
	private String subject;
	private String content;
	private String nickname;
	private int hit;
	private String writedate;
	private List<Integer> noList;
	
	
	
	@Override
	public String toString() {
		return "CommunityVO [no=" + no + ", subject=" + subject + ", content=" + content + ", nickname=" + nickname
				+ ", hit=" + hit + ", writedate=" + writedate + ", noList=" + noList + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public List<Integer> getNoList() {
		return noList;
	}
	public void setNoList(List<Integer> noList) {
		this.noList = noList;
	}
	
	
}
