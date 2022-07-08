package mysql_jdbc;
import java.util.List;
import java.util.Scanner;

import BookDAO;
import BookStart;
import BookVO;


public class LibraryEx {
	Scanner scan = new Scanner(System.in);
	BookDAO dao = new BookDAO();
	public LibraryEx() {
		start();
	}
public void start() {
		
		do {
			try {
			String menu = menuShow();
			if(menu.equals("1")) {//회원목록
				bookList();
			}else if(menu.equals("2")) {//회원등록
				bookAdd();
			}else if(menu.equals("3")) {//회원수정
				bookEdit();
			}else if(menu.equals("4")) {//회원삭제
				bookDel();
			}else if(menu.equals("5")) {//종료
				bookClose();
			}else if(menu.equals("6")) {
				bookSearch();
			}
			}catch(Exception e) {
				System.out.println("잘못된정보가 입력되었습니다.");
			}
		}while(true);
	}
	//
	public void bookSearch() {
		System.out.print("검색어->");
		String searchword = scan.nextLine();
		
		//List<EmpVO> list = dao.empSelect(searchword);
		//출력
			System.out.println(searchword);
		bookPrint(dao.bookSelect(searchword));
	}
	//회원목록
		public void bookList() {
			//회원 목록 DB에서 선택할 수 있는 메소드를 호출
			//EmpDAO dao = EmpDAO.getInstance();
			//EmpDAO dao = new EmpDAO();
			String searchWord = null;
			
			//List<EmpVO> list = dao.empSelect(searchWord);
			bookPrint(dao.bookSelect(searchWord));
			
			
		}
	//목록출력
		public void bookPrint(List<BookVO> list) {
			for(int i=0; i<list.size(); i++) {
				BookVO vo = list.get(i);
				System.out.printf("%6d %12s %10s %16s %20s\n", vo.getBookno(), vo.getBookName(), vo.getBookwriter(), vo.getPublisher(), vo.getBookdate());
		}
	}
	//회원정보 삭제
	public void bookDel() {
		System.out.print("삭제할 회원번호->");
		String bookno = scan.nextLine();
		//EmpDAO dao = new EmpDAO();
		int result = Integer.parseInt(dao.bookDelete(bookno));
		if(result >0) {
			System.out.println(bookno+"회원이 삭제되었습니다..");
		}else {
			System.out.println(bookno+"회원 삭제 실패하였습니다.");
		}
	}
	public void bookAdd() {
		//회원번호, 이름, 부서명, 연락처, 이메일
		//입력받은 데이터를 VO저장하기 위해서 객체를 생성
		BookVO vo = new BookVO();
		System.out.print("회원번호->");
		vo.setBookno(scan.nextLine());
		System.out.print("이름->");
		vo.setBookName(scan.nextLine());
		System.out.print("부서명->");
		vo.setBookwriter(scan.nextLine());
		System.out.print("연락처->");
		vo.setPublisher(scan.nextLine());
		System.out.print("이메일");
		vo.setBookdate(scan.nextLine());
		
		//EmpDAO dao = new EmpDAO();
		int cnt = dao.bookInsert(vo);
		if(cnt>0) {
			System.out.println(vo.getBookName()+"이 회원등록되었습니다.");
		}else {
			System.out.println("회원등록실패하였습니다.");
		}
	}
	//회원정보 수정
	public void bookEdit() {
		BookVO vo = new BookVO();
		System.out.print("수정할 회원번호->");
		vo.setBookno(scan.nextLine());
		
		//수정할 항목
		System.out.print("수정할 항목선택[1.연락처, 2.부서명, 3.이메일]");
		String editField = scan.nextLine();
		if(editField.equals("1")) {
			vo.setFieldName("publisher");
			System.out.print("수정할 연락처->");
		}else if(editField.equals("2")) {
			vo.setFieldName("depart");
			System.out.print("수정할 부서명->");
		}
		vo.setPublisher(scan.nextLine());
		
		//EmpDAO dao = EmpDAO.getInstance();
		int cnt = dao.bookUpdate(vo);
		if(cnt>0) {
			System.out.println(vo.getPublisher()+"으로 수정되었습니다.");
		}else {
			System.out.println("수정실패하였습니다.");
		}
	}
	
	//종료
	public void bookClose() {
		System.exit(0);
	}
	//메뉴
	public String menuShow() {
		System.out.print("메뉴[1.회원목록, 2.회원등록, 3.회원수정, 4.회원삭제, 5.종료, 6.검색]->");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		new BookStart();
}
}