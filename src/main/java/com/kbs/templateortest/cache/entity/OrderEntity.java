package com.kbs.templateortest.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    private int id;
    private String name;
    private long price;
    private long count;
}
