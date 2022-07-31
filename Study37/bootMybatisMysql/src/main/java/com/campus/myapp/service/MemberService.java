package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.ZipcodeVO;

public interface MemberService {
	public int idCheck(String userid);
	public List<ZipcodeVO> zipSearch(String doro);
}
