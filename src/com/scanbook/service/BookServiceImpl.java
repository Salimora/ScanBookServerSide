/**
 * 
 */
package com.scanbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scanbook.dao.BookDAO;
import com.scanbook.orm.Book;

/**
 * @author Zhe
 *
 */
public class BookServiceImpl implements BookService {
	 
	 
	 @Autowired
	 BookDAO bookDAO;

	/* (non-Javadoc)
	 * @see com.scanbook.service.BookService#addBook(com.scanbook.orm.Book)
	 */
	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		int barCode = book.getBarCode();
		int numOfPage = book.getNumOfPage();
		String title = book.getTitle();
		String author = book.getAuthor();
		int readOrNot = book.getReadOrNot();
		int result = bookDAO.add(barCode, title, author, numOfPage, readOrNot);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.scanbook.service.BookService#searchBook(com.scanbook.orm.Book)
	 */
	@Override
	public Book searchBook(int barCode) {
		// TODO Auto-generated method stub
		return bookDAO.search(barCode);
		
	}

	/* (non-Javadoc)
	 * @see com.scanbook.service.BookService#deleteBook(com.scanbook.orm.Book)
	 */
	@Override
	public int deleteBook(int barCode) {
		// TODO Auto-generated method stub
		int result = bookDAO.delete(barCode);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.scanbook.service.BookService#getBookList()
	 */
	@Override
	public List<Book> getBookList() {
		// TODO Auto-generated method stub
		return bookDAO.getAllBook();
	}

	/* (non-Javadoc)
	 * @see com.scanbook.service.BookService#updateBook(com.scanbook.orm.Book)
	 */
	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		int barCode = book.getBarCode();
		int numOfPage = book.getNumOfPage();
		String title = book.getTitle();
		String author = book.getAuthor();
		int readOrNot = book.getReadOrNot();
		int result = bookDAO.updateBook(barCode, title, author, numOfPage, readOrNot);
		return result;
	}
}
