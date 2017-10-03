package com.pavelchak.service;

import com.pavelchak.Repository.*;
import com.pavelchak.domain.*;
import com.pavelchak.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
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

    @Transactional
    public void createPerson(PersonEntity personEntity, Long city_id) throws NoSuchCityException {
        if(city_id>0) {
            CityEntity cityEntity = cityRepository.findOne(city_id);
            if (cityEntity == null) throw new NoSuchCityException();
            personEntity.setCity(cityEntity);
        }
        personRepository.save(personEntity);
    }

    @Transactional
    public void updatePerson(PersonEntity uPersonEntity, Long person_id,  Long city_id) throws NoSuchCityException, NoSuchPersonException {
        CityEntity cityEntity = cityRepository.findOne(city_id);
        if(city_id>0) {
            if (cityEntity == null) throw new NoSuchCityException();
        }
        PersonEntity personEntity = personRepository.findOne(person_id);
        if(personEntity==null) throw new NoSuchPersonException();
        //update
        personEntity.setSurname(uPersonEntity.getSurname());
        personEntity.setName(uPersonEntity.getName());
        personEntity.setEmail(uPersonEntity.getEmail());
        if(city_id>0) personEntity.setCity(cityEntity);
        else          personEntity.setCity(null);
        personEntity.setStreet(uPersonEntity.getStreet());
        personEntity.setApartment(uPersonEntity.getApartment());
        personRepository.save(personEntity);
    }

    @Transactional
    public void deletePerson(Long person_id) throws NoSuchPersonException, ExistsBooksForPersonException {
        PersonEntity personEntity = personRepository.findOne(person_id);
        if(personEntity==null) throw new NoSuchPersonException();
        if(personEntity.getBooks().size()!=0)  throw new ExistsBooksForPersonException();
        personRepository.delete(personEntity);
    }

    @Transactional
    public void addBookForPerson(Long person_id, Long book_id)
            throws NoSuchPersonException, NoSuchBookException, AlreadyExistsBookInPersonException, BookAbsentException {
        PersonEntity personEntity = personRepository.findOne(person_id);
        if(personEntity==null) throw new NoSuchPersonException();
        BookEntity bookEntity = bookRepository.findOne(book_id);
        if(bookEntity==null) throw new NoSuchBookException();
        if(personEntity.getBooks().contains(bookEntity)==true ) throw new AlreadyExistsBookInPersonException();
        if( bookEntity.getAmount()<=bookEntity.getPersons().size() ) throw new BookAbsentException();
        personEntity.getBooks().add(bookEntity);
        personRepository.save(personEntity);
    }

    @Transactional
    public void removeBookForPerson(Long person_id, Long book_id)
            throws NoSuchPersonException, NoSuchBookException, PersonHasNotBookException {
        PersonEntity personEntity = personRepository.findOne(person_id);
        if(personEntity==null) throw new NoSuchPersonException();
        BookEntity bookEntity = bookRepository.findOne(book_id);
        if(bookEntity==null) throw new NoSuchBookException();
        if(personEntity.getBooks().contains(bookEntity)==false ) throw new PersonHasNotBookException();
        personEntity.getBooks().remove(bookEntity);
        personRepository.save(personEntity);
    }




}
