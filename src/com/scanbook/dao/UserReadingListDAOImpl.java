/**
 * 
 */
package com.scanbook.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.scanbook.orm.Book;
import com.scanbook.orm.ReadingListBook;

/**
 * @author Zhe
 *
 */
public class UserReadingListDAOImpl extends JdbcDaoSupport implements UserReadingListDAO{

	@Autowired
	BookDAO bookDAO;
	
	/* (non-Javadoc)
	 * @see com.scanbook.dao.UserReadingListDAO#addBooktoReadingList()
	 */
	@Override
	public int addBooktoReadingList(int userId,int barCode) {
		// TODO Auto-generated method stub		
//		String sql = "insert into UserReadingList " + "values(?, ?,? , ?) ";
		
		
		String sql = "insert into UserReadingList  (readingId, bookId,userId ,reading) "
				+ "select ? as column1, b.bookId as column2, ? as column3, ? as column4 from Books b where barCode = ?";
		int result = this.getJdbcTemplate().update(sql, new Object[]{null, userId, 1, barCode});
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see com.scanbook.dao.UserReadingListDAO#deleteBookFromReadingList(int)
	 */
	@Override
	public int deleteBookFromReadingList(int userId, int barCode) {
		// TODO Auto-generated method stub
//		Book book = bookDAO.search(barCode);
//		String sql = "delete from UserReadingList where bookId=?";
		String sql = "delete from UserReadingList where bookId in (select bookId from Books where barCode = ?) "
				+ "AND userId in (select userId from User where userId = ?)";
		int result = this.getJdbcTemplate().update(sql, barCode, userId);
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see com.scanbook.dao.UserReadingListDAO#getBookList()
	 */
	@Override
	public List<ReadingListBook> getListBooks(int userId) {
		// TODO Auto-generated method stub
		
		String sql = "select b.barCode, b.title, b.author, b.numOfPage, u.reading "
				+ "from Books b, UserReadingList u where u.userId = "+ userId +" AND b.bookId = u.bookId";
		List<ReadingListBook> list =  (List<ReadingListBook>) getJdbcTemplate().query(sql, new BeanPropertyRowMapper(ReadingListBook.class));
		return list;
	}
	/* (non-Javadoc)
	 * @see com.scanbook.dao.UserReadingListDAO#updateBookinReadingList(int)
	 */
	
	
	@Override
	public int updateBookinReadingList(int userId, int barCode, int reading) {
		// TODO Auto-generated method stub
		String sql = "update UserReadingList SET reading = ? where userId = ? AND bookId in (select bookId from Books where barCode = ?)";
		int result = getJdbcTemplate().update(sql, new Object[]{reading, userId, barCode});
		return result;
	}

}
