package org.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.example.infrastructure.AuthorRepositoryImpl;
import org.example.model.value.Name;
import org.example.types.RegistAuthorResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class AuthorMutationResolver implements GraphQLMutationResolver {
    private final AuthorRepositoryImpl authorRepositoryImpl;

    public RegistAuthorResponse registAuthor(String name) {
        Name nameValue = Name.of(name);
        return authorRepositoryImpl.registAuthor(nameValue);
    }
}
