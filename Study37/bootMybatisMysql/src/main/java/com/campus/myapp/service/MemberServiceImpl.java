package com.campus.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.MemberDAO;
import com.campus.myapp.vo.ZipcodeVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	MemberDAO dao;

	@Override
	public int idCheck(String userid) {
		return dao.idCheck(userid);
	}

	@Override
	public List<ZipcodeVO> zipSearch(String doro) {
		return dao.zipSearch(doro);
	}
}
