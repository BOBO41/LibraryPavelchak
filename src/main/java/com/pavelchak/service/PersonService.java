package com.pavelchak.service;

import com.pavelchak.Repository.*;
import com.pavelchak.domain.*;
import com.pavelchak.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    BookRepository bookRepository;

    public List<PersonEntity> getPersonByCityId(Long city_id) throws NoSuchCityException {
        CityEntity cityEntity=cityRepository.findOne(city_id);
        if(cityEntity==null)throw new NoSuchCityException();
        return cityEntity.getPersons();
    }

    public PersonEntity getPerson(Long person_id) throws NoSuchPersonException {
        PersonEntity personEntity = personRepository.findOne(person_id);
        if(personEntity==null) throw new NoSuchPersonException();
        return personEntity;
    }

    public List<PersonEntity> getAllPersons(){
        return personRepository.findAll();
    }

    public Set<PersonEntity> getPersonsByBookId(Long book_id) throws NoSuchBookException {
        BookEntity bookEntity = bookRepository.findOne(book_id);
        if(bookEntity==null) throw new NoSuchBookException();
        return bookEntity.getPersons();
    }

}
