package com.pavelchak.service;

import com.pavelchak.Repository.CityRepository;
import com.pavelchak.domain.CityEntity;
import com.pavelchak.exceptions.NoSuchCityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;
    private boolean ascending;

    public List<CityEntity> getAllCity(){
        return cityRepository.findAll();
    }

    public CityEntity getCity(Long city_id) throws NoSuchCityException {
        CityEntity cityEntity=cityRepository.findOne(city_id);
        if(cityEntity==null) throw new NoSuchCityException();
        return cityEntity;
    }
}
