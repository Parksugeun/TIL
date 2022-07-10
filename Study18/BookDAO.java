import java.util.ArrayList;
import java.util.List;





public class BookDAO extends DBConnection {

	public BookDAO() {
		
	}
	public static BookDAO getInstance() {
		return new BookDAO();
	}
	//목록
	public List<BookVO> bookSelect(String searchWord) {
		List<BookVO> list= new ArrayList<BookVO>();
		try {
			getConn();
			//검색어 없으면 아래문장 실행
			sql = " select  bookno, bookName, bookwriter, publisher, bookdate from library";
			
			if(searchWord != null) {
				sql += " where bookname like ?";
			}
			sql += " order by bookno";
			
			
			pstmt = conn.prepareStatement(sql);
			
			if(searchWord != null) {
				pstmt.setString(1, "%" + searchWord + "%");
			}
			
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				BookVO vo = new BookVO();
				vo.setBookno(rs.getString(1));
				vo.setBookName(rs.getString(2));
				vo.setBookwriter(rs.getString(3));
				vo.setPublisher(rs.getString(4));
				vo.setBookdate(rs.getString(5));
				
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return list;
	}
	//책 등록
	public int bookInsert(BookVO vo) {
		int result = 0;
		try {
			getConn();
			sql = "insert into library(bookno, bookName, bookwriter, publisher, bookdate) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBookno());
			pstmt.setString(2, vo.getBookName());
			pstmt.setString(3, vo.getBookwriter());
			pstmt.setString(4, vo.getPublisher());
			pstmt.setString(5, vo.getBookdate());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	// 수정
	public String bookUpdate(BookVO vo) {
		String result = Integer.toString(0);
		try {
			getConn();
		 
			sql = "update library set "+vo.getFieldName()+"=? where bookno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPublisher());
			pstmt.setString(2, vo.getBookno()); 
			
			result = Integer.toString(pstmt.executeUpdate());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	}
	//책 삭제
	public String bookDelete(String bookno) {
		String result = Integer.toString(0);
		try {
			getConn();
			sql = "delete from library where bookno=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookno);
			
		
			result = Integer.toString(pstmt.executeUpdate());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
