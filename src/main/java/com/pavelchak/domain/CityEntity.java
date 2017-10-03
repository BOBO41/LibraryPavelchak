package com.pavelchak.domain;

import com.pavelchak.DTO.EntityInterface;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class CityEntity implements EntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDCity", nullable = false)
    private Long id;

    @Column(name = "City", nullable = false, length = 25)
    private String city;

    @OneToMany(mappedBy = "city")
    private List<PersonEntity> persons;

    CityEntity(){}

    CityEntity(String city){
        this.city=city;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long idCity) {
        this.id = idCity;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public List<PersonEntity> getPersons() {
        return persons;
    }
    public void setPersons(List<PersonEntity> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }


}
