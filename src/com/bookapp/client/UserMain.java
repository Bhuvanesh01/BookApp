package com.bookapp.client;

import java.util.List;
import java.util.Scanner;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;

public class UserMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("============Welcome============");
		System.out.println("Please Enter Details For Books to be Added: ");
		BookServiceImpl books = new BookServiceImpl();
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter Book Title: ");
			String title = sc.nextLine();
			System.out.println("Enter Book Author: ");
			String author = sc.nextLine();
			System.out.println("Enter Book BookID: ");
			int bookId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Book Category: ");
			String category = sc.nextLine();
			Book bookDetails = new Book(title, author, bookId, category);

			books.addBook(bookDetails);
			System.out.println("Book Added Successfully");
		}
		System.out.println("");
		System.out.println("To Find a Book By Author or Book ID or List all Books: ");
		System.out.println("Enter A for Author, I for Book ID, L for List of All Books:  ");
		String choice = sc.nextLine();
		try {
		if(choice.equalsIgnoreCase("A"))
		{
			System.out.println("Enter Author Name:  ");
			String searchAuthor = sc.nextLine();
		
			List<Book> searchedBooks = books.getBookByAuthor(searchAuthor);
			if (searchedBooks.size() != 0) {
				for (Book bookList : searchedBooks) {
					System.out.println(bookList);
				}
			}
		}
		   else if(choice.equalsIgnoreCase("L")){
			System.out.println(books.getAllBooks());
		   }
			else {
				System.out.println("Enter BookId:  ");
				int searchId = sc.nextInt();
			
				List<Book> searchedBooks = books.getBookById(searchId);
				if (!searchedBooks.isEmpty()) {
						System.out.println(searchedBooks);
					}
				}
				
			}
		 catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--------------------Completed--------------------");
		sc.close();

	}
}
