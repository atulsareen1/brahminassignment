package com.java.brahminassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.brahminassignment.dto.AccountDto;
import com.java.brahminassignment.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public List<AccountDto> listAccounts() {
        log.info("Inside listAccounts of Account Service");
        return accountRepository.listAccountDetails();
    }
}
