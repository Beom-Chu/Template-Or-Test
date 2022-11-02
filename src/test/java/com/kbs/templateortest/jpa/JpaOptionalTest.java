package com.kbs.templateortest.jpa;

import com.kbs.templateortest.jpa.entity.TestEntity;
import com.kbs.templateortest.jpa.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class JpaOptionalTest {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void test() {

        Optional<TestEntity> byId = testRepository.findById(1L);
        Optional<List<TestEntity>> allByName = testRepository.findAllByName("");

        System.out.println("[[[byId.isPresent() = " + byId.isPresent());
        System.out.println("[[[allByName.isPresent() = " + allByName.isPresent());
    }
}
