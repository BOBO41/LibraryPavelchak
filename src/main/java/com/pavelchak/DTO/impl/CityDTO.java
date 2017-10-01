package com.pavelchak.DTO.impl;

import com.pavelchak.DTO.DTO;
import com.pavelchak.domain.CityEntity;
import org.springframework.hateoas.Link;

public class CityDTO extends DTO<CityEntity> {
    public CityDTO(CityEntity city, Link link) {
        super(city, link);
    }

    public Long getCityId() { return getEntity().getId(); }

    public String getCity() {
        return getEntity().getCity();
    }
}
