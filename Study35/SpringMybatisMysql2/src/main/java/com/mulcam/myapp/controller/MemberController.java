package com.mulcam.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.myapp.service.MemberService;
import com.mulcam.myapp.vo.MemberVO;

@Controller
public class MemberController {
	@Inject
	MemberService service;
	
	@RequestMapping("/login")
	public String login(){
		return "member/login"; // WEB-INF/views/member/login.jsp
	}
	
	//로그인(DB)
	@RequestMapping(value="/loginOK", method=RequestMethod.POST)
	//public ___ loginOK(String userid, String userpwd) {
	public ModelAndView loginOK(MemberVO vo, HttpSession session) { 
		//vo를 매개변수로 사용하면 보낸 데이터 변수와 같은 이름을 가진 변수에 자동으로 Request해준다.	
		MemberVO resultVO = service.login(vo);
		
		//아이디, 비밀번호가 있으면 아이디와 이름을 vo에담아 리턴하고
		//없으면 null이 리턴된다.
		ModelAndView mav = new ModelAndView();
		
		if(resultVO==null) {//로그인 실패
			mav.setViewName("redirect:login");
		}else {//로그인 성공
			//session기록
			//HttpSession session = request.getSession();
			session.setAttribute("logId", resultVO.getUserid());
			session.setAttribute("logName", resultVO.getUsername());
			session.setAttribute("logStatus", "Y");
			//페이지
			mav.setViewName("redirect:/");		
		}
		return mav;
	}
	//로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		//세션제거 
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
}
