package com.pavelchak.service;

import com.pavelchak.Repository.BookRepository;
import com.pavelchak.Repository.PersonRepository;
import com.pavelchak.domain.BookEntity;
import com.pavelchak.domain.PersonEntity;
import com.pavelchak.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void createBook(BookEntity bookEntity)  {
        bookRepository.save(bookEntity);
    }

    @Transactional
    public void updateBook(BookEntity uBookEntity, Long book_id) throws NoSuchBookException {
        BookEntity bookEntity = bookRepository.findOne(book_id);
        if(bookEntity==null) throw new NoSuchBookException();
        //update
        bookEntity.setBookName(uBookEntity.getBookName());
        bookEntity.setAuthor(uBookEntity.getAuthor());
        bookEntity.setPublisher(uBookEntity.getPublisher());
        bookEntity.setImprintYear(uBookEntity.getImprintYear());
        bookEntity.setAmount(uBookEntity.getAmount());
    }

    @Transactional
    public void deleteBook(Long book_id) throws NoSuchBookException, ExistsPersonForBookException {
        BookEntity bookEntity =bookRepository.findOne(book_id);
        if(bookEntity==null) throw new NoSuchBookException();
        if(bookEntity.getPersons().size()!=0) throw new ExistsPersonForBookException();
        bookRepository.delete(bookEntity);
    }

}
