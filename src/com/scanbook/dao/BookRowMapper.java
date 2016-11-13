/**
 * 
 */
package com.scanbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.scanbook.orm.Book;

/**
 * @author Zhe
 *
 */
public class BookRowMapper implements RowMapper{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	
	//mapping Data to Book.class
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book book = new Book(rs.getInt("bookId"), rs.getInt("barCode"), rs.getString("title"), 
				rs.getString("author"), rs.getInt("numOfPage"), rs.getInt("readOrNot"));
		
		return book;
	}

}
