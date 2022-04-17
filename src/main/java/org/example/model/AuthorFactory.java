package org.example.model;

import org.example.infrastructure.mapper.AuthorEntity;
import java.util.Objects;

import org.example.types.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorFactory {

    /**
     * create Author for AuthorEntity
     * @param authorEntity authorEntity
     * @return Author
     */
    public Author create(AuthorEntity authorEntity) {
        if (Objects.isNull(authorEntity)) {
            return null;
        }

        return Author.builder().id(authorEntity.getId()).name(authorEntity.getName()).build();
    }
}
