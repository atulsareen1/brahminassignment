package com.java.brahminassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.brahminassignment.dto.AccountDto;
import com.java.brahminassignment.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/list")
    public List<AccountDto> findAccounts() {
        log.info("Inside findAccounts method of Account Controller");
        return accountService.listAccounts();
    }

}
