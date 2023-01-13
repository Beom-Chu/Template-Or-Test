package com.kbs.templateortest.mongodb.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("accounts")
@Data
@Builder
public class Account {
    @Id
    private String id;
    private String username;
    private String email;
    private String phoneNumber;
    private LocalDateTime regTime;
    private AccountRole accountRole;
    private Header header;
}
