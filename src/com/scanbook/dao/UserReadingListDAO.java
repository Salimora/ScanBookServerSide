/**
 * 
 */
package com.scanbook.dao;

import java.util.List;

import com.scanbook.orm.ReadingListBook;

/**
 * @author Zhe
 *
 */
public interface UserReadingListDAO {
	//add a book to UserReadingList table for current user
	int addBooktoReadingList(int userId, int barCode);
	
	//delete a book to UserReadingList table for current user
	int deleteBookFromReadingList(int userId, int barCode);
	
	//get all book from UserReadingList table for current user
	List<ReadingListBook> getListBooks(int userId);
	
	//update a book Info to UserReadingList table for current user
	int updateBookinReadingList(int userId, int barCode, int reading);
}
