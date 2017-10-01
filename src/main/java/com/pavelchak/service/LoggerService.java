package com.pavelchak.service;

import com.pavelchak.Repository.LoggerRepository;
import com.pavelchak.domain.LoggerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LoggerService {
    @Autowired
    LoggerRepository loggerRepository;

    public List<LoggerEntity> getAllLogger(){
        return loggerRepository.findAll();
    }

    public List<LoggerEntity> getLoggerFilterBySurname(String like){
        return loggerRepository.findByPersonLike(like+"%");
    }


}
