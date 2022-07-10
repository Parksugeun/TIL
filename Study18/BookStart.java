
import java.util.List;
import java.util.Scanner;





public class BookStart {
	Scanner scan = new Scanner(System.in);
	BookDAO dao = new BookDAO();
	public BookStart() {
		start();
	}
	public void start() {
		
		do {
			try {	
				String menu = menuShow();
				System.out.print(menu);
				if(menu.equals("1")) { 
					bookList();
				}else if(menu.equals("2")) {
					bookInsert();
				}else if(menu.equals("3")) {
					bookEdit();
				}else if(menu.equals("4")) {
					bookDel(); 
				}else if(menu.equals("5")) {
					bookStop();
				}else if(menu.equals("6")) {
					bookNameSearch();
				}	
			}catch(Exception e) {
				System.out.println("메뉴를 잘못입력하였습니다.");
				e.printStackTrace();
			}
			
		}while(true);
	}
		public String menuShow() {
		
		System.out.print("메뉴[1.책목록, 2.책등록, 3.책정보수정, 4.책삭제, 5.종료, 6.책검색]->");
		
		return scan.nextLine();
	}
		//책목록
		public void bookList() {
			
			String searchWord = null;
			
			bookPrint(dao.bookSelect(searchWord));
			
		}
		//책 목록 출력
		public void bookPrint(List<BookVO> list) {
			System.out.println("\n ------------------------------ 책 목록 ------------------------------");
			for(int i=0; i<list.size(); i++) {
				BookVO vo = list.get(i);
				
				System.out.printf("%6s %12s %10s %16s %20s\n", vo.getBookno(), vo.getBookName(), vo.getBookwriter(), vo.getPublisher(), vo.getBookdate());
		}
	}
		public void bookInsert() {
			//책등록
			BookVO vo = new BookVO();
			System.out.print("책코드를 입력하세요->"); 
			vo.setBookno(scan.nextLine());
			System.out.print("도서명을 입력하세요->");
			vo.setBookName(scan.nextLine());
			System.out.print("저자명을 입력하세요->");
			vo.setBookwriter(scan.nextLine());
			System.out.print("출판사명을 입력하세요->");
			vo.setPublisher(scan.nextLine());
			System.out.print("비치일을 입력하세요->");
			vo.setBookdate(scan.nextLine()); 
			
			
			int cnt = dao.bookInsert(vo);
			if(cnt>0) {
				System.out.println(vo.getBookName()+"이 등록되었습니다.");
			}else {
				System.out.println("등록실패하였습니다.");
			}
		}
		//책 정보수정
		public void bookEdit() {
			BookVO vo = new BookVO();
			System.out.print("수정할책코드->");
			
			vo.setBookno(scan.nextLine());
			
			System.out.print("수정할항목[1.출판사, 2.비치일]->");
			String editMenu = scan.nextLine();
				if(editMenu.equals("1")) {
					vo.setFieldName("publisher");
					System.out.print("수정할 출판사->");
				}else if(editMenu.equals("2")) {
					vo.setFieldName("bookdate");
					System.out.print("수정할 비치일->");
				}
				vo.setPublisher(scan.nextLine());
				
				int cnt = Integer.parseInt(dao.bookUpdate(vo));
				if(cnt>0) {
					System.out.println(vo.getPublisher()+"으로 수정되었습니다.");
				}else {
					System.out.println("수정실패하였습니다.");
			}
		}
		
		//책삭제
		public void bookDel() {
			System.out.print("삭제할 책의 코드->");
			String bookno = (scan.nextLine());
			int result = Integer.parseInt(dao.bookDelete(bookno));
			
				if(result >0) {
					System.out.println(bookno+"책이 삭제되었습니다..");
				}else {
					System.out.println(bookno+"책 삭제 실패하였습니다.");
			}
		}
		//종료
		public void bookStop() {
			System.exit(0);
		}
		//책 검색
		public void bookNameSearch() {
			System.out.print("검색할 책명->");
			String searchword = scan.nextLine();
			
			
			//출력
			System.out.println(searchword);
			bookPrint(dao.bookSelect(searchword));
		}
		
	
		public static void main(String[] args) {
			new BookStart();
	
		}

}
