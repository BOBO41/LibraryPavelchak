package com.pavelchak.DTO.impl;

import com.pavelchak.DTO.DTO;
import com.pavelchak.domain.CityEntity;
import org.springframework.hateoas.Link;

public class CitiesDTO extends DTO<CityEntity> {
    public CitiesDTO(CityEntity city, Link link) {
        super(city, link);
    }

    public Long getCityId() { return getEntity().getId(); }

    public String getCity() {
        return getEntity().getCity();
    }
}
