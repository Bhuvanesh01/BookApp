package com.bookapp.model;

public class Book {

	private String title;
	private String author;
	private int bookId;
	private String category;

	public Book(String title, String author, int bookId, String category) {
		super();
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.category = category;
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

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [title: " + title + ", author: " + author + ", bookId: " + bookId + ", category: " + category
				+ "]";
	}

}
