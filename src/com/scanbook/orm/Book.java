/**
 * 
 */
package com.scanbook.orm;

/**
 * @author Zhe
 *
 */
public class Book {
	
	public Book( int barCode, String title, String author, int numOfPage, int readOrNot){
		this.readOrNot = readOrNot;
		this.barCode = barCode;
		this.title = title;
		this.author = author;
		this.numOfPage = numOfPage;
	}
	
	public Book(int bookId, int barCode, String title, String author, int numOfPage, int readOrNot){
		this.bookId= bookId;
		this.barCode = barCode;
		this.title = title;
		this.author = author;
		this.numOfPage = numOfPage;
		this.readOrNot = readOrNot;
	}
	private int bookId;
	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the barCode
	 */
	public int getBarCode() {
		return barCode;
	}
	/**
	 * @param barCode the barCode to set
	 */
	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the numOfPage
	 */
	public int getNumOfPage() {
		return numOfPage;
	}
	/**
	 * @param numOfPage the numOfPage to set
	 */
	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}
	/**
	 * @return the readOrNot
	 */
	public int getReadOrNot() {
		return readOrNot;
	}

	/**
	 * @param readOrNot the readOrNot to set
	 */
	public void setReadOrNot(int readOrNot) {
		this.readOrNot = readOrNot;
	}
	private int barCode;
	private String title;
	private String author;
	private int numOfPage;
	private int readOrNot;
}
