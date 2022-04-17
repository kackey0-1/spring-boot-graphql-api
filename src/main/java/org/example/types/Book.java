package org.example.types;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    private int id;
    private String name;
    private String authorId;
}
