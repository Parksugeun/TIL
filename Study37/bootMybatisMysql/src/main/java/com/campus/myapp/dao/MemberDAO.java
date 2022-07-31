package com.campus.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.campus.myapp.vo.ZipcodeVO;

@Mapper
@Repository
public interface MemberDAO {
	//아이디 중복검사
	public int idCheck(String userid);
	//우편번호 찾기
	public List<ZipcodeVO> zipSearch(String doro);
}
