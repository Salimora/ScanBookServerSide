/**
 * 
 */
package com.scanbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.scanbook.dao.UserReadingListDAO;
import com.scanbook.orm.ReadingListBook;
import com.scanbook.orm.UserReadingList;

/**
 * @author Zhe
 *
 */
public class UserReadingListServiceImpl implements UserReadingListService{

	@Autowired
	UserReadingListDAO userReadingListDAO;
	
	/* (non-Javadoc)
	 * @see com.scanbook.service.UserReadingListService#addBooktoReadingList(int)
	 */
	@Override
	public int addBooktoReadingList(int userId, int barCode) {
		// TODO Auto-generated method stub
		int result = userReadingListDAO.addBooktoReadingList(userId, barCode);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.scanbook.service.UserReadingListService#deleteBookFromReadingList(int)
	 */
	@Override
	public int deleteBookFromReadingList(int userId, int barCode) {
		// TODO Auto-generated method stub
		int result = userReadingListDAO.deleteBookFromReadingList(userId, barCode);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.scanbook.service.UserReadingListService#getListBooks()
	 */
	@Override
	public List<ReadingListBook> getListBooks(int userId) {
		// TODO Auto-generated method stub
		return userReadingListDAO.getListBooks(userId);
	}

	/* (non-Javadoc)
	 * @see com.scanbook.service.UserReadingListService#updateBookinReadingList(int, int)
	 */
	@Override
	public int updateBookinReadingList(int userId, int barCode, int reading) {
		// TODO Auto-generated method stub
		int result = userReadingListDAO.updateBookinReadingList(userId, barCode, reading);
		return result;
	}

}
