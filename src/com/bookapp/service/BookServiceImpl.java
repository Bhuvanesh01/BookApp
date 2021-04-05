package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {

	ArrayList<Book> bookList = new ArrayList<>();

	@Override
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {
		return bookList;
	}

	@Override
	public List<Book> getBookByAuthor(String Author) throws BookNotFoundException {
		ArrayList<Book> searchedBooks = new ArrayList<>();
		for (Book bookDetail : bookList) {
			if (bookDetail.getAuthor().equalsIgnoreCase(Author)) {
				searchedBooks.add(bookDetail);
			}
		}
		if (!searchedBooks.isEmpty()) {
			return searchedBooks;
		} else {
			throw new BookNotFoundException("There are no books available by "+Author);
		}
	}

	@Override
	public List<Book> getBookById(int bookId) throws BookNotFoundException {
		ArrayList<Book> searchedBooks = new ArrayList<>();
		for (Book bookDetail : bookList) {
			if (bookDetail.getBookId()==bookId) {
				searchedBooks.add(bookDetail);
			}
		}
		if (!searchedBooks.isEmpty()) {
			return searchedBooks;
		} else {
			throw new BookNotFoundException("There is no book with "+bookId);
		}
	
	}

}
