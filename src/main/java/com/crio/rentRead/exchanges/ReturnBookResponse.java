package com.crio.rentRead.exchanges;

import java.util.List;

import com.crio.rentRead.dto.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnBookResponse {
    private String firstName;
    private String lastName;
    private List<Book> rentedBooks;
}
