package com.java.brahminassignment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java.brahminassignment.dto.AccountDto;

@Repository
public class AccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<AccountDto> listAccountDetails() {
		List<AccountDto> accountList = jdbcTemplate.query("Select * FROM account", new RowMapper<AccountDto>(){
			@Override
			public AccountDto mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new AccountDto(rs.getInt("ID"),rs.getString("account_type"),rs.getString("account_number"));
			}
		});

		return accountList;
	}


}