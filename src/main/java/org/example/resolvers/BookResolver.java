package org.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.example.infrastructure.BookRepositoryImpl;
import org.example.model.value.AuthorId;
import org.example.types.Author;
import org.example.types.Book;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class BookResolver implements GraphQLResolver<Author> {
    private final BookRepositoryImpl bookRepositoryImpl;

    public List<Book> books(Author author) {
        AuthorId authorId = AuthorId.of(author.getId());
        return bookRepositoryImpl.getBooksByAuthorId(authorId);
    }
}
