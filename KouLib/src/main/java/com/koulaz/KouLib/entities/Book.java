package com.koulaz.KouLib.entities;


public class Book {
	/**
	 * 
	 */
	private String bookName;
	private String bookAuthor;
	/**
	 * @param bookId
	 * @param bookName
	 * @param bookAuthor
	 */
	public Book(String bookName, String bookAuthor) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}
	/**
	 * For (De)Serialization
	 */
	public Book() {
		this("Nothing","Noone");
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the bookAuthor
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}
	/**
	 * @param bookAuthor the bookAuthor to set
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public String toViewString() {
		return "Title: " + bookName + ", Author: " + bookAuthor;
	}
	@Override
	public String toString() {
		return "Book [ bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}
	
	
}
