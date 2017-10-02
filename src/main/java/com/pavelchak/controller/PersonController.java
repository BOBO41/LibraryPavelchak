package com.pavelchak.controller;

import com.pavelchak.DTO.DTOBuilder;
import com.pavelchak.DTO.impl.CitiesDTO;
import com.pavelchak.domain.CityEntity;
import com.pavelchak.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping(value = "/api/persons/{city_id}")
    public ResponseEntity<String> getAllPersonByCityID(@PathVariable Long city_id) {

        return new ResponseEntity<>("ddd", HttpStatus.OK);

//        List<CityEntity> cityList = cityService.getAllCity();
//        Link link = linkTo(methodOn(CityController.class).getAllCity()).withSelfRel();
//        List<CitiesDTO> cities = DTOBuilder.buildDtoListForCollection(cityList, CitiesDTO.class, link);
//        return new ResponseEntity<>(cities, HttpStatus.OK);

    }
}
