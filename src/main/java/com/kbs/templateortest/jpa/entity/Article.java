package com.kbs.templateortest.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
}
