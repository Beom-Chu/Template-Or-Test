package com.kbs.templateortest.jpa;

import com.kbs.templateortest.jpa.entity.TestEntity;
import com.kbs.templateortest.jpa.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class JpaTest {

    @Autowired
    private TestRepository testRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void test() {

        LocalDateTime now = LocalDateTime.now().withNano(0);

        TestEntity te = new TestEntity();
        te.setName("n1");
        te.setDate(LocalDate.now());
        te.setDateTime(now);

        System.out.println("[[[te = " + te);

        TestEntity save = testRepository.save(te);

        System.out.println("[[[save = " + save);


        TestEntity byDateTimeGreaterThanEqual = testRepository.findByDateTimeGreaterThanEqual(now);

        System.out.println("[[[byDateTimeGreaterThanEqual = " + byDateTimeGreaterThanEqual);
    }

    @Test
    @Transactional
    public void test2() {

        LocalDateTime now = LocalDateTime.now();

    }
}
