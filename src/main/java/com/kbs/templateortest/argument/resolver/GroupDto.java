package com.kbs.templateortest.argument.resolver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private String id;
    private String name;
    private String ipAddress;
    private String uri;
}
