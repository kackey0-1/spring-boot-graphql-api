package org.example.model;

import org.example.model.value.Id;
import org.example.model.value.Name;
import org.example.types.Author;
import org.example.types.RegistAuthorResponse;

public interface AuthorRepository {
    Author getAuthorById(Id id);
    RegistAuthorResponse registAuthor(Name name);
}
