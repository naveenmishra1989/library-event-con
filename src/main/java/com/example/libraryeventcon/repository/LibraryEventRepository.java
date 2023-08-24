package com.example.libraryeventcon.repository;

import com.example.libraryeventcon.domain.LibraryEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryEventRepository extends JpaRepository<LibraryEvent,Integer> {
}
