package com.kbs.templateortest.java.attribute.converter.entity;

import com.kbs.templateortest.java.attribute.converter.converter.CustomConverter;
import lombok.*;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConverterUser {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Convert(converter = CustomConverter.class)
    private String convertName;
}
