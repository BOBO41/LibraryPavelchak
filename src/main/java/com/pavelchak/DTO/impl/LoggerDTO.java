package com.pavelchak.DTO.impl;

import com.pavelchak.DTO.DTO;
import com.pavelchak.controller.PersonController;
import com.pavelchak.domain.BookEntity;
import com.pavelchak.domain.LoggerEntity;
import com.pavelchak.exceptions.NoSuchBookException;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class LoggerDTO extends DTO<LoggerEntity> {
    public LoggerDTO(LoggerEntity loggerEntity, Link link) {
        super(loggerEntity, link);
    }

    public Long getLoggerId() {
        return getEntity().getId();
    }

    public String getPerson() {
        return getEntity().getPerson();
    }

    public String getBook() {
        return getEntity().getBook();
    }

    public String getAction() {
        return getEntity().getAction();
    }

    public String getUser() {
        return getEntity().getUser();
    }

    public String getTime() {
        return getEntity().getTimeStamp().toString();
    }
}
