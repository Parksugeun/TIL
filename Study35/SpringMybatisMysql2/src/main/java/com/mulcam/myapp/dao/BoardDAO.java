package com.mulcam.myapp.dao;

import java.util.List;

import com.mulcam.myapp.vo.BoardVO;

public interface BoardDAO {
	//글등록
	public int boardWriteOk(BoardVO vo);
	//글목록
	public List<BoardVO> boardList();
	//글선택
	public BoardVO boardView(int no);
	//조회수 증가
	public void hitCount(int no);
	//글수정
	public int boardEditOk(BoardVO vo);
	//글삭제
	public int boardDel(int no, String userid);
}
