package org.example.infrastructure.mapper;

import lombok.Data;

@Data
public class BookEntity {
    private int id;
    private String name;
    private String authorId;
    private AuthorEntity authorEntity;
}
