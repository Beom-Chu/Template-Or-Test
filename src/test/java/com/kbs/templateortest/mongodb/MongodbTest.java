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
import java.util.List;

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

    @Test
    @DisplayName("MongoRepository Custom Test")
    public void repositoryCustomTest() {

        List<Account> accounts = accountRepository.findByUsername("LeeTest");
        for(Account account : accounts) {
            System.out.println("[[[findByUsername = " + account);
        }

        LocalDateTime time = LocalDateTime.of(2022, 9, 1, 15, 44);
        System.out.println("[[[time = " + time);
        List<Account> accounts2 = accountRepository.findByRegTimeGreaterThan(time);
        for(Account account : accounts2) {
            System.out.println("[[[findByRegTimeGreaterThan = " + account);
        }

        List<Account> accounts3 = accountRepository.findByUsernameIn(new String[]{"LeeTest", "ParkTest"});
        for(Account account : accounts3) {
            System.out.println("[[[findByUsernameIn = " + account);
        }
    }

    @Test
    public void addTestDoc() {
        accountRepository.save(Account.builder()
                .username("KimTest")
                .email("testabc@test.com")
                .phoneNumber("010-1111-2222")
                .regTime(LocalDateTime.now().withNano(0))
                .build());
        accountRepository.save(Account.builder()
                .username("LeeTest")
                .email("testdef@test.com")
                .phoneNumber("010-3333-4444")
                .regTime(LocalDateTime.now().withNano(0))
                .build());
        accountRepository.save(Account.builder()
                .username("ParkTest")
                .email("testgfi@test.com")
                .phoneNumber("010-5555-6666")
                .regTime(LocalDateTime.now().withNano(0))
                .build());
    }

    @Test
    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
