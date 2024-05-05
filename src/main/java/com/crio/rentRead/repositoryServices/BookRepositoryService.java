package com.crio.rentRead.repositoryServices;

import java.util.List;

import com.crio.rentRead.dto.Book;
import com.crio.rentRead.dto.User;

public interface BookRepositoryService {
    
    Book createBook(String title, String author, String genre, String availabilityStatus);

    User rentBook(int bookId, String email);

    User returnBook(int bookId, String email);

    Book updateBook(int bookId, String title, String author, String genre, String availabilityStatus);

    List<Book> findAllBooks();

    void deleteBook(int bookId);
    
}
