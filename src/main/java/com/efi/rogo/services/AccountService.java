package com.efi.rogo.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.efi.rogo.dao.AccountsDAO;
import com.efi.rogo.entity.Account;
import com.efi.rogo.entity.Contact;

@Component
public class AccountService {
	@Autowired
	private AccountsDAO accountsDao;

	public List<Account> getAllAccounts() {
		return accountsDao.getAllAccounts();
	}

	/*public Account getAccount(String accountName) {

	}*/
	
	
	public void addAccount(Account acc)
	{
		int maxModelBaseId = accountsDao.getMaxModelBaseId();
		//maxModelBaseId++;
		accountsDao.addModelBase(maxModelBaseId);
		
		int seqvalue = getPrefSeqValue("account");
		
		acc.setId(maxModelBaseId);
		acc.setAccountId(String.valueOf(seqvalue));
		int accountId = accountsDao.addAccount(acc);
		
		/*maxModelBaseId++;
		accountsDao.addModelBase(maxModelBaseId);
		
		Contact contact = acc.getContact();
		contact.setId(maxModelBaseId);
		contact.setParentAccount(accountId);
		accountsDao.addContact(contact);*/
	}
	
	public int getPrefSeqValue(String colName)
	{
		int seqVal =  accountsDao.getPrefSeqValue(colName);
		
		return ++seqVal;
	}
	
	public void addContact(Contact contact)
	{
		
	}
}
