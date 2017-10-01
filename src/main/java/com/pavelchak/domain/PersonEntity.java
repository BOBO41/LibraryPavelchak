package com.pavelchak.domain;

import com.pavelchak.DTO.EntityInterface;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "person")
public class PersonEntity implements EntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPerson", nullable = false)
    private Long id;

    @Column(name = "Surname", nullable = false, length = 25)
    private String surname;

    @Column(name = "Name", nullable = false, length = 25)
    private String name;

    @Column(name = "Email", nullable = true, length = 45)
    private String email;

    @Column(name = "Street", nullable = true, length = 30)
    private String street;

    @Column(name = "Apartment", nullable = true, length = 10)
    private String apartment;

    @ManyToOne
    @JoinColumn(name = "IDCity", referencedColumnName = "IDCity")
    private CityEntity cityByIdCity;

    @ManyToMany
    @JoinTable(name = "personbook",
            joinColumns = @JoinColumn(name = "IDPerson", referencedColumnName = "IDPerson", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "IDBook", referencedColumnName = "IDBook", nullable = false))
    private Set<BookEntity> books;

    PersonEntity(){}

    PersonEntity(String surname,String name,String email,String street,String apartment){
        this.surname=surname;
        this.name=name;
        this.email=email;
        this.street=street;
        this.apartment=apartment;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long idPerson) {
        this.id = idPerson;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartment() {
        return apartment;
    }
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public CityEntity getCityByIdCity() {
        return cityByIdCity;
    }

    public void setCityByIdCity(CityEntity cityByIdCity) {
        this.cityByIdCity = cityByIdCity;
    }

    public Set<BookEntity> getBooks() {
        return books;
    }
    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (apartment != null ? !apartment.equals(that.apartment) : that.apartment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
        return result;
    }

}
