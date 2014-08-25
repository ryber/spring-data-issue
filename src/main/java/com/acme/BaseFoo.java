package com.acme;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "foo")
public class BaseFoo {
    @Id
    private String id;
}
