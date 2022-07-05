package basic05_collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	//ArrayList list = new ArrayList();
	//ArrayList<MemberVO> list = new ArrayList<Member>(); 
	List<MemberVO> list = new ArrayList<MemberVO>();
	public ArrayListTest() {
		// 사원번호 사원명 부서명
		MemberVO vo = new MemberVO();
		vo.setNum(100); 
		vo.setUsername("이순신");
		vo.setDepartment("총무부");
		vo.setTel("010-1234-5678");
		
		MemberVO vo2 = new MemberVO(200, "세종대왕", "기획부", "010-1111-2222");
		
		MemberVO vo3 = new MemberVO(300, "장영실", "인사부", "010-7896-9858");
	
		list.add(vo);
		list.add(vo2);
		list.add(vo3);
		//list.add("String");
	}
}
