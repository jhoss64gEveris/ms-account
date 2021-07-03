package com.everis.msaccount.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.msaccount.domain.Account;
import com.everis.msaccount.repository.AccountCrudRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AccountBusiness {
	@Autowired
	AccountCrudRepository repository;

	public Mono<Account> createAccount(Account document) {
		return repository.save(document);
	}

	public Flux<Account> saveAll(Iterable<Account> accounts) {
		return repository.saveAll(accounts);
	}

	public Mono<Account> updateAccount(String numberAccount, Account account) {
		return repository.findByNumberAccount(numberAccount)
		.flatMap(dbAccount -> {
			dbAccount.setId(account.getId());
			dbAccount.setOwner(account.getOwner());
			dbAccount.setDate(account.getDate());
			return repository.save(dbAccount);
		});

	}

	public Flux<Account> findAll() {
		return repository.findAll();
	}

	public Mono<Account> findByNumberAccount(String numberAccount) {
		return repository.findByNumberAccount(numberAccount);
	}

	public Mono<Void> deleteByAccount(String numberAccount) {
		return repository.findByNumberAccount(numberAccount).flatMap(dbAccount -> {
			log.info("Deleting account number: " + dbAccount.getNumberAccount());
			return repository.deleteById(dbAccount.getId());
		});
	}

}
