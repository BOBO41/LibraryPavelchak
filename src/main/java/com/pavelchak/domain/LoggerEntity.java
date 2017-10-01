package com.pavelchak.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "logger")
public class LoggerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDLogger", nullable = false)
    private Long idLogger;

    @Column(name = "Person", nullable = false, length = 50)
    private String person;

    @Column(name = "Book", nullable = false, length = 90)
    private String book;

    @Column(name = "Action", nullable = false, length = 10)
    private String action;

    @Column(name = "Time_Stamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    @Column(name = "User", nullable = true, length = 50)
    private String user;

    public Long getIdLogger() {
        return idLogger;
    }
    public void setIdLogger(Long idLogger) {
        this.idLogger = idLogger;
    }

    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }

    public String getBook() {
        return book;
    }
    public void setBook(String book) {
        this.book = book;
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoggerEntity that = (LoggerEntity) o;

        if (idLogger != null ? !idLogger.equals(that.idLogger) : that.idLogger != null) return false;
        if (person != null ? !person.equals(that.person) : that.person != null) return false;
        if (book != null ? !book.equals(that.book) : that.book != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLogger != null ? idLogger.hashCode() : 0;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
