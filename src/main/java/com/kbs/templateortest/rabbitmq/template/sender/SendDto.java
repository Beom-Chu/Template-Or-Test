package com.kbs.templateortest.rabbitmq.template.sender;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendDto {

    private String id;
    private String time;
    private String name;
}
