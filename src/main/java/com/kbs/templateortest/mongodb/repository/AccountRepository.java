package com.kbs.templateortest.mongodb.repository;

import com.kbs.templateortest.mongodb.document.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

/* Spring Data에서 제공되는 keyword 기반의 query method를 사용 가능 */
public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> findByUsername(String username);

    List<Account> findByRegTimeGreaterThan(LocalDateTime regTime);

    List<Account> findByUsernameIn(String[] names);
}
