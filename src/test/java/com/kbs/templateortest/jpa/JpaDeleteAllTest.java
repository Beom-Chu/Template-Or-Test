package com.kbs.templateortest.jpa;

import com.kbs.templateortest.jpa.entity.TestEntity;
import com.kbs.templateortest.jpa.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@Transactional
public class JpaDeleteAllTest {

    @Autowired
    TestRepository testRepository;


    @Test
    void testDeleteAll() {
        testRepository.save(new TestEntity(1L, "kbs", "2023-06-13", LocalDateTime.now(), null));
        testRepository.save(new TestEntity(2L, "ljs", "2023-06-14", LocalDateTime.now(), null));

        List<TestEntity> testEntities = testRepository.findAll();
        System.out.println("[[[testEntities = " + testEntities);
        testRepository.deleteAll(testEntities);

        testRepository.flush();

        /* 쿼리 로그
        Hibernate:
            delete
            from
                test_entity
            where
                id=?
        2023-06-13 16:22:54.436 TRACE 20460 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [1]
        Hibernate:
            delete
            from
                test_entity
            where
                id=?
        2023-06-13 16:22:54.439 TRACE 20460 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [2]
         */

    }
    @Test
    void testDeleteAllInBatch() {
        testRepository.save(new TestEntity(1L, "kbs", "2023-06-13", LocalDateTime.now(), null));
        testRepository.save(new TestEntity(2L, "ljs", "2023-06-14", LocalDateTime.now(), null));

        List<TestEntity> testEntities = testRepository.findAll();
        System.out.println("[[[testEntities = " + testEntities);
        testRepository.deleteAllInBatch(testEntities);

        testRepository.flush();

        /*
        Hibernate:
            delete
            from
                test_entity
            where
                id=?
                or id=?
        2023-06-13 16:23:47.946 TRACE 24672 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [1]
        2023-06-13 16:23:47.946 TRACE 24672 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [2]
        */
    }
}
