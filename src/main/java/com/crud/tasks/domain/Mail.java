package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
@Builder
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCc;

    public Optional<String> getToCcOptional(){
        return Optional.ofNullable(toCc);
    }
}
