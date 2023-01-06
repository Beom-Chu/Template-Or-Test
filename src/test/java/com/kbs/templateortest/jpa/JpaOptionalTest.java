package com.kbs.templateortest.jpa;

import com.kbs.templateortest.jpa.entity.TestEntity;
import com.kbs.templateortest.jpa.repository.TestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@DataJpaTest
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

    @Test
    @DisplayName("단건 객체 repository 조회시 결과값 없을때 에러 발생 여부 확인")
    public void testNoDate() {

        TestEntity byTop1ByName = testRepository.findTop1ByName("");

        System.out.println("[[[byTop1ByName = " + byTop1ByName);

        // 에러 발생은 안하고 null 반환
    }
}
