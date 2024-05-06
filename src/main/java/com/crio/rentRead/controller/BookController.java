package com.crio.rentRead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.rentRead.dto.Book;
import com.crio.rentRead.exchanges.CreateBookRequest;
import com.crio.rentRead.exchanges.GetAllBooksResponse;
import com.crio.rentRead.exchanges.RentBookResponse;
import com.crio.rentRead.exchanges.ReturnBookResponse;
import com.crio.rentRead.exchanges.UpdateBookRequest;
import com.crio.rentRead.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(BookController.BOOK_API_ENDPOINT)
public class BookController {
    public static final String BOOK_API_ENDPOINT = "/books";

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        Book book = bookService.createBook(createBookRequest);
        return ResponseEntity.ok().body(book);
    }

    // @AuthenticationPrincipal: This annotation provides the details of the currently authenticated user
    @PostMapping("/{bookId}/rent") 
    public ResponseEntity<RentBookResponse> rentBook(@PathVariable (value = "bookId") int bookId, @AuthenticationPrincipal UserDetails userDetails) {
        RentBookResponse rentBookResponse = bookService.rentBook(bookId, userDetails);
        return ResponseEntity.ok().body(rentBookResponse);
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<ReturnBookResponse> returnBook(@PathVariable (value = "bookId") int bookId, @AuthenticationPrincipal UserDetails userDetails) {
        ReturnBookResponse returnBookResponse = bookService.returnBook(bookId, userDetails);
        return ResponseEntity.ok().body(returnBookResponse);
    }

    @GetMapping
    public ResponseEntity<GetAllBooksResponse> getAllBooks() {
        GetAllBooksResponse getAllBooksResponse = bookService.findAllBooks();
        return ResponseEntity.ok().body(getAllBooksResponse);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "bookId") int bookId, @Valid @RequestBody UpdateBookRequest updateBookRequest) {
        Book book = bookService.updateBook(bookId, updateBookRequest);
        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "bookId") int bookId) {
        String response = bookService.deleteBook(bookId);
        return ResponseEntity.ok().body(response);
    }

}
