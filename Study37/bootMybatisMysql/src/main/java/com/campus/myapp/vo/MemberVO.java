package com.campus.myapp.vo;

public class MemberVO {
	private String userid;
	private String userpwd;
	private String username;
	private String tel;
	private String tel1;
	private String tel2;
	private String tel3;
	
	private String email;
	private String zipcode;
	private String addr;
	private String detailaddr;
	private String writedate;
	
	
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", tel=" + tel
				+ ", email=" + email + ", zipcode=" + zipcode + ", addr=" + addr + ", detailaddr=" + detailaddr
				+ ", writedate=" + writedate + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTel() {
		return tel1+"-"+tel2+"-"+tel3;
	}
	public void setTel(String tel) {
		this.tel = tel;
		String telSplit[] = tel.split("-");
		tel1 = telSplit[0];
		tel2 = telSplit[1];
		tel3 = telSplit[2];
	}
	
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDetailaddr() {
		return detailaddr;
	}
	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	
	
}
