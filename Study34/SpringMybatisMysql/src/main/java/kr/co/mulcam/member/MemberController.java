package kr.co.mulcam.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	//로그인폼
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		
		return "member/login";//뷰파일명
	}
	//로그인
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public ModelAndView loginOk(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		System.out.println("userid->"+ userid);
		System.out.println("userpwd->"+ userpwd);
		
		//Model
		mav.addObject("userid", userid);
		mav.addObject("username", "세종대왕");
		//View
		mav.setViewName("home");
		
		return mav;
	}
}
//	프리픽서에서	   /서브픽서에서   /프리픽서에서
//	/WEB-INF/views/member/login.jsp
