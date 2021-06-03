package com.crud.tasks.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@EqualsAndHashCode
public class TaskDto {
    private Long id;
    private String title;
    private String content;
}
