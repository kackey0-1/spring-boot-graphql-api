package org.example.model;

import org.example.model.value.AuthorId;
import org.example.model.value.Name;
import org.example.types.RegistBookResponse;
import java.util.List;
import org.example.types.Book;

public interface BookRepository {
    List<Book> getBooksByAuthorId(AuthorId authorId);
    RegistBookResponse registBook(AuthorId authorId, Name name);
}
