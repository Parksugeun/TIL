package com.campus.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxView")
	public String ajaxHome() {
		return "ajax/ajaxView";
	}
	
	@RequestMapping(value="/ajaxString", produces="application/text;charset=UTF-8")
	@ResponseBody //리턴되는 값이 뷰가 아닌 데이터이다.
	public String ajaxString(int num, String name, String tel) {
		System.out.println(num+","+name+","+tel);
		
		String data = "<p>번호:"+num+"<br/>이름:"+name+"<br/>연락처:"+tel+"</p>";
		
		return data;
	}
	@RequestMapping("/ajaxObject")
	@ResponseBody //리턴되는 값이 뷰가 아닌 데이터이다.
	public TestVO ajaxObject(int num, String username) {
		System.out.println(num+","+username);
		
		TestVO vo = new TestVO();
		vo.setNo(9999);
		vo.setUsername("김연아");
		vo.setTel("010-1111-9999");
		vo.setAddr("서울시 강남구 역삼동");
		
		return vo;
	}
	@RequestMapping("/ajaxList")
	@ResponseBody //리턴되는 값이 뷰가 아닌 데이터이다.
	public List<TestVO> ajaxList(){
		List<TestVO> lst = new ArrayList<TestVO>();
		
		lst.add( new TestVO(1, "홍길동", "010-1111-1111", "서울시 강남구"));
		lst.add( new TestVO(2, "이순신", "010-2222-1111", "서울시 강서구"));
		lst.add( new TestVO(3, "세종대왕", "010-3333-1111", "서울시 강동구"));
		lst.add( new TestVO(4, "김이나", "010-4444-1111", "서울시 영등포구"));
		
		return lst;
	}
	@RequestMapping("/ajaxMap")
	@ResponseBody //리턴되는 값이 뷰가 아닌 데이터이다.
	public HashMap<String, TestVO> ajaxMap() {
		HashMap<String, TestVO> map = new HashMap<String, TestVO>();
		
		map.put("m1", new TestVO(100, "이민호", "010-8888-9999", "서울시 송파구"));
		map.put("m2", new TestVO(200, "박서준", "010-7777-8888", "서울시 중구"));
		map.put("m3", new TestVO(300, "박보검", "010-4444-3333", "서울시 관악구"));
		
		return map;
	}
	@RequestMapping("/ajaxJson")
	@ResponseBody
	public String ajaxJson(int num, String name, String tel) {
		
		//클라이언트측에서 서버로 전송된  json데이터
		System.out.printf("%d, %s, %s\n", num, name, tel);
		
		int code=5865;
		String productName = "컴퓨터";
		int price = 15000;
		//				{"code":"5865","productName":"컴퓨터","price":"15000"}
		String jsonData = "{\"code\":\""+ code+"\"";
		jsonData += ",\"productName\":\""+productName+"\"";
		jsonData += ",\"price\":\""+price+"\"}";
		
		System.out.println(jsonData);
		return jsonData;
	}
	@RequestMapping(value="/ajaxForm", method=RequestMethod.POST, produces="application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxForm(@RequestParam("num") int num, @RequestParam("username") String username) {
		System.out.println("번호 ->"+ num);
		System.out.println("이름 ->"+ username);
		
		return num+","+username;
	}
}
