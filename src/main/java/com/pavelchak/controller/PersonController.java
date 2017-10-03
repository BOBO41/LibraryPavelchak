package com.pavelchak.controller;

import com.pavelchak.DTO.DTOBuilder;
import com.pavelchak.DTO.impl.PersonDTO;
import com.pavelchak.domain.PersonEntity;
import com.pavelchak.exceptions.*;
import com.pavelchak.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping(value = "/api/person/city/{city_id}")
    public ResponseEntity<List<PersonDTO>> getPersonsByCityID(@PathVariable Long city_id) throws NoSuchCityException, NoSuchPersonException {
        List<PersonEntity> personList = personService.getPersonByCityId(city_id);

        Link link = linkTo(methodOn(PersonController.class).getAllPersons()).withSelfRel();

        List<PersonDTO> personDTO = DTOBuilder.buildDtoListForCollection(personList, PersonDTO.class, link);
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/person/{person_id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long person_id) throws NoSuchPersonException {
        PersonEntity person = personService.getPerson(person_id);
        Link link = linkTo(methodOn(PersonController.class).getPerson(person_id)).withSelfRel();
        PersonDTO personDTO = DTOBuilder.buildDtoForEntity(person, PersonDTO.class, link);
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/person")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonEntity> personList=personService.getAllPersons();
        Link link = linkTo(methodOn(PersonController.class).getAllPersons()).withSelfRel();
        List<PersonDTO> cities = DTOBuilder.buildDtoListForCollection(personList, PersonDTO.class, link);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(value = "/api/person/book/{book_id}")
    public ResponseEntity<List<PersonDTO>> getPersonsByBookID(@PathVariable Long book_id) throws NoSuchBookException {
        Set<PersonEntity> personList = personService.getPersonsByBookId(book_id);
        Link link = linkTo(methodOn(PersonController.class).getAllPersons()).withSelfRel();
        List<PersonDTO> personDTO = DTOBuilder.buildDtoListForCollection(personList, PersonDTO.class, link);
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

}
