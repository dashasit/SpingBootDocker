package com.efi.rogo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.efi.rogo.entity.Account;
import com.efi.rogo.entity.Contact;
import com.efi.rogo.services.AccountService;

@Controller
public class AccountsContoller {
	
	private static final Logger log = Logger.getLogger(AccountsContoller.class);

	@Autowired
	private AccountService accountService;

	@GetMapping("/allAccounts")
	public List<Account> getAllAccounts() {
		List<Account> accounts = null;
		try {
			accounts = accountService.getAllAccounts();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return accounts;
	}
	
	@GetMapping("/account")
	public Account getAccount(String accountName) {
		Account account = null;
		try {
			//account = accountService.getAccount(accountName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return account;
	}
	
	@PostMapping("/account/add")
	public ResponseEntity<Account> addAccount(@RequestBody Account acc) {
		
		log.debug("Add account triggered.");
		
		try {
			accountService.addAccount(acc);
			
			return new ResponseEntity<Account>(acc, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error in AccountsContorller.addAccount ");
			
			e.printStackTrace();
		}
		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/contact/add")
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
		try {
			accountService.addContact(contact);
			
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
	}
}
