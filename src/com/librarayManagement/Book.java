package com.librarayManagement;

public class Book {
	private int bookid;
	private String title;
	private String author;
	private boolean issued;
	
	public Book(int bookid, String title, String author, boolean issued) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.issued = issued;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isIssued() {
		return issued;
	}

	public void setIssued(boolean issued) {
		this.issued = issued;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", issued=" + issued + "]";
	}
	
	
	
	

}
