package com.kbs.templateortest.java.chaining;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
public class ChainingTest {

    @Test
    public void test() {
        Book book = new Book()
                .setId(10L).setName("bookName").setAuthor("bookAuthor")
                .setPublisher("bookPublisher").setPrice(new BigDecimal(30_000));
        
        System.out.println("[[[book1 = " + book);

        book.setPrice(new BigDecimal(40_000));
        System.out.println("[[[book2 = " + book);
    }
}
