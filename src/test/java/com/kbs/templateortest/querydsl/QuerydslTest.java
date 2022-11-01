package com.kbs.templateortest.querydsl;

import com.kbs.templateortest.querydsl.entity.Hello;
import com.kbs.templateortest.querydsl.dto.QHello;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Transactional
//@Commit
public class QuerydslTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void test() {

        em.persist(new Hello());
        em.persist(new Hello());
        em.persist(new Hello());

        JPAQueryFactory query = new JPAQueryFactory(em);
        QHello qHello = QHello.hello;

        List<Hello> hellos = query.selectFrom(qHello).fetch();

        System.out.println("[[[hellos = " + hellos);

    }
}
