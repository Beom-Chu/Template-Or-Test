package com.kbs.templateortest.java.attribute.converter.converter;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Converter
public class CustomConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return attribute + "-" + LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData.substring(0, dbData.indexOf("-"));
    }
}
