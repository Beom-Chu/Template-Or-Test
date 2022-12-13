package com.kbs.templateortest.jpa.repository;

import com.kbs.templateortest.jpa.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Modifying
    @Query("UPDATE Article a SET a.title = ?2 WHERE a.id = ?1")
    int updateTitle(Long id, String title);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Article a SET a.title = ?2 WHERE a.id = ?1")
    int updateTitle2(Long id, String title);

}
