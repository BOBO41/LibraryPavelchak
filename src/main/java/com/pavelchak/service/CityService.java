package com.pavelchak.service;

import com.pavelchak.Repository.CityRepository;
import com.pavelchak.domain.CityEntity;
import com.pavelchak.exceptions.NoSuchCityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void createCity(CityEntity cityEntity){
        cityRepository.save(cityEntity);
    }

    @Transactional
    public void updateCity(CityEntity uCityEntity, Long city_id) throws NoSuchCityException {
        CityEntity cityEntity=cityRepository.findOne(city_id);
        if(cityEntity==null) throw new NoSuchCityException();
        cityEntity.setCity(uCityEntity.getCity());
        cityRepository.save(cityEntity);
    }

    @Transactional
    public void deleteCity(Long city_id) throws NoSuchCityException {
        CityEntity cityEntity=cityRepository.findOne(city_id);
        if(cityEntity==null) throw new NoSuchCityException();
        cityRepository.delete(cityEntity);
    }

}
