package com.java.brahminassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.brahminassignment.dto.StatementDto;
import com.java.brahminassignment.repository.StatementRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StatementService {
	@Autowired
	private StatementRepository statementRepository;
	
	public List<StatementDto> listStatement() {
        log.info("Inside listStatement of Statement Service");
        return statementRepository.listStatementDetails();
    }
}
