package com.mome.myapp.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mome.myapp.vo.CommunityVO;
import com.mome.myapp.service.CommunityService;
import com.mome.myapp.vo.PagingVO;

@RestController
@RequestMapping("/community/*")
public class CommunityController {
	@Autowired
	CommunityService service;
	
	ModelAndView mav = null;
	//자유게시판
	@GetMapping("communityList")
	public ModelAndView communityList(PagingVO pVO) {
		mav = new ModelAndView();
		
		pVO.setTotalRecord(service.totalRecord(pVO));
		System.out.println(pVO.toString());
		
		mav.addObject("list", service.communityList(pVO));
		mav.addObject("pVO", pVO);
		
		mav.setViewName("community/communityList");
		return mav;
	}
	//글쓰기폼
		@GetMapping("communityForm")
		public ModelAndView communityForm() {
			mav	= new ModelAndView();
			mav.setViewName("community/communityForm");
			return mav;
		}
		//글쓰기 DB
		@PostMapping("communityFormOk")
		public ResponseEntity<String> communityFormOk(CommunityVO vo, HttpServletRequest request){
			vo.setNickname((String)request.getSession().getAttribute("logNickname"));//세션 로그인 아이디logId
			//세션 로그인 아이디
			
			String msg="<script>";
			try {
				service.CommunityWriteOk(vo);
				msg += "location.href='/community/communityList';";
			}catch(Exception e) {
				msg += "alert('글등록이 실패하였습니다.');";
				msg += "history.go(-1);";
				e.printStackTrace();
			}
			msg += "</script>";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
			headers.add("Content-Type", "text/html; charset=UTF-8");
			ResponseEntity<String> entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
			return entity;
		}
		//글내용보기
		@GetMapping("communityView")
		public ModelAndView communityView(@RequestParam("no") int no, PagingVO pVO) {
			//조회수 증가
			service.hitCount(no);
			
			mav = new ModelAndView();
			mav.addObject("vo", service.getCommunity(no));
			mav.addObject("pVO", pVO);
			mav.setViewName("community/communityView");
			
			return mav;
		}
		//글수정 폼
		@GetMapping("communityEdit/{num}")
		public ModelAndView communityEdit(@PathVariable("num") int no) {
			
			mav = new ModelAndView();
			
			mav.addObject("vo", service.getCommunity(no));
			mav.setViewName("community/communityEdit");
			
			return mav;
		}
		
		//글수정 :DB
		@PostMapping("communityEditOk")
		public ResponseEntity<String> communityEditOk(CommunityVO vo, HttpSession session){
			//세션의 아이디를 구한다.
			vo.setNickname((String)session.getAttribute("logNickname")); //logId
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
			headers.add("Content-Type", "text/html; charset=UTF-8");
			String msg = "<script>";
			try {
				int cnt = service.communityEditOk(vo);
				System.out.println(cnt);
				//수정되었을때 -글내용보기
				msg += "alert('글이 수정되었습니다. 글내용보기로 이동합니다.');";
				msg += "location.href='/community/communityView?no="+vo.getNo()+"';";			
			}catch(Exception e) {
				e.printStackTrace();
				//수정실패일때 -수정으로 보내기(history)
				msg += "alert('글수정 실패하였습니다.');";
				msg += "history.go(-1);";
			}
			msg += "</script>";
			
			return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		}
		
		//글삭제
		@GetMapping("communityDel")
		public ModelAndView communityDel(int no, HttpSession session) {
			int cnt = service.communityDel(no,(String)session.getAttribute("logNickname")); //logId 
			mav = new ModelAndView();
			if(cnt>0) {
				mav.setViewName("redirect:communityList");
			}else {
				mav.setViewName("redirect:communityView");
			}
			return mav;
		}
		//여러개의 레코드 삭제
		@PostMapping("/multiDel")
		public ModelAndView multiDel(CommunityVO vo) {
		
			int cnt = service.communityMultiDel(vo);
			System.out.println("삭제 된 레코드 수 :"+ cnt);
			
			mav = new ModelAndView();
			mav.setViewName("redirect:communityList");
			return mav;
		}
	
	
	
}
