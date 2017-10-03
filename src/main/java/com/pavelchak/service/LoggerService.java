package com.pavelchak.service;

import com.pavelchak.Repository.LoggerRepository;
import com.pavelchak.domain.LoggerEntity;
import com.pavelchak.exceptions.NoSuchLogException;
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

    public LoggerEntity getLog(Long log_id) throws NoSuchLogException {
        LoggerEntity loggerEntity=loggerRepository.findOne(log_id);
        if(loggerEntity==null) throw new NoSuchLogException();
        return loggerEntity;
    }

}
