package com.pavelchak.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDBook", nullable = false)
    private Long idBook;

    @Column(name = "Book_Name", nullable = false, length = 45)
    private String bookName;

    @Column(name = "Author", nullable = false, length = 45)
    private String author;

    @Column(name = "Publisher", nullable = true, length = 50)
    private String publisher;

    @Column(name = "Imprint_Year", nullable = true)
    private Integer imprintYear;

    @Column(name = "Amount", nullable = false)
    private Integer amount;

    @ManyToMany(mappedBy = "books")
    private Set<PersonEntity> persons;

    public Long getIdBook() {
        return idBook;
    }
    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getImprintYear() {
        return imprintYear;
    }
    public void setImprintYear(Integer imprintYear) {
        this.imprintYear = imprintYear;
    }

    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<PersonEntity> getPersons() {
        return persons;
    }
    public void setPersons(Set<PersonEntity> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (idBook != null ? !idBook.equals(that.idBook) : that.idBook != null) return false;
        if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (publisher != null ? !publisher.equals(that.publisher) : that.publisher != null) return false;
        if (imprintYear != null ? !imprintYear.equals(that.imprintYear) : that.imprintYear != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBook != null ? idBook.hashCode() : 0;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (imprintYear != null ? imprintYear.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

}
