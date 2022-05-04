package com.kbs.templateortest.mongodb;

import com.kbs.templateortest.mongodb.document.Account;
import com.kbs.templateortest.mongodb.repository.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;

@SpringBootTest
public class MongodbTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    @DisplayName("MongoRepository 인터페이스를 활용한 테스트")
    public void repositoryTest() {

        Account account = Account.builder()
                .username("KimTest")
                .email("test@test.com")
                .phoneNumber("010-1234-5678")
                .regTime(LocalDateTime.now().withNano(0))
                .build();
        Account saveAccount = accountRepository.save(account);
        System.out.println("[[[saveAccount = " + saveAccount);

        Account findAccount = accountRepository.findById(saveAccount.getId()).get();
        System.out.println("[[[findAccount = " + findAccount);

        // 객체 내용 비교
        Assertions.assertThat(saveAccount).isEqualTo(findAccount);
    }

    @Test
    @DisplayName("MongoTemplate을 활용한 테스트")
    public void TemplateTest(){
        Account account = Account.builder()
                .username("KimTest")
                .email("test@test.com")
                .phoneNumber("010-1234-5678")
                .regTime(LocalDateTime.now().withNano(0))
                .build();

        Account insertAccount = mongoTemplate.insert(account);
        System.out.println("[[[insertAccount = " + insertAccount);

        Account findAccount = mongoTemplate.findById(insertAccount.getId(), Account.class);
        System.out.println("[[[findAccount = " + findAccount);

        // 객체 내용 비교
        Assertions.assertThat(insertAccount).isEqualTo(findAccount);
    }
}
