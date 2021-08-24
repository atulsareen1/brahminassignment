package com.java.brahminassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.java.brahminassignment.dto.StatementDto;
import com.java.brahminassignment.service.StatementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/statement")
@Slf4j
public class StatementController {
	
	@Autowired
	private StatementService statementService;
	
	@GetMapping("/list")
    public ResponseEntity<?> listStatements(@RequestParam("accountId") String accountId) {
        log.info("Inside listStatements method of Statement Controller with accountId:"+accountId);
        if (accountId == null || "".equals(accountId) || "undefined".equals(accountId)) {
			log.error("Incorrect details found for accountId:"+ accountId);
			return new ResponseEntity<BadRequest>(HttpStatus.BAD_REQUEST);
		}
        return ResponseEntity.ok(statementService.listStatement());
    }
	
	@GetMapping("/findByDate")
	public List<StatementDto> findStatementByDate(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate){
		log.info("Inside findStatementByDate method of Statement Controller with fromDate:"+fromDate+" toDate:"+toDate);
		
		return null;
	}
	
	@GetMapping("/findByAmount")
	public List<StatementDto> findStatementByAmount(@RequestParam("fromAmount") String fromAmount, @RequestParam("toAmount") String toAmount){
		log.info("Inside findStatementByAmount method of Statement Controller with fromAmount:"+fromAmount+" toAmount:"+toAmount);
	
		return null;
	}
}
