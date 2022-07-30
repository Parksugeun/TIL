package com.campus.home;

public class TestVO {
	private int no;
	private String username;
	private String tel;
	private String addr;
	
	public TestVO() {}
	public TestVO(int no, String username, String tel, String addr) {
		this.no = no;
		this.username = username;
		this.tel = tel;
		this.addr = addr;
				
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
