package com.efi.rogo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.efi.rogo.entity.Account;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int arg1) throws SQLException 
	{
		Account acc = new Account();
		acc.setAccountId(rs.getString("accountid"));
		acc.setId(rs.getInt("id"));
		acc.setTitle(rs.getString("title"));
		
		return acc;
	}

}
