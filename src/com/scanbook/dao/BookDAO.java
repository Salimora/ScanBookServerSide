/**
 * 
 */
package com.scanbook.dao;

import java.util.List;

import com.scanbook.orm.Book;

/**
 * @author Zhe
 *
 */
public interface BookDAO {
	//add a new book to book table
	int add(int barCode, String title, String author, int numOfPage, int readOrNot);
	
	//search a book from book table based barCode
	Book search(int barCode);
	
	//delete a book from book table
	int delete(int barCode);
	
	//get all books Info from book table
	List<Book> getAllBook();
	
	//update a book Info based barCode
	int updateBook(int barCode, String title, String author, int numOfPage, int readOrNot);
}
