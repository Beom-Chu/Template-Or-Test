package com.kbs.templateortest.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class TestEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private LocalDate date;

    private LocalDateTime dateTime;
}
