package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class TaskDto {
    @Setter
    private Long id;
    private String title;
    private String content;

}
