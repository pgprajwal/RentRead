package com.crio.rentRead.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import com.crio.rentRead.dto.Book;
import com.crio.rentRead.dto.User;
import com.crio.rentRead.exchanges.CreateBookRequest;
import com.crio.rentRead.exchanges.GetAllBooksResponse;
import com.crio.rentRead.exchanges.RentBookResponse;
import com.crio.rentRead.exchanges.ReturnBookResponse;
import com.crio.rentRead.exchanges.UpdateBookRequest;
import com.crio.rentRead.repositoryServices.BookRepositoryService;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositoryService bookRepositoryService;

    @Override
    public Book createBook(CreateBookRequest createBookRequest) {
        String title = createBookRequest.getTitle();
        String author = createBookRequest.getAuthor();
        String genre = createBookRequest.getGenre();
        String availabilityStatus = createBookRequest.getAvailabilityStatus().toUpperCase();

        Book book = bookRepositoryService.createBook(title, author, genre, availabilityStatus);
        return book;
    }

    @Override
    public RentBookResponse rentBook(int bookId, UserDetails userDetails) {
        String email = userDetails.getUsername();

        User user = bookRepositoryService.rentBook(bookId, email);
        RentBookResponse rentBookResponse = new RentBookResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getRole(), user.getRentedBooks());
        return rentBookResponse;
    }

    @Override
    public ReturnBookResponse returnBook(int bookId, UserDetails userDetails) {
        String email = userDetails.getUsername();

        User user = bookRepositoryService.rentBook(bookId, email);
        ReturnBookResponse returnBookResponse = new ReturnBookResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getRole(), user.getRentedBooks());
        return returnBookResponse;
    }

    @Override
    public Book updateBook(int bookId, UpdateBookRequest updateBookRequest) {
        String title = updateBookRequest.getTitle();
        String author = updateBookRequest.getAuthor();
        String genre = updateBookRequest.getGenre();
        String availabilityStatus = updateBookRequest.getAvailabilityStatus().toUpperCase();
        Book book = bookRepositoryService.updateBook(bookId, title, author, genre, availabilityStatus);
        return book;
    }

    @Override
    public GetAllBooksResponse findAllBooks() {
        List<Book> books = bookRepositoryService.findAllBooks();
        GetAllBooksResponse getAllBooksResponse = new GetAllBooksResponse(books);
        return getAllBooksResponse;
    }

    @Override
    public String deleteBook(int bookId) {
        String response = "Successfully deleted book with ID: " + String.valueOf(bookId);
        bookRepositoryService.deleteBook(bookId);
        return response;
    }
    
}
