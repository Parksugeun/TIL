package com.mulcam.myapp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.myapp.service.BoardService;
import com.mulcam.myapp.vo.BoardVO;

@Controller
public class BoardController {
	@Inject
	BoardService service;
	
	//글목록
	@RequestMapping("/board/list")
	public ModelAndView boardList() {
		
		ModelAndView mav = new ModelAndView();
		
		//DB조회
		//List<BoardVO> list = service.boardList();
		//mav.addObject("list", list);
		
		mav.addObject("list", service.boardList());
		
		mav.setViewName("board/boardList");
		
		return mav;
	}
	//글쓰기 폼으로 이동
	@RequestMapping("/board/write")
	public String boardWrite() {
		return "board/boardWrite";
	}
	//글쓰기 DB
	@RequestMapping(value="/board/writeOk", method=RequestMethod.POST)
	public ModelAndView boardWriteOk(BoardVO vo, HttpServletRequest request) {
		// BoardVO에는 폼내의 subject, content는 request객체를 통해 getParameter()를 스프링이 실행해준다.
	
		vo.setIp(request.getRemoteAddr());//접속자의 ip를 구하여 vo의 변수에 setting
		
		//vo.setUserid((String)request.getSession().getAttribute("logId"));
		
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("logId");
		vo.setUserid(userid);
		
		int cnt = service.boardWriteOk(vo);
		
		ModelAndView mav = new ModelAndView();
		//등록이 된 경우 -> 게시판 목록으로 이동
		if(cnt>0) {
			mav.setViewName("redirect:/board/list");
		}else {//등록이 안 된 경우 -> 글쓰기 폼으로 이동
			mav.addObject("msg", "글등록");
			mav.setViewName("board/boardResult");
		}
		return mav;
	}
	//글내용보기
	@RequestMapping("/board/view")
	public String boardView(int no, Model model) {
		//조회수 증가
		service.hitCount(no);
		
		//글선택	
		BoardVO vo = service.boardView(no);
		model.addAttribute("viewVO", vo);
		return "board/boardView";
	}
	
	//글수정 폼
	@RequestMapping("/board/edit")
	public ModelAndView boardEdit(int no) {
		BoardVO vo= service.boardView(no);
		
		ModelAndView mav = new ModelAndView();
		//수정하기 위한 레코드정보
		mav.addObject("vo", vo);
		mav.setViewName("board/boardEdit");
		
		return mav;
	}
	//글수정 DB
	@RequestMapping(value="/board/editOk", method=RequestMethod.POST)
	public ModelAndView boardEditOk(BoardVO vo, HttpSession session) {
		
		//로그인 아이디를 얻어 vo에 userid에 셋팅
		vo.setUserid((String)session.getAttribute("logId"));
		
		//vo -> no, subject, content, userid
		int cnt = service.boardEditOk(vo);
		
		ModelAndView mav = new ModelAndView();
		if(cnt>0) {//글이 수정된 경우 글내용 보기로 이동
			mav.addObject("no", vo.getNo());
			mav.setViewName("redirect:/board/view");
		}else {
			mav.addObject("msg", "글수정");
			mav.setViewName("board/boardResult");
		}
		return mav;
		
	}
	//글지우기
	@RequestMapping("/board/del")
	public ModelAndView boardDel(int no, HttpServletRequest request) {
		
		String userid = (String)request.getSession().getAttribute("logId");
		
		int cnt = service.boardDel(no, userid);
		
		ModelAndView mav = new ModelAndView();
		if(cnt>0){//삭제 -> 글목록
			mav.setViewName("redirect:/board/list");
		}else{//삭제 실패 -> 글내용보기
			mav.addObject("no", no);
			mav.setViewName("redirect:/board/view");
		}
		return mav;
	}
}
