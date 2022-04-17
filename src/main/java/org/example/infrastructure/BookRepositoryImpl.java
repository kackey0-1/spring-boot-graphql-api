package org.example.infrastructure;

import org.example.infrastructure.mapper.BookMapper;
import org.example.model.BookFactory;
import org.example.model.BookRepository;
import org.example.model.RegistBookFactory;
import org.example.model.value.AuthorId;
import org.example.model.value.Name;
import org.example.types.RegistBookResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.types.Book;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class BookRepositoryImpl implements BookRepository {
    private final BookFactory bookFactory;
    private final RegistBookFactory registBookFactory;
    private final BookMapper bookMapper;

    @Override
    public List<Book> getBooksByAuthorId(AuthorId authorId) {
        return bookFactory.create(bookMapper.getBooksByAuthorId(authorId.getValue()));
    }

    @Override
    public RegistBookResponse registBook(AuthorId authorId, Name name) {
        boolean isRegist = true;
        String error = null;
        try {
            bookMapper.registBook(authorId.getValue(), name.getValue());
        } catch (Exception ex) {
            isRegist = false;
            error = ex.getMessage();
        }

        return registBookFactory.create(authorId.getValue(), name.getValue(), isRegist, error);
    }
}
