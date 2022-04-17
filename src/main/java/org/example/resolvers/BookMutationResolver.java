package org.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.example.infrastructure.AuthorRepositoryImpl;
import org.example.infrastructure.BookRepositoryImpl;
import org.example.model.value.AuthorId;
import org.example.model.value.Id;
import org.example.model.value.Name;
import org.example.types.Author;
import org.example.types.RegistBookResponse;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class BookMutationResolver implements GraphQLMutationResolver {
    private final BookRepositoryImpl bookRepositoryImpl;
    private final AuthorRepositoryImpl authorRepositoryImpl;

    public RegistBookResponse registBook(String authorId, String name) throws Exception {
        // 存在チェック
        Id id = Id.of(Integer.valueOf(authorId));
        Author author = authorRepositoryImpl.getAuthorById(id);
        if (Objects.isNull(author)) {
            throw new Exception("not find author. authorId:" + authorId);
        }

        AuthorId authorIdValue = AuthorId.of(Integer.valueOf(authorId));
        Name nameValue = Name.of(name);

        return bookRepositoryImpl.registBook(authorIdValue, nameValue);
    }
}
