package com.pavelchak.service;

import com.pavelchak.Repository.BookRepository;
import com.pavelchak.Repository.PersonRepository;
import com.pavelchak.domain.BookEntity;
import com.pavelchak.domain.CityEntity;
import com.pavelchak.domain.PersonEntity;
import com.pavelchak.exceptions.NoSuchBookException;
import com.pavelchak.exceptions.NoSuchCityException;
import com.pavelchak.exceptions.NoSuchPersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    PersonRepository personRepository;

    public Set<BookEntity> getBooksByPersonId(Long person_id) throws NoSuchPersonException {
        PersonEntity personEntity = personRepository.findOne(person_id);
        if(personEntity==null) throw new NoSuchPersonException();
        return personEntity.getBooks();
    }

    public BookEntity getBook(Long book_id) throws NoSuchBookException {
        BookEntity bookEntity=bookRepository.findOne(book_id);
        if(bookEntity==null) throw new NoSuchBookException();
        return bookEntity;
    }

    public List<BookEntity> getAllBooks(){
        return bookRepository.findAll();
    }
}
