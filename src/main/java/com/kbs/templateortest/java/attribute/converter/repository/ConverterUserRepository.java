package com.kbs.templateortest.java.attribute.converter.repository;

import com.kbs.templateortest.java.attribute.converter.entity.ConverterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConverterUserRepository extends JpaRepository<ConverterUser, Long> {
}
