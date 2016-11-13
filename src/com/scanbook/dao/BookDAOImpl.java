/**
 * 
 */
package com.scanbook.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.scanbook.orm.Book;

/**
 * @author Zhe
 *
 */
public class BookDAOImpl extends JdbcDaoSupport implements BookDAO{
	
	private int getBookId(int barCode){
		String sql = "select * from Books where barCode=?";
		Book book = (Book)getJdbcTemplate().queryForObject(
				sql, new Object[] { barCode }, new BookRowMapper());
		return book.getBookId();
	}
	
	/* (non-Javadoc)
	 * @see com.scanbook.dao.BookDAO#add(com.scanbook.orm.Book)
	 */
	@Override
	public int add(int barCode, String title, String author, int numOfPage, int readOrNot) {
		// TODO Auto-generated method stub
		String sql = "insert into Books " + "values(?, ?, ?, ?, ?, ?)"; 
		//In database, bookId is set a primary key and auto increment, so setting bookId is null 
        int result = getJdbcTemplate().update(sql, new Object[]{null, barCode, title, author, numOfPage, readOrNot});
        return result;
	}

	/* (non-Javadoc)
	 * @see com.scanbook.dao.BookDAO#search(com.scanbook.orm.Book)
	 */
	@Override
	public Book search(int barCode) {
		// TODO Auto-generated method stub
		String sql = "select * from Books where barCode=?";
		Book book = (Book)getJdbcTemplate().queryForObject(
				sql, new Object[] { barCode }, new BookRowMapper());
		return book;
	}

	/* (non-Javadoc)
	 * @see com.scanbook.dao.BookDAO#delete(com.scanbook.orm.Book)
	 */
	@Override
	public int delete(int barCode) {
		// TODO Auto-generated method stub
		 String sql = "delete from Books where barCode=?";
		 int result = this.getJdbcTemplate().update(sql, barCode);
		 return result;
	}

	/* (non-Javadoc)
	 * @see com.scanbook.dao.BookDAO#getAllBook()
	 */
	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		String sql = "select * from Books";
		
	    return getJdbcTemplate().query(sql, new BookRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.scanbook.dao.BookDAO#updateBook(com.scanbook.orm.Book)
	 */
	@Override
	public int updateBook(int barCode, String title, String author, int numOfPage, int readOrNot) {
		// TODO Auto-generated method stub
		
		String sql2= "update Books SET title = ?, author = ?, numOfPage = ?, readOrNot = ? where barCode = ?";
		int result = getJdbcTemplate().update(sql2, new Object[]{title, author, numOfPage,readOrNot, barCode});
		return result;
	}

}
