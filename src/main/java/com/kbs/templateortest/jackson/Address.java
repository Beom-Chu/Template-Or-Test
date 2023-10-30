package com.kbs.templateortest.jackson;

import lombok.*;

//@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    private String alias;
    private String addressName;
    private Long streetNumber;
}
