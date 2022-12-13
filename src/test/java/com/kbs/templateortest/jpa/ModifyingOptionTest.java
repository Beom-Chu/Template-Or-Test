package com.kbs.templateortest.jpa;

import com.kbs.templateortest.jpa.entity.Article;
import com.kbs.templateortest.jpa.repository.ArticleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class ModifyingOptionTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    @Transactional
    @DisplayName("clearAutomatically false")
    public void testClearAutomaticallyFalse() {
        Article article = new Article();
        article.setTitle("before");
        articleRepository.save(article);

        int result = articleRepository.updateTitle(1L, "after");
        Assertions.assertEquals(result, 1);

        System.out.println(articleRepository.findById(1L).get().getTitle());
    }

    @Test
    @Transactional
    @DisplayName("clearAutomatically true")
    public void testClearAutomaticallyTrue() {
        Article article = new Article();
        article.setTitle("before");
        articleRepository.save(article);

        int result = articleRepository.updateTitle2(1L, "after");
        Assertions.assertEquals(result, 1);

        System.out.println(articleRepository.findById(1L).get().getTitle());
    }

}
