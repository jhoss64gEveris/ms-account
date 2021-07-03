package com.everis.msaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.msaccount.business.AccountBusiness;
import com.everis.msaccount.domain.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/account")
public class AccountController {

	@Autowired
	AccountBusiness business;    
	
    @GetMapping(path= "/findByNumberAccount/{numberAccount}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Account> findByNumberAccount(@PathVariable("numberAccount") final String numberAccount) {		
    	return business.findByNumberAccount(numberAccount);
    }
    
	@PostMapping(value = "/create")
	@ResponseStatus(value = HttpStatus.CREATED)
    public Mono<Account> createAccount(@RequestBody Account account) {
		return business.createAccount(account);
    }
	
	@GetMapping(path= "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
    public Flux<Account> findAll() {		
    	return business.findAll();
    }
	
	@PostMapping(value = "/cretaeAll")
	@ResponseStatus(value = HttpStatus.CREATED)
    public Flux<Account> createdAccountAll(@RequestBody Iterable<Account> accounts) {
		return business.saveAll(accounts);
    }
	
	@PutMapping(value = "/updateAccount/{numberAccount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Account> updateAccount(@PathVariable("numberAccount") final String numberAccount, @RequestBody Account account){
		return business.updateAccount(numberAccount, account);
	}
	
	@DeleteMapping(value = "/deleteAccount/{numberAccount}")
	public Mono<Void> deleteAccount(@PathVariable("numberAccount") final String numberAccount) {
		return business.deleteByAccount(numberAccount);
	}
}