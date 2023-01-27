package com.kbs.templateortest.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(columnDefinition = "Date")
    private String date;

    private LocalDateTime dateTime;

    @CreatedBy
    private String creator;
}
