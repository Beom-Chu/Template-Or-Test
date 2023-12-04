package com.kbs.templateortest.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity implements Serializable {
    private int id;
    private String name;
    private long price;
    private long count;
}
