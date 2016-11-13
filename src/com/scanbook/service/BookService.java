/**
 * 
 */
package com.scanbook.service;

import java.util.List;

import com.scanbook.orm.Book;

/**
 * @author Zhe
 *
 */
public interface BookService {
	//update book info to Books table
	int updateBook(Book book);
	
	//add a new book to Books table
	int addBook(Book book);
	
	//search a book from Books table 
	Book searchBook(int barCode);
	
	//delete a book from Books table
	int deleteBook(int barCode);
	
	//get all book Info from Books table
	List<Book> getBookList();
}
