package com.pavelchak.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDCity", nullable = false)
    private Long idCity;

    @Column(name = "City", nullable = false, length = 25)
    private String city;

    @OneToMany(mappedBy = "cityByIdCity")
    private Collection<PersonEntity> peopleByIdCity;

    public Long getIdCity() {
        return idCity;
    }
    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public Collection<PersonEntity> getPeopleByIdCity() {
        return peopleByIdCity;
    }
    public void setPeopleByIdCity(Collection<PersonEntity> peopleByIdCity) {
        this.peopleByIdCity = peopleByIdCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (idCity != null ? !idCity.equals(that.idCity) : that.idCity != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCity != null ? idCity.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }


}
