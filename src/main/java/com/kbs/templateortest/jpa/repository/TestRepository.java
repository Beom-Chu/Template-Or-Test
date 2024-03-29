package com.kbs.templateortest.jpa.repository;

import com.kbs.templateortest.jpa.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
    Optional<List<TestEntity>> findAllByName(String name);

    TestEntity findTop1ByName(String name);

    List<TestEntity> findByDateTimeGreaterThanEqual(LocalDateTime dateTime);
}
