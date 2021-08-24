package com.java.brahminassignment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java.brahminassignment.dto.StatementDto;
@Repository
public class StatementRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<StatementDto> listStatementDetails() {
		List<StatementDto> statementDetails = jdbcTemplate.query("Select * FROM statement", new RowMapper<StatementDto>(){
			@Override
			public StatementDto mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new StatementDto(rs.getInt("ID"),rs.getString("account_id"),rs.getString("datefield"),rs.getString("amount"));
			}
		});

		return statementDetails;
	}

}
