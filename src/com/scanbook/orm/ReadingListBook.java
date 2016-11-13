/**
 * 
 */
package com.scanbook.orm;

/**
 * @author Zhe
 *
 */

//Mapping ReadingListBook from table result
public class ReadingListBook {
	int barCode;
	String title;
	String author;
	int numOfPage;
	int reading;
//	int userId;
	/**
	 * @return the userId
	 */
//	public int getUserId() {
//		return userId;
//	}
//	/**
//	 * @param userId the userId to set
//	 */
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
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
	 * @return the reading
	 */
	public int getReading() {
		return reading;
	}
	/**
	 * @param reading the reading to set
	 */
	public void setReading(int reading) {
		this.reading = reading;
	}
	
}
