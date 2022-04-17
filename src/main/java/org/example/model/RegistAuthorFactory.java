package org.example.model;

import org.example.types.RegistAuthorResponse;
import org.springframework.stereotype.Component;

@Component
public class RegistAuthorFactory {

    /**
     * create name for RegistAuthorResponse
     * @param name name
     * @return RegistAuthorResponse
     */
    public RegistAuthorResponse create(String name, boolean regist, String error) {
        return RegistAuthorResponse.builder().name(name).regist(regist).errorMessage(error).build();
    }
}
