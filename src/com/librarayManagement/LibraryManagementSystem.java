package com.librarayManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {
	
	static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> list = new ArrayList<>();
    
 // Search Method
    public static Book searchBook(int id) throws BookNotFoundException {

        for (Book b : list) {
            if (b.getBookid() == id) {
                return b;
            }
        }

        throw new BookNotFoundException("Book Not Found.");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Enter Choice : ");

            try {

                int choice = sc.nextInt();

                switch (choice) {

                case 1:

                    System.out.print("Enter Book ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    for (Book b : list) {
                        if (b.getBookid() == id)
                            throw new DuplicateBookException("Duplicate Book ID.");
                    }

                    System.out.print("Enter Title : ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author : ");
                    String author = sc.nextLine();

                    list.add(new Book(id, title, author, false));

                    System.out.println("Book Added Successfully.");
                    break;

                case 2:

                    if (list.isEmpty()) {
                        System.out.println("No Books Available.");
                    } else {

                        for (Book b : list) {
                            System.out.println("----------------------");
                            System.out.println(b);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Book ID : ");
                    id = sc.nextInt();

                    Book book = searchBook(id);

                    System.out.println(book);

                    break;

                case 4:

                    System.out.print("Enter Book ID : ");
                    id = sc.nextInt();
                    sc.nextLine();

                    book = searchBook(id);

                    System.out.print("Enter New Title : ");
                    title = sc.nextLine();

                    System.out.print("Enter New Author : ");
                    author = sc.nextLine();

                    book.setTitle(title);
                    book.setAuthor(author);

                    System.out.println("Book Updated Successfully.");

                    break;

                case 5:

                    System.out.print("Enter Book ID : ");
                    id = sc.nextInt();

                    book = searchBook(id);

                    list.remove(book);

                    System.out.println("Book Deleted Successfully.");

                    break;

                case 6:

                    System.out.print("Enter Book ID : ");
                    id = sc.nextInt();

                    book = searchBook(id);

                    if (book.isIssued()) {
                        throw new BookAlreadyIssuedException("Book Already Issued.");
                    }

                    book.setIssued(true);

                    System.out.println("Book Issued Successfully.");

                    break;

                case 7:

                    System.out.print("Enter Book ID : ");
                    id = sc.nextInt();

                    book = searchBook(id);

                    if (!book.isIssued()) {
                        throw new BookAlreadyReturnedException("Book Already Available.");
                    }

                    book.setIssued(false);

                    System.out.println("Book Returned Successfully.");

                    break;

                case 8:

                    System.out.println("Thank You.");
                    System.exit(0);

                default:

                    System.out.println("Invalid Menu Choice.");

                }

            }

            catch (InputMismatchException e) {

                System.out.println("Invalid Input. Enter Numbers Only.");
                sc.nextLine();
            }

            catch (DuplicateBookException | BookNotFoundException
                    | BookAlreadyIssuedException
                    | BookAlreadyReturnedException e) {

                System.out.println(e.getMessage());
            }

        }

    }

}


