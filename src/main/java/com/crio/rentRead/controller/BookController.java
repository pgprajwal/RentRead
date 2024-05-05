package com.crio.rentRead.controller;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping(BookController.BOOK_API_ENDPOINT)
public class BookController {
    public static final String BOOK_API_ENDPOINT = "/books";

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        return null;
    }

    // @AuthenticationPrincipal: This annotation provides the details of the currently authenticated user
    @PostMapping("/{bookId}/rent") 
    public ResponseEntity<RentBookResponse> rentBook(@PathVariable (value = "bookId") int bookId, @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<ReturnBookResponse> returnBook(@PathVariable (value = "bookId") int bookId, @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

    @GetMapping
    public ResponseEntity<GetAllBooksResponse> getAllBooks() {
        return null;
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "bookId") int bookId, @Valid @RequestBody UpdateBookRequest updateBookRequest) {
        return null;
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "bookId") int bookId) {
        return null;
    }

}
