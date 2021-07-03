package com.everis.msaccount.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.everis.msaccount.domain.Account;

import reactor.core.publisher.Mono;

@Repository
public interface AccountCrudRepository extends ReactiveMongoRepository<Account, String> {

	public Mono<Account> findByNumberAccount(String numberAccount);

	public Mono<Void> deleteByNumberAccount(String numberAccount);

}
