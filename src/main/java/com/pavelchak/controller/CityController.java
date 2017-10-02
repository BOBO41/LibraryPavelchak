package com.pavelchak.controller;

import com.pavelchak.DTO.DTOBuilder;
import com.pavelchak.DTO.impl.CitiesDTO;
import com.pavelchak.DTO.impl.CityDTO;
import com.pavelchak.domain.CityEntity;
import com.pavelchak.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping(value = "/api/city")
    public ResponseEntity<List<CitiesDTO>> getAllCity() {
        List<CityEntity> cityList = cityService.getAllCity();
        Link link = linkTo(methodOn(CityController.class).getAllCity()).withSelfRel();
        List<CitiesDTO> cities = DTOBuilder.buildDtoListForCollection(cityList, CitiesDTO.class, link);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

//    @GetMapping(value = "/api/city/{city_id}")
//    public ResponseEntity<CityDTO> getCityByIDCity(@PathVariable Long city_id) {
//
//        CityEntity cityList = cityService.getCity(city_id);
//
//
//
//
//
//        Link link = linkTo(methodOn(CityController.class).getAllCity()).withSelfRel();
//        CityDTO cities = DTOBuilder.buildDtoListForCollection(cityList, CityDTO.class, link);
//        return new ResponseEntity<>(cities, HttpStatus.OK);
//
//
//
//
//
//    }


}
