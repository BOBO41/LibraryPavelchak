package com.pavelchak.controller;

import com.pavelchak.DTO.impl.MessageDTO;
import com.pavelchak.exceptions.NoSuchBookException;
import com.pavelchak.exceptions.NoSuchCityException;
import com.pavelchak.exceptions.NoSuchPersonException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchCityException.class)
    ResponseEntity<MessageDTO> handleNoSushCityException(){
        return new ResponseEntity<MessageDTO>(new MessageDTO("Such city not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchPersonException.class)
    ResponseEntity<MessageDTO> handleNoSushPersonException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Such person not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchBookException.class)
    ResponseEntity<MessageDTO> handleNoSushBookException() {
        return new ResponseEntity<MessageDTO>(new MessageDTO("Such book not found"), HttpStatus.NOT_FOUND);
    }

}
