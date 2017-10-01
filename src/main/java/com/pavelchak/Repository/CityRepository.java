package com.pavelchak.Repository;

import com.pavelchak.domain.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
    //List<CityEntity> findByCityOrderByCityAsc();

}
