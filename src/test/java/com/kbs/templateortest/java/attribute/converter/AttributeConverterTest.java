package com.kbs.templateortest.java.attribute.converter;

import com.kbs.templateortest.java.attribute.converter.entity.ConverterUser;
import com.kbs.templateortest.java.attribute.converter.repository.ConverterUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@Rollback(value = false)
public class AttributeConverterTest {

    @Autowired
    private ConverterUserRepository converterUserRepository;

    @Test
    public void test() {

        String[] names = new String[]{"kbs", "ljs"};
        List<ConverterUser> converterUsers = new ArrayList<>();
        for(String name : names) {
            converterUsers.add(new ConverterUser().builder().name(name).convertName(name).build());
        }

        System.out.println("[[[converterUsers = " + converterUsers);

        converterUserRepository.saveAll(converterUsers);

        converterUserRepository.flush();

        List<ConverterUser> converterUserAll = converterUserRepository.findAll();

        System.out.println("[[[converterUserAll = " + converterUserAll);

    }
}
