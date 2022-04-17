package org.example.infrastructure;

import org.example.infrastructure.mapper.AuthorMapper;
import org.example.model.AuthorFactory;
import org.example.model.AuthorRepository;
import org.example.model.RegistAuthorFactory;
import org.example.model.value.Id;
import org.example.model.value.Name;
import org.example.types.Author;
import org.example.types.RegistAuthorResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class AuthorRepositoryImpl implements AuthorRepository {
    private final AuthorMapper authorMapper;
    private final AuthorFactory authorFactory;
    private final RegistAuthorFactory registAuthorFactory;

    @Override
    public Author getAuthorById(Id id) {
        return authorFactory.create(authorMapper.getAuthorById(id.getValue()));
    }

    @Override
    public RegistAuthorResponse registAuthor(Name name) {
        boolean isRegist = true;
        String errorMessage = null;
        try {
            authorMapper.registAuthor(name.getValue());
        } catch (Exception ex) {
            isRegist = false;
            errorMessage = ex.getMessage();
        }

        return registAuthorFactory.create(name.getValue(), isRegist, errorMessage);

    }
}
