package com.crio.rentRead.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.crio.rentRead.dto.Book;
import com.crio.rentRead.exchanges.CreateBookRequest;
import com.crio.rentRead.exchanges.GetAllBooksResponse;
import com.crio.rentRead.exchanges.RentBookResponse;
import com.crio.rentRead.exchanges.ReturnBookResponse;
import com.crio.rentRead.exchanges.UpdateBookRequest;

public interface BookService {

    Book createBook(CreateBookRequest createBookRequest);

    RentBookResponse rentBook(int bookId, UserDetails userDetails);

    ReturnBookResponse returnBook(int bookId, UserDetails userDetails);

    Book updateBook(int bookId, UpdateBookRequest updateBookRequest);

    GetAllBooksResponse findAllBooks();

    String deleteBook(int bookId);
    
}
