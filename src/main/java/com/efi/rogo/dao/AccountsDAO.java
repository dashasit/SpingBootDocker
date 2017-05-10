package com.efi.rogo.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.efi.rogo.entity.Account;
import com.efi.rogo.entity.Contact;
import com.efi.rogo.rowmapper.AccountRowMapper;

@Repository
public class AccountsDAO extends JdbcDaoSupport {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void initialize() {
		setJdbcTemplate(jdbcTemplate);
	}

	public List<Account> getAllAccounts() {
		String query = "select id,accountid,title from account where accountid='10'";
		List<Account> accounts = jdbcTemplate.query(query,
				new AccountRowMapper());

		return accounts;
	}

	public int getMaxModelBaseId() {
		String query = "select nextval('modelbase_id_seq')";
		Integer maxId = (Integer) jdbcTemplate.queryForObject(query,
				Integer.class);

		return maxId.intValue();
	}

	public int getPrefSeqValue(String colName) {
		String query = "select COL_NAME from preferencessequencevalues";
		query = query.replace("COL_NAME", colName) ;
		
		Integer maxId = (Integer) jdbcTemplate.queryForObject(query,
				Integer.class);
		
		return maxId.intValue();
	}

	@Transactional
	public int addModelBase(int id) {
		String insert = "insert into modelbase(id, created, isdeleted, modified) values(?,?,?,?)";

		return jdbcTemplate.update(insert, id,
				new Timestamp(new Date().getTime()), false, new Timestamp(
						new Date().getTime()));
	}

	@Transactional
	public int addAccount(Account acc) {
		String insert = "insert into account(id, accountid, title, status, type, walkin, isdeleted) values(?,?,?,?,?,?,?)";

		return jdbcTemplate.update(insert, acc.getId(), acc.getAccountId(),
				acc.getTitle(), acc.getStatus(), acc.getType(), acc.isWalkIn(),
				acc.isIsdeleted());
	}

	public int addContact(Contact contact) {
		String insert = "insert into contact(id, parentaccount_id, webaccountname, tempflag) values(?,?,?,?)";

		return jdbcTemplate.update(insert, contact.getId(),
				contact.getParentAccount(), contact.getWebAccountName(),
				contact.isTempFlag());
	}

}
