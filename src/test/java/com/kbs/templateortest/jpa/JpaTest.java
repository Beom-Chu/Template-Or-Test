package com.kbs.templateortest.jpa;

import com.kbs.templateortest.jpa.entity.TestEntity;
import com.kbs.templateortest.jpa.repository.TestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
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
        te.setDate(LocalDate.now().toString());
        te.setDateTime(now);

        System.out.println("[[[te = " + te);

        TestEntity save = testRepository.save(te);

        System.out.println("[[[save = " + save);


        List<TestEntity> byDateTimeGreaterThanEqual = testRepository.findByDateTimeGreaterThanEqual(now);

        System.out.println("[[[byDateTimeGreaterThanEqual = " + byDateTimeGreaterThanEqual);
    }

    @Test
    @Transactional
    @DisplayName("null 객체 delete 테스트")
    public void testDelete() {

        TestEntity n1 = testRepository.findTop1ByName("n1");

        System.out.println("[[[n1 = " + n1);

        testRepository.delete(n1);
    }

    @Test
    @Transactional
    @DisplayName("빈 배열 객체 delete all 테스트")
    public void testDeleteAll() {

        List<TestEntity> testEntities = testRepository.findByDateTimeGreaterThanEqual(LocalDateTime.now());

        System.out.println("[[[testEntities = " + testEntities);

        testRepository.deleteAll(testEntities);
    }

}
