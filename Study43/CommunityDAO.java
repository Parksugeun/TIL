package com.mome.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import com.mome.myapp.vo.CommunityVO;
import com.mome.myapp.vo.PagingVO;

@Mapper
@Repository
public interface CommunityDAO {
		//자유게시판 글목록
		public List<CommunityVO> communityList(PagingVO pVO);
		//글등록
		public int CommunityWriteOk(CommunityVO vo);
		//글선택(수정), 글내용보기
		public CommunityVO getCommunity(int no);
		//글수정
		public int communityEditOk(CommunityVO vo);
		//글삭제
		public int communityDel(int no, String nickname);
		//조회수
		public void hitCount(int no);
		//총레코드 수
		public int totalRecord(PagingVO pVO);
		//여러개의 레코드 삭제
		public int communityMultiDel(CommunityVO vo);
	
}
