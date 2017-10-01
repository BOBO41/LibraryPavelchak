package com.pavelchak.controller;

import com.pavelchak.domain.LoggerEntity;
import com.pavelchak.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class LoggerController {
    @Autowired
    LoggerService loggerService;

    @GetMapping(value = "/api/logger")
    public ResponseEntity<List<LoggerEntity>> getAllLogger() {
        List<LoggerEntity> loggerEntities = loggerService.getAllLogger();
        return new ResponseEntity<List<LoggerEntity>>(loggerEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/api/logger/{surname}")
    public ResponseEntity<List<LoggerEntity>> getLoggerFilterBySurname(@PathVariable String surname) {
        List<LoggerEntity> loggerEntities = loggerService.getLoggerFilterBySurname(surname);
        return new ResponseEntity<List<LoggerEntity>>(loggerEntities, HttpStatus.OK);
    }
}
