package co.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.test.vo.BookVO;

public class BookDAO extends DAO {

	public List<BookVO> bookList() {
		String sql = "select * from book_info";
		conn();
		List<BookVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookTitle(rs.getString("book_title"));
				vo.setBookAuthor(rs.getString("book_author"));
				vo.setBookPress(rs.getString("book_press"));
				vo.setBookPrice(rs.getInt("book_price"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return list;
	}

	public BookVO selectBook(String bookCode) {
		String sql = "";
		BookVO vo = new BookVO();

		return vo;
	}

	public void insertBook(BookVO book) {
		String sql = "";
	}

	public void updateBook(BookVO book) {
		String sql = "";
	}

	public void deleteBook(String bookCode) {
		String sql = "";
	}
}
