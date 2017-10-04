package com.pavelchak.controller;

import com.pavelchak.DTO.DTOBuilder;
import com.pavelchak.DTO.impl.CityDTO;
import com.pavelchak.domain.CityEntity;
import com.pavelchak.exceptions.ExistsPersonsForCityException;
import com.pavelchak.exceptions.NoSuchCityException;
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
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<CityEntity> cityList = cityService.getAllCity();
        Link link = linkTo(methodOn(CityController.class).getAllCities()).withSelfRel();
        List<CityDTO> cities = DTOBuilder.buildDtoListForCollection(cityList, CityDTO.class, link);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(value = "/api/city/{city_id}")
    public ResponseEntity<CityDTO> getCity(@PathVariable Long city_id) throws NoSuchCityException {
        CityEntity city = cityService.getCity(city_id);
        Link link = linkTo(methodOn(CityController.class).getCity(city_id)).withSelfRel();
        CityDTO cityDTO = DTOBuilder.buildDtoForEntity(city,CityDTO.class, link);
        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/city/{city_id}")
    public  ResponseEntity<CityDTO> addCity(@RequestBody CityEntity newCityEntity) throws NoSuchCityException {
        cityService.createCity(newCityEntity);
        Link link = linkTo(methodOn(CityController.class).getCity(newCityEntity.getId())).withSelfRel();
        CityDTO cityDTO = DTOBuilder.buildDtoForEntity(newCityEntity,CityDTO.class, link);
        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/city/{city_id}")
    public  ResponseEntity<CityDTO> updateCity(@RequestBody CityEntity ucityEntity, @PathVariable Long city_id) throws NoSuchCityException {
        cityService.updateCity(ucityEntity, city_id);
        CityEntity cityEntity = cityService.getCity(city_id);
        Link link = linkTo(methodOn(CityController.class).getCity(city_id)).withSelfRel();
        CityDTO cityDTO = DTOBuilder.buildDtoForEntity(cityEntity,CityDTO.class, link);
        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/city/{city_id}")
    public  ResponseEntity deleteCity(@PathVariable Long city_id) throws NoSuchCityException, ExistsPersonsForCityException {
        cityService.deleteCity(city_id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
