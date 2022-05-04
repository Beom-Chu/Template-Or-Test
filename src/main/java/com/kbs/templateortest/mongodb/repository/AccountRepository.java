package com.kbs.templateortest.mongodb.repository;

import com.kbs.templateortest.mongodb.document.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
