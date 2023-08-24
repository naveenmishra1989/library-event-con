package com.example.libraryeventcon.repository;

import com.example.libraryeventcon.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
